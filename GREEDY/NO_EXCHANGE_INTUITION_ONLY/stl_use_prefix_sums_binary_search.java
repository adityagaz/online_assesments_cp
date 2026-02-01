

import java.io.*;

import java.util.*;


/*
  PROBLEM - GREEDY OPTIMISATION | BINARY SEARCH | MULTISETS
  You have N objects. The price of the i-th object is A[i].

There are Q independent queries. In each query, you’re given an amount of money M. 
You must report the maximum number of objects you can buy with at most M money. 
You can buy each object at most once. (Queries are independent; 
you don’t actually remove items—just compute the count.)

Input

First line: two integers N and Q.

Second line: N space-separated integers A[1..N] — the prices.

Next Q lines: each line has one integer M — the total money for that query.

Output

For each query, print one integer on its own line: the maximum number of objects you can buy.

Constraints

1 ≤ N, Q ≤ 100000

1 ≤ A[i] ≤ 100000000

1 ≤ M ≤ 100000000

Test Cases
Test Case 1 (basic sample)

Input

5 4
1 4 2 9 6
1
5
10
25


Expected Output

1
2
3
5

Test Case 2 (M smaller than the cheapest price → answer 0)

Input

4 3
5 2 7 3
1
2
4


Expected Output

0
1
1

Test Case 3 (all prices equal; check exact prefix sums)

Input

6 3
2 2 2 2 2 2
2
4
12


Expected Output

1
2
6

Test Case 4 (duplicates and in-between M)

Input

5 5
3 1 2 2 4
1
2
3
6
7


Expected Output

1
1
2
3
3

Test Case 5 (large values to ensure 64-bit prefix sums)

Input

3 4
100000000 100000000 100000000
99999999
100000000
200000000
300000000


Expected Output

0
1
2
3

Test Case 6 (unsorted prices; M between prefix sums)

Input

5 4
4 10 5 7 1
8
9
10
11


Expected Output

2
2
3
3

Test Case 7 (buy all with big M)

Input

7 2
8 6 5 4 3 2 1
100
3


Expected Output

7
2

Test Case 8 (many small items; several queries around boundaries)

Input

8 6
1 1 1 2 2 3 5 8
0
1
3
4
6
13


Expected Output

0
1
3
4
6
8
 */
public class stl_use_prefix_sums_binary_search {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;


    public static  class Node {
    	long val, idx;
    	Node(long val , long idx) {
    		this.val = val;
    		this.idx = idx;
    	}

    }

    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        
        // int t = sc.nextInt();
        int t = 1;

        while(t-- > 0) {
        	int n = sc.nextInt();
        	int q = sc.nextInt();
        	int [] arr = new int[n];
        	long [] pref = new long[n+1];

        	for( int i = 0 ;i < n ; i++) arr[i] = sc.nextInt();
        	Arrays.sort(arr);
        	TreeSet<Node> tset = new TreeSet<>((a , b) -> {
        		return a.val == b.val ? Long.compare(a.idx, b.idx) :
        		Long.compare(a.val, b.val);
        	});
        	for( int i = 1; i <= n ; i++ ) {
        		pref[i] = (long)( arr[i-1] + pref[i-1]);
        	}


        	System.out.println(Arrays.toString(arr));
        	System.out.println(Arrays.toString(pref));
        	for( int i = 1;  i <= n ; i++) {
        		tset.add(new Node(pref[i] , i));
        	}
        	for( int i = 0 ; i < q ; i++) {
        		long query = sc.nextInt();
        		// Node  res = tset.lower(new Node(query , Integer.MAX_VALUE));
        		int res = bs(pref , query); // we can also use bs on prefix sum...
        		long ans = (res ==pref.length) ? 0  : res;
        		printl(ans);
        	}
        }

        out.flush();
    }

    static int bs(long [] pref , long query) {
    	int l = 1, r = pref.length-1;
    	int ans = pref.length;
    	while(l<=r){
    		int mid = l+(r-l)/2;
    		if(pref[mid] > query ) {
    			r = mid -1;
    		}
    		else {
    			ans = mid;
    			l = mid +1;
    		}
    		
    	}
    	return ans;
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
    String inputPath  = "C:\\Users\\adity\\Documents\\ALGOZENITH\\input.txt";
    String outputPath = "C:\\Users\\adity\\Documents\\ALGOZENITH\\output.txt";

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