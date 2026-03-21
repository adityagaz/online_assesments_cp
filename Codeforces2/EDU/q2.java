package Codeforces.EDU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.*;

public class q2 {

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

           int m = s.nextInt();
           int [][] mat = new int[n][m];

            for(int i = 0; i < n ; i++ ) {
               for(int j = 0 ; j < m ; j++ ){
                   mat[i][j] = s.nextInt();
               }
            }
            solve(mat , n , m);
        }
    }
    static  void solve(int [][] mat , int n , int m) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> unique =  new HashSet<>();

        for(int i = 0; i < n ; i++ ) {
            for(int j = 0 ; j < m ; j++ ){
                if((i + j) % 2 == 0) {
                    s1.add(mat[i][j]);
                }
                else {
                    s2.add(mat[i][j]);
                }
                unique.add(mat[i][j]);
            }
        }
        int ops = 0;
        int toSubtract = 0;
        for( int i : unique) {
            if(s1.contains(i) && s2.contains(i) ) {
                toSubtract = 2;
                ops+=2;
            }
            else  {
                toSubtract =1;
                ops++;
            }

        }
        System.out.println(ops -toSubtract);
    }
}
