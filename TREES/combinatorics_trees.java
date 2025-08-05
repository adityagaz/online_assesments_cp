// package TREES;
// TOPICS - COMBINATORICS | TREES | CODEFORCES 1800 | DFS
//https://codeforces.com/contest/2117/problem/F
import java.io.*;
import java.util.*;

public class combinatorics_trees {
    static List<List<Integer>> tree;

    final static long mod = 1_000_000_007L;
    static PrintWriter out;
    static int cnt;
    static int [] left_right;
    static int bN = 0 , bP = 0 , bD = 0;
    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        // int t = 1;
        int t = sc.nextInt();
        while(t-- > 0) solve(sc);
        out.flush(); 
    }

    static void solve(FastReader sc ) {
            bN= 0;
            bP =0;
            bD =0;
            tree = new ArrayList<>();
            int n=sc.nextInt();
            for( int i  = 0 ; i<= n+1 ; i++ ) {
                tree.add(new ArrayList<>());
            }
            for( int i = 0 ; i < n-1 ; i++ ) {
                int u = sc.nextInt();int v =sc.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            left_right = new int[2];
            int leaves = 0;

            for( int i= 2 ; i <= n ; i++) {
                if(tree.get(i).size()==1 ) leaves++; 
            }
            if(leaves <=1 ) {
                System.out.println(powMod(2, n, mod));
                return;
            }
            if(leaves > 2) {
                System.out.println(0);
                return;
            }


            dfs(1 , 0, 1);
            int left = 0;
            int right = 0;
            int cnt = bD;
            int offset =0;
            for( int i : tree.get(bN)) {
                if(i != bP){
                    left_right[offset++] = i;
                }
            }

            left = dfs_len(left_right[0], bN );
            right = dfs_len(left_right[1] , bN);


            long ans =powMod(2, cnt, mod); 
            int way1 = Math.max(0 , Math.abs(left - right) -1);
            int way2 = Math.abs(left  - right);
            ans = ((long) ans % mod  *  (powMod(2,way1, mod)  + powMod(2,way2, mod)) %mod)%mod ;
            // if(left - right == 0) {
            //     ans =  ((long) ans * 2 ) % mod;
            // }
            System.out.println(ans);
    }

    static int dfs_len(int start , int  parent) 
    {
        int cnt  = 1;
        for( int i : tree.get(start)) {
            if(i == parent) continue;
            cnt += dfs_len(i , start);
        }
        return cnt;
    }



     static void dfs(int start , int parent , int depth) {

        int child = 0;
        for( int i : tree.get(start)) {
            if(i!= parent) child++;
        }
        if(child >= 2 && bN ==0 ) {
            bN = start;
            bP = parent;
            bD = depth;
            return;
        }
        for( int i : tree.get(start)) {
            if(i!= parent) {
                dfs(i , start , depth+1);
            }
            if(bN != 0) return;
        }

        
    }
    // —— MODULAR ARITHMETIC ——
    private static long modExp(long a, long e, long m) { long res = 1; a %= m; while (e > 0) { if ((e & 1) == 1) res = res * a % m; a = a * a % m; e >>= 1; } return res; }
    private static long invMod(long x)                 { return modExp(x, mod - 2, mod); }

    // —— COMBINATORICS ——
    static long[] fact, invFact;
    private static void buildFactorials(int N)        { fact = new long[N+1]; invFact = new long[N+1]; fact[0] = 1; for (int i = 1; i <= N; i++) fact[i] = fact[i-1] * i % mod; invFact[N] = modExp(fact[N], mod-2, mod); for (int i = N; i > 0; i--) invFact[i-1] = invFact[i] * i % mod; }
    private static long nCr(int n, int r)             { return (r < 0 || r > n) ? 0 : fact[n] * invFact[r] % mod * invFact[n-r] % mod; }
    private static long nPr(int n, int r)             { return (r < 0 || r > n) ? 0 : fact[n] * invFact[n-r] % mod; }

    // —— SIEVE & PRIME CHECK ——
    private static boolean[] sieve(int N)             { boolean[] isp = new boolean[N+1]; Arrays.fill(isp,true); isp[0]=isp[1]=false; for(int p=2;p*p<=N;p++) if(isp[p]) for(int q=p*p;q<=N;q+=p) isp[q]=false; return isp; }
    private static boolean isPrime(long x)            { if(x<2) return false; for(long i=2;i*i<=x;i++) if(x%i==0) return false; return true; }

    // —— KMP PREFIX FUNCTION ——
    private static int[] prefixFunction(String s)     { int n=s.length(),j=0; int[] pi=new int[n]; for(int i=1;i<n;i++){ while(j>0&&s.charAt(i)!=s.charAt(j)) j=pi[j-1]; if(s.charAt(i)==s.charAt(j)) j++; pi[i]=j;} return pi; }

    // —— UTILITY PRINT METHODS ——
    private static void printl(long[] arr)            { for(long v:arr) out.print(v+" "); out.println(); }
    private static void printl(int[] arr)             { for(int  v:arr) out.print(v+" "); out.println(); }
    private static void print(int v)                  { out.print(v); }
    private static void printl(int v)                 { out.println(v); }
    private static void print(long v)                 { out.print(v); }
    private static void printl(long v)                { out.println(v); }
    private static void print(char v)                 { out.print(v); }
    private static void printl(char v)                { out.println(v); }
    private static void print(String s)               { out.print(s); }
    private static void printl(String s)              { out.println(s); }

    // —— ARRAY / MATRIX READERS ——
    private static int[]  intArr(int n)               { int[]  a=new int[n]; for(int i=0;i<n;i++) a[i]=new FastReader().nextInt(); return a; }
    private static long[] lngArr(int n)               { long[] a=new long[n]; for(int i=0;i<n;i++) a[i]=new FastReader().nextLong(); return a; }
    private static double[] dblArr(int n)             { double[]a=new double[n]; for(int i=0;i<n;i++) a[i]=new FastReader().nextDouble(); return a; }
    private static int[][] intMatrix(int n,int m)     { int[][] mat=new int[n][m]; for(int i=0;i<n;i++) for(int j=0;j<m;j++) mat[i][j]=new FastReader().nextInt(); return mat; }
    private static long[][] longMatrix(int n,int m)   { long[][]mat=new long[n][m]; for(int i=0;i<n;i++) for(int j=0;j<m;j++) mat[i][j]=new FastReader().nextLong(); return mat; }

    // —— MISC HELPERS ——
    private static int gcd(int a,int b)               { return b==0?a:gcd(b,a%b); }
    private static long gcdL(long a,long b)           { return b==0?a:gcdL(b,a%b); }
    private static int lcm(int a,int b)               { return a/gcd(a,b)*b; }
    private static long lcmL(long a,long b)           { return a/gcdL(a,b)*b; }
    private static List<Integer> getDivisors(int n)   { List<Integer> ls=new ArrayList<>(); for(int i=1;i<=Math.sqrt(n);i++) if(n%i==0){ ls.add(i); if(n/i!=i) ls.add(n/i);} return ls; }
    private static List<Long>    getDivisors(long n)  { List<Long>    ls=new ArrayList<>(); for(long i=1;i<=Math.sqrt(n);i++) if(n%i==0){ ls.add(i); if(n/i!=i) ls.add(n/i);} return ls; }
    private static List<Integer> primeFactors(int n)  { List<Integer>ls=new ArrayList<>(); for(int c=2;n>1;c++) while(n%c==0){ ls.add(c); n/=c;} return ls; }
    private static List<Long>    primeFactors(long n) { List<Long>   ls=new ArrayList<>(); for(long c=2;n>1;c++) while(n%c==0){ ls.add(c); n/=c;} return ls; }
    private static long fact(int x)                   { return x<2?1:x*fact(x-1); }
    private static long powMod(long x,long y,long p) { long r=1; x%=p; while(y>0){ if((y&1)==1) r=r*x%p; x=x*x%p; y>>=1;} return r; }
    private static long pow(long a,long b)           { long r=1; while(b>0){ if((b&1)==1) r=r*a%mod; a=a*a%mod; b>>=1;} return r; }

private static void setupIO() throws Exception {
    String inputPath  = "C:\\Users\\adity\\Documents\\DSA_OA\\input.txt";
    String outputPath = "C:\\Users\\adity\\Documents\\DSA_OA\\output.txt";

    System.setIn(new FileInputStream(inputPath));
    System.setOut(new PrintStream(new FileOutputStream(outputPath)));
}

    // —— FASTREADER ——
    static class FastReader {
        BufferedReader b; StringTokenizer s;
        public FastReader() { b = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while(s==null||!s.hasMoreElements()){ try { s=new StringTokenizer(b.readLine()); } catch(IOException e){ e.printStackTrace(); } } return s.nextToken(); }
        int nextInt()    { return Integer.parseInt(next()); }
        long nextLong()  { return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next()); }
        String nextLine(){ String str=""; try{ if(s!=null&&s.hasMoreTokens()) str=s.nextToken("\n"); else str=b.readLine(); } catch(IOException e){ e.printStackTrace(); } return str; }
    }
}
