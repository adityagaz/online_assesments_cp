
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class A_Extremely_Round {

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
            solve( n);
        }
    }

    static void  solve(int n) {



        int x = (int) Math.floor(Math.log10(n));
        double total = 9 * x + Math.floor(n / Math.pow(10, x));
        System.out.println((int) total);
        // if (n <= 10) {
        //         System.out.println(n);
        //         return;
        //     }
        //     int num = (int) Math.log10(n) ;
        //     num = (n - (n % ((int) Math.pow(10 , num))));
        //     if (num == 10) {
        //         System.out.println(10);
        //         return;
        //     }
        //     int ans = 1;
        //     while (num > 10) {
        //         num /= 10;
        //         ans += 9;
        //     }
        //     System.out.println(ans + num - 1);
    }
}
