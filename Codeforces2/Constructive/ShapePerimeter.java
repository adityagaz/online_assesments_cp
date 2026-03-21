package Codeforces.Constructive;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;
public class ShapePerimeter {
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
            int m = s.nextInt();
            int [] x = new int[n];
            int [] y = new int[n];
            for( int i =0 ; i < n ; i++) {
                x[i] = s.nextInt();
                y[i] = s.nextInt();
            }

            solve(x , y ,n , m);
        }
    }

    static void solve(int [] x , int [] y , int n , int m ) {
        int l_x = x[0];
        int l_y = y[0];
        int h_x = l_x + m;
        int h_y = l_y + m;
        int max = n* (4*m);
        int p=0;
        for( int i = 1 ; i < n ; i++) {
            int comp_x = l_x+x[i];int comp_y = l_y + y[i];
            int d_x = h_x - comp_x;
            int d_y = h_y - comp_y;
            if(d_x > 0 && d_y > 0) {
                p = 2 * (d_x + d_y);
            }
            else {
                p = 2 * max(d_x , d_y);
            }
            max -= p;
            l_x = comp_x;l_y=comp_y;
            h_x = l_x + m;h_y = l_y+m;
        }
        System.out.println(max);
    }

}
