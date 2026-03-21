package Codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


import static java.lang.Math.*;
public class Startup {

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
            int n =   s.nextInt();
            int k =s.nextInt();
            int sum =0;
            HashMap<Integer , Integer > m = new HashMap<>();
            for(int i = 0; i < k ; i++ ) {
                int b = s.nextInt();
                int c = s.nextInt();
                sum +=c;
                m.put(b , m.getOrDefault(b , 0) +c);
            }
            solve(m , n , sum);
        }
    }

    static void solve(HashMap<Integer , Integer > m , int n   , int sum) {

        if(n >= m.size()) {
            //you have more shelves then put all brand bottles
            System.out.println(sum) ;
        }
        else {
            //put the
            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            for(int i  : m.keySet() ) {
                q.offer(m.get(i));
            }
            int ans = 0;
            for( int i = 0; i < n ; i++ ) {
                if (!q.isEmpty()) {
                    ans += q.poll();
                }
            }
            System.out.println(ans);
        }
    }
}
