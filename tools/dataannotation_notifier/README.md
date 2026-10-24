# DataAnnotation Project Notifier

Checks https://app.dataannotation.tech/workers/projects every few minutes
using your own logged-in browser session and **emails you as soon as a new
project appears** — so you don't miss Pacific-time drops while you sleep in India.

## Setup (once, ~10 minutes)

1. Install **Python 3.9+** (python.org; on Windows tick "Add Python to PATH").
2. In this folder, open a terminal and run:
   ```
   pip install -r requirements.txt
   python -m playwright install chromium
   ```
3. Create a **Gmail App Password**: Google Account → Security → turn on
   2-Step Verification → search "App passwords" → create one (16 letters).
4. Copy `.env.example` to `.env` and fill in your Gmail + that app password.
5. `python monitor.py test-email` → you should get a test mail.
6. `python monitor.py login` → a browser opens, log in to DataAnnotation,
   then press ENTER in the terminal. Your login is saved in `browser_profile/`.

## Every night

```
python monitor.py run
```
(on Windows you can just double-click `start_windows.bat`)

- First check emails you "notifier started" with the projects already visible.
- After that you get **"NEW DataAnnotation project! Go now"** whenever one appears.
- If your session expires you get a **"you got LOGGED OUT"** email — run `login` again.
- It stops Windows/macOS from sleeping while it runs. Keep the laptop **plugged in**
  and **lid open** (or set "closing the lid does nothing" in power settings).

## Make the email actually wake you up

On your phone's Gmail app, create a filter for subject `NEW DataAnnotation project`
→ mark important, and give Gmail notifications a loud sound / allow them through
Do Not Disturb (Android: Gmail → Settings → Notifications; iPhone: Focus → allowed apps).

## Notes

- `CHECK_INTERVAL_SECONDS` in `.env` (default 180s, randomised ±20%). Don't set it
  very low — no need to hammer the site, and check DataAnnotation's terms yourself.
- If it says "0 projects" even though you see some, open `last_page.html`
  (saved after each check) or set `HEADLESS=0` to watch what it sees.
- Delete `state.json` to reset the "already seen" list.
