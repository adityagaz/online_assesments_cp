

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;
import java.util.StringTokenizer;

public class C_Raspberries {
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
        FastReader s =new FastReader();
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();int k = s.nextInt();
            int [] arr = new int[n];
            for( int i = 0 ; i < n; i++) {
                arr[i] = s.nextInt();
            }

            solve(arr , n , k);
        }
    }

    static void solve(int [] arr  , int n , int k) {
        //if k ==4 then we have a different case but for prime numbers we have different case
        for( int i : arr) {
            if(i % k == 0)  {
                System.out.println(0);
                return;
            }
        }
        int mini = Integer.MAX_VALUE;
        for( int i : arr) {
            mini = min (mini,k - (i % k));
        }

        if(k!=4 ) System.out.println(mini);
        else {
            int even_count = 0; int ans = 0;
            for( int i : arr) {
                if(i % 2 == 0) even_count++;
            }
            if(even_count == 0) ans =2;
            else if (even_count == 1) ans =1;
            System.out.println(min(ans , mini));
        }
    }
}
