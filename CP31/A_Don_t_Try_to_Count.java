

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_Don_t_Try_to_Count {
    static class FastReader {

        // BufferedReader to read input
        BufferedReader b;

        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader
                    (new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
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

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
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
    public static void main(String[] args) {
        FastReader s = new FastReader();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            String x = s.nextLine();
            String str = s.nextLine();
            solve(x, str, n ,m);
        }
    }

    static void solve(String x , String s , int n , int  m ) {
        int ans = 0;
        if(x.contains(s)) {
            System.out.println(ans);
            return;
        }
        if(n < m ) {

            while(x.length() < s.length()) {
                x=x+x;
                ans++;
            }
            if(x.contains(s)) {
                System.out.println(ans);
            }
            else {
                x=x+x;
                if(x.contains(s)) {
                    System.out.println(ans+1);
                }
                else {System.out.println("-1");}
            }
         }
        else  {
            x = x+x;
            if(x.contains(s)) {
                System.out.println(1);
                return;
            }
            else {
                System.out.println(-1);
            }
        }
    }

}
