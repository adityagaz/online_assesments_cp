
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class A_We_Need_the_Zero {
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
        while(t-- > 0 ) {
            int  n = s.nextInt();
            int [] arr = new int[n];
            for( int i =0 ; i < n ; i++ ) arr[i]  = s.nextInt();
            solve(n , arr);
        }
    }

    static void solve(int n , int [] arr ) {
        int x_or = 0;

        for( int i : arr) x_or ^= i;
        for ( int i =0 ;  i < n ;i++ )  arr[i] ^= x_or;
        int a =0;
        for( int i : arr) {
            a^=i;
        }
        if(a == 0) {
            System.out.println(x_or);
        }
        else {
            System.out.println(-1);
        }

    }
}
