package Codeforces;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;

public class KDivisibleSum {
        // FastReader class for efficient input
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
            FastReader  s = new FastReader();
            int t = s.nextInt();
            while( t-- > 0 ) {
                long n = s.nextLong();
                long k = s.nextLong();
//                System.out.println(n+" "+k);
                System.out.println(solve(n , k));
            }
        }

        static long solve( long n , long k) {
            long lo = 1;
            long hi = k;
            long ans = 1;
            while(lo <= hi) {
                long mid = lo + (hi - lo) /2;
                if(checker(n ,mid , k)) {
                    ans = mid;
                    hi = mid-1;
                }
                else {
                    lo = mid +1;
                }
            }
            return ans;
        }

        static boolean checker(long n , long mid , long k) {
            long min =  ((n + k - 1) / k) * k; //ceil value
            if(n * mid >= min) return true ; else  return false;
        }
}
