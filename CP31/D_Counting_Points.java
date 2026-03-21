
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class D_Counting_Points {
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
        int t= s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            long [] p = new long[n];
            long [] r = new long[n];
            for( int i =  0 ; i < n ; i++) p[i] = s.nextLong();
            for( int i =  0 ; i < n ; i++) r[i] = s.nextLong();
            solve(n, p ,r);
        }
    }
    static void solve(int n , long [] p ,long [] r) {
        HashMap<Long , Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long l_l = p[i] - r[i];
            long u_l = p[i] + r[i];
            for( long j = l_l ; j <= u_l ; j++ ) {
                    long r_2 = r[i]*r[i];
                    long x_xi = (j - p[i])*(j-p[i]);
                    long c = r_2 - x_xi;
                    if(c < 0) continue;
                    long d = (long) Math.sqrt(( double) c);
                    if(d*d > c) d--;
                    long ans = 2 *d +1;
                    long find = map.getOrDefault(j  , 0L);
                    map.put(j , Math.max(find , ans));
            }
        }
        long ans = 0;
        for( Long i : map.keySet())
        {
            ans += map.get(i);
        }

        System.out.println(ans);
    }
}
