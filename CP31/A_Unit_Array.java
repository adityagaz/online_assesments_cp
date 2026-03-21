
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;
import java.util.StringTokenizer;
public class A_Unit_Array {

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
            Integer n = s.nextInt();
            Integer [] arr = new Integer[n];
            for( int i = 0; i < n ;i++ ) arr[i] = s.nextInt();
            solve(arr , n);
        }
    }

    static  void solve(Integer [] arr , int n) {
        int sum = 0;
        int count_neg = 0;
        int step = 0;
        for (int i : arr){
            sum+=i;
            if (i == -1){
                count_neg++;
            }
        }
        if (sum>=0 && count_neg%2==0){
            System.out.println(0);
            return;
        }
        int x = abs(sum);
        if (x%2==0) {
            step += x / 2;
        }
        else {
            step += x / 2 + 1;
        }
        if ((count_neg - step)%2==0){
            System.out.println(step);
        }
        else{
            System.out.println(step+1);
        }
    }
}

