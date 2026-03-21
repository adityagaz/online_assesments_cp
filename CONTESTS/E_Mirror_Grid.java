

import java.io.*;
import java.util.StringTokenizer;

public class E_Mirror_Grid {

    static class FastReader {

        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static FastReader sc = new FastReader();
    static OutputStream outputStream = System.out;
    static PrintWriter out = new PrintWriter(outputStream);

    final static long mod = 1000000007L;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String [] str = new String[n];
            for( int i = 0 ; i < n ; i++ ) {
                str[i] = sc.nextLine();
            }
            char [][] arr = new char[n][n];
            for( int i  = 0; i < n ; i++ ) {
                for( int j = 0 ; j < n; j++ ) {
                    arr[i][j]=str[i].charAt(j);
                }
            }
            solve(arr, n);
        }
    }

    static void solve(char[][] arr, int n) {

      /*(i, j)
(j, n−1−i)
(n−1−i, n−1−j)
(n−1−j, i) */
        
        int min = 0;
        for( int i =0 ; i < (n+1)/2 ; i++ ) {
            for( int j = 0; j< n/2 ; j++ ) {
              int cnt =0 ;
                if(arr[i][j] == '1') cnt++;
                if(arr[j][n-i-1] == '1') cnt++;
                if(arr[n-1-i][n-1-j]== '1' ) cnt++;
                if(arr[n-1-j][i] == '1') cnt++;
                min += Math.min(cnt, 4-cnt);
            }
        }
        System.out.println(min);
    }

}
