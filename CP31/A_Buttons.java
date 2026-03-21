

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class A_Buttons {

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
           int a  = s.nextInt();
           int b  = s.nextInt();
           int c  = s.nextInt();
            solve(a,b,c);
        }
    }
    static void solve(int a , int b , int c) {
        boolean chance = true;
        if(c % 2 != 0) {
            chance = false;
        }
        if(a  > b) {
            System.out.println("First");
        } else if ( a < b) {
            System.out.println("Second");
        }
        else {
            if(chance) {
                System.out.println("Second");
            }
            else {
                System.out.println("First");
            }
        }
    }
}
