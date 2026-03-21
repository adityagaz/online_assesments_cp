
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class C_Target_Practice {

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
        while (t-- > 0) {
            char [][] mat = new char[10][10];
            for( int i = 0; i < 10 ;i++ ) {
                String temp = s.nextLine();
                for( int j = 0; j < 10 ;j++) {
                    mat[i][j] = temp.charAt(j);
                }
            }
            solve(mat);
        }
    }

    static void solve(char [][] mat  ) {
        int res = 0;
        for( int i = 0; i < 10 ;i++ ) {
            for( int j = 0; j < 10 ;j++) {
                if(mat[i][j] == 'X') {
                    res+= calc(mat , i , j);
                }
            }
        }
        System.out.println(res);

    }

    static int calc(char [][] mat , int x , int y) {
        int start =0;
        int ans = 0;
        for( int i = start ; i < 5 ;i++) {
            if(((x >= start && x <= 9-start) && (y == start || y ==  9- start))
                    || ((y >= start && y <= 9-start) && (x == start || x == 9- start))) {
                return start+1;
            }
            start++;
        }
        return  ans;
    }
}
