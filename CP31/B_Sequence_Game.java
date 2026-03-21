
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_Sequence_Game {
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
            int [] arr = new int[n];
            for( int i = 0; i < n ;i++ ) arr[i] = s.nextInt();
            solve(arr , n);
        }
    }

    static void solve(int [] arr , int n ) {
        List<Integer> l = new ArrayList<>();
        l.add(arr[0]);
        for( int i =1;i < n ; i++ ){
            if(arr[i-1] <= arr[i]) {
                l.add(arr[i]);
            }
            else {
                l.add(1);
                l.add(arr[i]);
            }
        }
        System.out.println(l.size());
        for( int i : l) {
            System.out.print(i + " ");
        }
        System.out.println();
     }

}
