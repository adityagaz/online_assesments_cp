    package Codeforces.EDU;
    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    public class q1 {
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
            int  t = s.nextInt();
            while(t-- > 0 ){
                int n = s.nextInt();
                int [] arr = new int[n-2];
                for(int i = 0; i < n-2 ; i++ ) {
                    arr[i] = s.nextInt();
                }
                solve(arr ,n-2);
            }
        }

        static void  solve (int [] arr , int n) {

            for(int i  =0 ;i < n-2 ; i++) {
                if(arr[i] ==1 && arr[i+1]  == 0 && arr[i+2] == 1) {
                    System.out.println("NO");
                    return;
                }
            }
                System.out.println("YES");
        }
    }
