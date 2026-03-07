
import java.io.*;
import java.util.*;

public class A_Sublime_Sequence implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new A_Sublime_Sequence(), "whatever", 1 << 30).start();
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(System.out);
            FastReader sc = new FastReader();

            solve(sc);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    Small Observations:
        if n is even :
            +ve and -ve will cancel out
        else. :
            +-+- (+) will remain at last so answer will be x.


    Logic :


    */



    static void solve(FastReader sc) throws Exception {
        int t = sc.nextInt();
        // int t = 1;
        while (t-- > 0) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            if ((n&1)==1) {
                System.out.println(x);
            }
            else {
                System.out.println(0);
            }
        }
    }





    static class FastReader {
        BufferedReader b; StringTokenizer s;
        public FastReader() { b = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (s == null || !s.hasMoreElements()) { try { s = new StringTokenizer(b.readLine()); } catch (IOException e) { e.printStackTrace(); } } return s.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() { String str = ""; try { if (s != null && s.hasMoreTokens()) str = s.nextToken("\n"); else str = b.readLine(); } catch (IOException e) { e.printStackTrace(); } return str; }
    }
}