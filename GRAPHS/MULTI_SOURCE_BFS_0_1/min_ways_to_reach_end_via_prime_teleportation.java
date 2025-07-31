import java.io.*;
import java.util.*;


// Amazing leetcode problem 
//-- https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation/

public class min_ways_to_reach_end_via_prime_teleportation {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        
        int [] arr = new int[n];

        for( int i = 0 ; i < n ; i++ )  {
        	arr[i]= sc.nextInt();
        	
        }
        
        int ans = solve(arr);


        // List<List<Integer>> mat = new ArrayList<>();
        // int [] arr = {1,2,3,4,5};
        // for( int i = 0; i < 2; i++) mat.add(new ArrayList<>());
        // for( int i = 0; i < arr.length ; i++) {
        // 	mat.get(i).add(10);
        // }
        // System.out.println(mat);


        out.flush();
    }

 static int solve2( int [] arr) {
        // your solution here
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        Map<Integer , List<Integer>> map = new HashMap<>();
        for( int i = 0; i < arr.length ;i++ ){
        	max = Math.max(max , arr[i]);
        	map.computeIfAbsent(arr[i] , x-> new ArrayList<>()).add(i);
        }
        


        boolean [] primes = sieve(max+1);
        List<List<int [] >> g = new ArrayList<>();
        for( int i = 0 ; i <= (arr.length + primes.length ); i++ ) {
        	g.add(new ArrayList <>());
        }
        int g_node = n;
		for (int i = 0; i + 1 < n; i++) {
		    g.get(i).add(new int[]{i+1, 1});
		    g.get(i+1).add(new int[]{i,   1});
		    if (primes[arr[i]]) {
		        g.get(i).add(new int[]{g_node, 0});
		        g.get(g_node).add(new int[]{i, 1});
		        for (int mul = arr[i]; mul <= max; mul += arr[i]) {
		            List<Integer> hits = map.get(mul);
		            if (hits != null) {
		                for (int j : hits) {
		                    if (j != i) {
		                        g.get(g_node).add(new int[]{j, 1});
		                    }
		                }
		                hits.clear();
		            }
		        }
		        g_node++;
		    }
		}
        


        int [] minDis = new int[n+g_node+1];
        Arrays.fill(minDis ,(int)1e7);
        minDis[0] = 0;
        Queue<int []> q= new LinkedList<>();
        q.add(new int [] {0 , 0});
        while(!q.isEmpty()) {
        	int [] cur = q.poll();
        	int idx = cur[0];
        	int level = cur[1];
        	if(minDis[idx] < level) continue;
        	for(int [] node : g.get(idx)) {
        		
        			if(level + node[1] < minDis[node[0]]) {
        				minDis[node[0]] = level+ node[1];
        				q.add(new int [] {node[0] , level + node[1]});
        			}
        	}

        }
        printl(minDis);
        return minDis[n-1];
    
}


















    static int solve( int [] arr) {
        // your solution here
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for( int i = 0; i < arr.length ;i++ ){
        	max = Math.max(max , arr[i]);
        }
        boolean [] primes = sieve(max+1);
        List<List<int [] >> g = new ArrayList<>();
        for( int i = 0 ; i <= (arr.length + primes.length ); i++ ) {
        	g.add(new ArrayList <>());
        }
        int g_node = n;
        for( int i = 0; i + 1< n ; i++ ) {
        	g.get(i).add(new int[] {i+1 , 1});
        	g.get(i+1).add(new int [] {i , 1});
        	if(primes[arr[i]])  {
        		g.get(g_node).add(new int [] {i , 1});
        		g.get(i).add(new int [] { g_node , 0});
        		for( int j = 0 ; j < n; j++ ) {
        			if(i==j)continue;
        			if((arr[j] % arr[i] )== 0 ) {
        				//it's a multiple
        				g.get(g_node).add(new int [] {j , 1});
        			}
        		}
        		g_node++;
        	}
        }
        for ( int i = 0 ; i +1< n ; i++) {
        	if((arr[i] % arr[n-1]) == 0 ) {
        		g.get(g_node).add(new int [] {i , 1});
        	}
        }


        int [] minDis = new int[n+g_node+1];
        Arrays.fill(minDis ,(int)1e7);
        minDis[0] = 0;
        Queue<int []> q= new LinkedList<>();
        q.add(new int [] {0 , 0});
        while(!q.isEmpty()) {
        	int [] cur = q.poll();
        	int idx = cur[0];
        	int level = cur[1];
        	if(minDis[idx] < level) continue;
        	for(int [] node : g.get(idx)) {
        		
        			if(level + node[1] < minDis[node[0]]) {
        				minDis[node[0]] = level+ node[1];
        				q.add(new int [] {node[0] , level + node[1]});
        			}
        	}

        }
        printl(minDis);
        return minDis[n-1];
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