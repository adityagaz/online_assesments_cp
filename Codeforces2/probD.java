package Codeforces;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class probD {
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
        while (t-- > 0 ) {
            int n = s.nextInt();
            int m = s.nextInt();
            List<List<Integer>> l = new ArrayList<>();
            List<List<Integer>> el = new ArrayList<>();
            for( int i = 0 ; i <n;i++) {
                List<Integer> s_l = new ArrayList<>();
                List<Integer> s_l_el = new ArrayList<>();
                int sum = 0;
                for(int j=0;j<m;j++){
                    int input =  s.nextInt();
                    s_l_el.add(input);
                    sum+=input;
                }
                el.add(s_l_el);
                s_l.add(i );
                s_l.add(sum);
                l.add(s_l);
            }

            solve(l , el);

        }

    }
    static void solve(List<List<Integer>> l , List<List<Integer>> el ) {
        Collections.sort(l , (a, b) -> {
            return b.get(1) - a.get(1);
        });
        //reverse sort
        long sum = 0;
        long p_sum  = 0;

        for(int i = 0 ; i < l.size();i++) {
            int idx = l.get(i).get(0);
            for( int j = 0 ; j < el.get(0).size() ; j++ ) {
                p_sum += el.get(idx).get(j);
                sum+=p_sum;
            }
        }
        System.out.println(sum);
    }
}
