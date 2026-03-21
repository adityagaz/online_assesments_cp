
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_Grasshopper_on_a_Line {
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
            int x = s.nextInt();
            int k = s.nextInt();
            solve(x,k);
        }
    }

    static void solve (int x , int k ) {
        if (k >  x) {
            System.out.println(1);
            System.out.println(x);
        }
        else {
            for( int st = x ; st>=1 ;st--) {
                if(st%k!=0) {
                    int mod = x % st;
                    if(mod == 0) {
                        System.out.println(1);
                        System.out.println(st);
                        return;
                    }
                    else {
                        System.out.println(x/st +1);
                        for( int i  = 0 ;i  < x/st ; i++) {
                            System.out.print(st +" ");
                        }
                        System.out.print(mod);
                        System.out.println();
                        return;
                    }
                }

            }
        }
    }


}
