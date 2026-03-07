import java.io.*;
import java.util.*;

public class C_1_Lost_Civilization_Easy_Version implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new C_1_Lost_Civilization_Easy_Version(), "whatever", 1 << 30).start();
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


    Logic :


    */



    static void solve(FastReader sc) throws Exception {

        int t = sc.nextInt();
        // int t = 1;

        while (t-- > 0) {
             int n = sc.nextInt();
             int [] arr = new int[n];
             for( int i = 0; i < n ; i++) arr[i] = sc.nextInt();
             int cnt = 1;
             Set<Integer> set= new HashSet<>();
             for(int i = 1; i < n ; i++) {
                if(arr[i] - arr[i-1] > 1 || set.contains(arr[i]))cnt++;
                set.add(arr[i]);
             }
             System.out.println(cnt);
             

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