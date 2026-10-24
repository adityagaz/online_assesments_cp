"""
DataAnnotation project notifier.

Keeps checking https://app.dataannotation.tech/workers/projects in a real
(headless) Chromium browser using YOUR logged-in session, and emails you the
moment a new project shows up.

Usage:
    python monitor.py login        # one time: opens a browser, you log in
    python monitor.py test-email   # check that email sending works
    python monitor.py run          # start watching (leave it running)
"""

import json
import os
import random
import smtplib
import sys
import time
from datetime import datetime
from email.mime.text import MIMEText
from pathlib import Path

from dotenv import load_dotenv
from playwright.sync_api import TimeoutError as PWTimeout
from playwright.sync_api import sync_playwright

HERE = Path(__file__).resolve().parent
load_dotenv(HERE / ".env")

PROJECTS_URL = "https://app.dataannotation.tech/workers/projects"
PROFILE_DIR = HERE / "browser_profile"   # keeps your login cookies
STATE_FILE = HERE / "state.json"         # projects already seen
DEBUG_HTML = HERE / "last_page.html"     # last page fetched, for debugging

SMTP_HOST = os.getenv("SMTP_HOST", "smtp.gmail.com")
SMTP_PORT = int(os.getenv("SMTP_PORT", "587"))
SMTP_USER = os.getenv("SMTP_USER", "")
SMTP_PASSWORD = os.getenv("SMTP_PASSWORD", "")
EMAIL_TO = [e.strip() for e in os.getenv("EMAIL_TO", SMTP_USER).split(",") if e.strip()]
INTERVAL = int(os.getenv("CHECK_INTERVAL_SECONDS", "180"))
HEADLESS = os.getenv("HEADLESS", "1") != "0"


def log(msg):
    print(f"[{datetime.now():%Y-%m-%d %H:%M:%S}] {msg}", flush=True)


# ---------------------------------------------------------------- email

def send_email(subject, body):
    if not (SMTP_USER and SMTP_PASSWORD and EMAIL_TO):
        log("!! Email not configured (check .env) - would have sent: " + subject)
        return False
    msg = MIMEText(body, "plain", "utf-8")
    msg["Subject"] = subject
    msg["From"] = SMTP_USER
    msg["To"] = ", ".join(EMAIL_TO)
    for attempt in range(3):
        try:
            with smtplib.SMTP(SMTP_HOST, SMTP_PORT, timeout=30) as s:
                s.starttls()
                s.login(SMTP_USER, SMTP_PASSWORD)
                s.sendmail(SMTP_USER, EMAIL_TO, msg.as_string())
            log(f"Email sent: {subject}")
            return True
        except Exception as e:  # network blips etc.
            log(f"Email failed (attempt {attempt + 1}): {e}")
            time.sleep(5 * (attempt + 1))
    return False


# ---------------------------------------------------------------- keep PC awake

def keep_awake():
    """Stop Windows/macOS from sleeping while the monitor runs."""
    if sys.platform == "win32":
        import ctypes
        ES_CONTINUOUS, ES_SYSTEM_REQUIRED = 0x80000000, 0x00000001
        ctypes.windll.kernel32.SetThreadExecutionState(ES_CONTINUOUS | ES_SYSTEM_REQUIRED)
        log("Windows sleep disabled while monitor runs.")
    elif sys.platform == "darwin":
        import subprocess
        subprocess.Popen(["caffeinate", "-i", "-w", str(os.getpid())])
        log("macOS sleep disabled while monitor runs (caffeinate).")


# ---------------------------------------------------------------- state

def load_state():
    if STATE_FILE.exists():
        try:
            return json.loads(STATE_FILE.read_text(encoding="utf-8"))
        except Exception:
            pass
    return {"seen": {}, "initialized": False}


def save_state(state):
    STATE_FILE.write_text(json.dumps(state, indent=2, ensure_ascii=False), encoding="utf-8")


# ---------------------------------------------------------------- scraping

# Runs inside the page. Collects one entry per project, trying several
# strategies so it keeps working if the site layout changes a bit.
EXTRACT_JS = r"""
() => {
  const clean = s => (s || "").replace(/\s+/g, " ").trim();
  const out = {};

  // 1) Links to individual projects (most reliable identity).
  for (const a of document.querySelectorAll("a[href]")) {
    const href = a.getAttribute("href");
    if (!/\/projects?\/[^\/?#]+/i.test(href)) continue;
    if (/\/workers\/projects\/?$/i.test(href)) continue;
    const row = a.closest("tr, li, [role=row], .card, .project") || a;
    out["link:" + href] = clean(row.innerText).slice(0, 400) || clean(a.innerText);
  }

  // 2) Table rows (projects page is usually a table).
  if (Object.keys(out).length === 0) {
    for (const tr of document.querySelectorAll("table tbody tr, [role=row]")) {
      const t = clean(tr.innerText);
      if (t && !/^no\s/i.test(t)) out["row:" + t.slice(0, 200)] = t.slice(0, 400);
    }
  }

  return {
    items: out,
    url: location.href,
    bodyText: clean(document.body ? document.body.innerText : "").slice(0, 20000),
    hasPassword: !!document.querySelector("input[type=password]"),
  };
}
"""


def fetch_projects(page):
    page.goto(PROJECTS_URL, wait_until="domcontentloaded", timeout=60000)
    try:
        page.wait_for_load_state("networkidle", timeout=20000)
    except PWTimeout:
        pass
    page.wait_for_timeout(2000)  # let any JS-rendered lists settle
    data = page.evaluate(EXTRACT_JS)
    try:
        DEBUG_HTML.write_text(page.content(), encoding="utf-8")
    except Exception:
        pass
    logged_out = data["hasPassword"] or "sign_in" in data["url"] or "login" in data["url"]
    return data, logged_out


def open_context(p, headless):
    """Open the real installed Google Chrome (not Playwright's test browser),
    with automation markers removed, so requests look like normal browsing."""
    PROFILE_DIR.mkdir(exist_ok=True)
    return p.chromium.launch_persistent_context(
        str(PROFILE_DIR),
        channel="chrome",
        headless=headless,
        no_viewport=True,
        ignore_default_args=["--enable-automation"],
        args=["--disable-blink-features=AutomationControlled", "--start-maximized"],
    )


# ---------------------------------------------------------------- commands

def cmd_login():
    with sync_playwright() as p:
        ctx = open_context(p, headless=False)
        page = ctx.pages[0] if ctx.pages else ctx.new_page()
        page.goto(PROJECTS_URL)
        print("\nA browser window opened. Log in to DataAnnotation there")
        print("(tick 'remember me' if offered) until you can see your projects page.")
        input("Then come back here and press ENTER... ")
        data, logged_out = fetch_projects(page)
        ctx.close()
    if logged_out:
        print("Still looks logged out. Run `python monitor.py login` again.")
    else:
        print(f"Login saved. Currently detected {len(data['items'])} project(s):")
        for v in data["items"].values():
            print("  -", v[:120])
        print("\nNow run: python monitor.py run")


def cmd_test_email():
    ok = send_email("DataAnnotation notifier: test email",
                    "If you can read this, email alerts are working.")
    print("OK - check your inbox." if ok else "FAILED - check your .env settings.")


def cmd_run():
    keep_awake()
    state = load_state()
    logout_alert_sent = False
    errors_in_row = 0
    log(f"Watching {PROJECTS_URL} every ~{INTERVAL}s. Press Ctrl+C to stop.")

    with sync_playwright() as p:
        ctx = open_context(p, headless=HEADLESS)
        page = ctx.pages[0] if ctx.pages else ctx.new_page()

        while True:
            try:
                data, logged_out = fetch_projects(page)
                errors_in_row = 0

                if logged_out:
                    log("Logged out! Run `python monitor.py login` again.")
                    if not logout_alert_sent:
                        send_email("DataAnnotation notifier: you got LOGGED OUT",
                                   "The monitor can't see your projects because the session "
                                   "expired.\nRun `python monitor.py login`, then `python "
                                   "monitor.py run` again.")
                        logout_alert_sent = True
                else:
                    logout_alert_sent = False
                    items = data["items"]
                    new = {k: v for k, v in items.items() if k not in state["seen"]}

                    if not state["initialized"]:
                        # First run: remember what's already there, confirm by email.
                        lines = "\n".join(f"- {v}" for v in items.values()) or "(none right now)"
                        send_email(f"DataAnnotation notifier started ({len(items)} projects visible)",
                                   f"Monitoring is ON. You'll get an email when a NEW project "
                                   f"appears.\n\nCurrently visible:\n{lines}\n\n{PROJECTS_URL}")
                        state["initialized"] = True
                    elif new:
                        lines = "\n\n".join(f"- {v}" for v in new.values())
                        log(f"NEW PROJECT(S): {len(new)}")
                        send_email(f"NEW DataAnnotation project ({len(new)})! Go now",
                                   f"New project(s) just appeared:\n\n{lines}\n\n"
                                   f"Open: {PROJECTS_URL}\n\nTotal visible now: {len(items)}")
                    else:
                        log(f"No new projects ({len(items)} visible).")

                    now = datetime.now().isoformat(timespec="seconds")
                    for k, v in items.items():
                        state["seen"].setdefault(k, {"text": v, "first_seen": now})
                    save_state(state)

            except KeyboardInterrupt:
                raise
            except Exception as e:
                errors_in_row += 1
                log(f"Check failed ({errors_in_row} in a row): {e}")
                if errors_in_row == 10:
                    send_email("DataAnnotation notifier: checks keep failing",
                               f"Last error: {e}\nIs the internet down? The monitor keeps trying.")
                if errors_in_row % 3 == 0:  # browser may be wedged; restart it
                    try:
                        ctx.close()
                    except Exception:
                        pass
                    ctx = open_context(p, headless=HEADLESS)
                    page = ctx.pages[0] if ctx.pages else ctx.new_page()

            time.sleep(INTERVAL * random.uniform(0.8, 1.2))


def main():
    cmd = sys.argv[1] if len(sys.argv) > 1 else "run"
    {"login": cmd_login, "test-email": cmd_test_email, "run": cmd_run}.get(
        cmd, lambda: print(__doc__))()


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        log("Stopped.")
