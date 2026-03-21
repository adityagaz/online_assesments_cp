
import java.io.*;
import java.util.StringTokenizer;

public class B_Gellyfish_and_Baby_s_Breath {

    static class FastReader {

        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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

    static FastReader sc = new FastReader();
    static OutputStream outputStream = System.out;
    static PrintWriter out = new PrintWriter(outputStream);

    final static int mod = 998244353;
    static long[] arr_powers = new long[100001];
    public static void main(String[] args) {

        arr_powers[0] = 1;
        for (int i = 1; i <= 100000; i++) {
            arr_powers[i] = (arr_powers[i - 1] * 2) % mod;
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p= new int[n];
            int[] q = new int[n];
            for (int i = 0; i < n; i++) p[i] = sc.nextInt();
            for (int i = 0; i < n; i++) q[i] = sc.nextInt();
            solve(p,q,n,arr_powers);
        }
    }

    static void solve(int[] p, int [] q, int n , long[]arr_powers) {
        int[] maxp_val = new int[n];
        int[] posp_idx = new int[n];
        int curP = -1 , curPosP = -1;
        for (int i = 0; i < n; i++) {
            if (p[i] > curP) {curP = p[i];curPosP = i;}
            maxp_val[i] = curP;posp_idx[i] = curPosP;
        }
        int[] maxq_val = new int[n];
        int[] posq_idx = new int[n];
        int curMaxQ = -1,curPosQ = -1;
        for (int i = 0; i < n; i++) {
            if (q[i] > curMaxQ) {curMaxQ = q[i];curPosQ = i;}
            maxq_val[i] = curMaxQ;
            posq_idx[i] = curPosQ;
        }
        long [] ans = new long[n];
        for( int i = 0; i<n;i++) {
            int a_val = maxp_val[i], idx_p = posp_idx[i] ,b_val = maxq_val[i] , idx_q = posq_idx[i];
            int x , y;
            if(a_val>b_val) {
                x= a_val;y=q[i-idx_p];
            }
            else if(b_val > a_val) {
                x=b_val;y=p[i-idx_q];
            }else {
                x = a_val;
                y = Math.max(p[i-idx_q] , q[i-idx_p]);
            }
            long temp = arr_powers[x] + arr_powers[y];
            if(temp>=mod) temp-=mod;
            ans[i]=temp;
        }

        for(long i : ans) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
