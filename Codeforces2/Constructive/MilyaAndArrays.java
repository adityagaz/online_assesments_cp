package Codeforces.Constructive;


import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class MilyaAndArrays {
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
            long [] a = new long[n];
            long [] b = new long[n];
            for ( int i= 0; i <  n ;i++){
                a[i]= s.nextInt();
            }
            for ( int i= 0; i <  n ;i++){
                b[i]= s.nextInt();
            }
            solve(b,a);
        }
    }

    static void solve(long [] b , long [] a)  {
        Set<Long> s1 = new HashSet<>();
        Set<Long> s2 = new HashSet<>();
        for(int i = 0; i < a.length ; i++) {
            s1.add(a[i]);s2.add(b[i]);
        }
        if(s1.size() * s2.size() >=3) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
