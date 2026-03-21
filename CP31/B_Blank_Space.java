
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;
import java.util.StringTokenizer;
public class B_Blank_Space {

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
        while(t-- > 0) {
            int n = s.nextInt();
            Integer [] arr = new Integer[n];
            for( int i = 0; i < n ;i++ ) arr[i] = s.nextInt();
            solve(arr , n);
        }
    }
    static void solve(Integer [] arr , int n  ) {
        int max_ = 0;
        int ctr =0;
        for( int i : arr) {
            if( i ==0 ) {
                ctr++;
                max_ = max(max_ , ctr);
            }
            else  {
                ctr =0;
            }
        }
        System.out.println(max_);

    }
}
