// package UNSEEN_QUESTIONS_WHICH_I_FUCKED_UP;
import java.io.*;
import java.util.*;

public class amazon_oa_greedy {

	/*
	Problem | AMAZON OA 27 AUGUST | 
	SLIDING WINDOW | GREEDY OBSERVATION

Problem -- 
	The manager of Amazon’s fulfillment center maintains inventory of a product 
	that comes in two variants:

	Variant A is represented by 0
	Variant B is represented by 1

You are given an array product of length n where 
product[i] is the variant of the i-th item (0 or 1). 
You are also given a positive integer k.

Variant B is no longer in demand. 
Your goal is to convert all items to variant A (i.e., make every array element 0) 
using the following operation any number of times, with minimum total cost.

Allowed operation (repeat as needed)

Choose a subarray [l, r] of exact length k (so 0 ≤ l ≤ r < n and r − l + 1 = k).

The cost of performing the operation on this subarray is
product[l] + product[l+1] + … + product[r] (i.e., the number of 1s inside it).

Within that subarray, choose one index p (l ≤ p ≤ r) and set product[p] to 0 (convert that item to variant A).

Task

Return the minimum total cost required to convert every element of product to 0.

Function to implement

long getMinimumCost(vector<int> product, int k)

Input: product (array of 0s and 1s), k (subarray length)

Output: the minimum total cost to make all entries 0

Constraints

1 ≤ k ≤ n ≤ 100000

product[i] ∈ {0, 1} for all 0 ≤ i < n

Input format for custom testing

First line: n

Next n lines: the elements of product (each 0 or 1)

Last line: k

Example

Example A
product = [1, 1, 0, 1], k = 4
One optimal sequence:

Choose [0, 3], set index 1 to 0; cost = 1+1+0+1 = 3 → [1,0,0,1]

Choose [0, 3], set index 0 to 0; cost = 1+0+0+1 = 2 → [0,0,0,1]

Choose [0, 3], set index 3 to 0; cost = 0+0+0+1 = 1 → [0,0,0,0]
Total cost = 3 + 2 + 1 = 6 (another valid sequence shown in the prompt totals 7).

Sample Case 0
Input:
n = 5
product = [1, 0, 1, 0, 1]
k = 3
One optimal sequence:

Choose [1,3], set index 2 to 0; cost 0+1+0 = 1 → [1,0,0,0,1]

Choose [0,2], set index 0 to 0; cost 1+0+0 = 1 → [0,0,0,0,1]

Choose [2,4], set index 4 to 0; cost 0+0+1 = 1 → [0,0,0,0,0]
Answer: 3

Sample Case 1
Input:
n = 4
product = [1, 1, 0, 1]
k = 3
One optimal sequence:

Choose [1,3], set index 1 to 0; cost 1+0+1 = 2 → [1,0,0,1]

Choose [0,2], set index 0 to 0; cost 1+0+0 = 1 → [0,0,0,1]

Choose [1,3], set index 3 to 0; cost 0+0+1 = 1 → [0,0,0,0]
Answer: 4
	

	Intuition -- 
	we have to minimize the cost of converting all ones to zeros by selecting a window of
	length k.
	Greedy choice is select the window with the minimum no of 1s. 
	Keep choosing the window until you have only one 1 left in the window.
	Now at each step you can select windows with k-1 zeros and 1 ones and it will 
	give the min cost.

	Total cost = make the min subarray have k-1 zeros and keep reducing and add the cost 
	+ total no of remaining ones in the array - min sum (because we counted it twice).

	Test Cases -
	First line -- t (no of test cases )
	Second line of each test case -- n, k
	Third line of each test case - represents a1, a2, a3...an


	18
	1 1
	0
	1 1
	1
	2 1
	1 0
	2 2
	1 1
	5 3
	1 0 1 0 1
	5 5
	1 1 0 1 0
	6 3
	1 0 1 1 0 1
	6 2
	0 0 0 0 0 0
	7 4
	1 1 1 0 1 0 0
	8 5
	0 1 1 0 1 1 0 1
	9 1
	1 0 1 1 1 0 0 1 0
	10 10
	1 0 1 0 0 1 0 1 1 0
	10 7
	0 1 1 1 0 0 1 0 0 1
	15 4
	1 1 0 1 0 0 1 1 1 0 0 1 0 1 0
	20 6
	1 0 0 1 1 0 1 1 0 0 1 0 1 0 0 1 1 1 0 0
	25 1
	1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
	25 25
	1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1
	30 13
	0 1 0 1 1 1 0 0 1 0 1 0 0 1 1 0 0 0 1 1 1 0 1 0 0 1 0 1 1 0

	Expected Outputs --
	0
	1
	1
	3
	3
	6
	5
	0
	4
	8
	5
	15
	8
	8
	11
	25
	91
	25


	*/
    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        
        int t = sc.nextInt();
        // int t = 1;

        while(t-- > 0) {
        	int n = sc.nextInt();
        	int k = sc.nextInt();
        	int [] arr =  new int[n];
        	for( int i = 0 ; i <n ; i++) arr[i] = sc.nextInt();
            solve(arr , n ,  k);
        }



        out.flush();
    }

     static void solve(int [] arr , int n , int k) {
    	int cnt  = 0;
    	int head = -1 , tail = 0 , ans = Integer.MAX_VALUE , s = -1;
    	
    	
    	int total_ones = Arrays.stream(arr).sum();
    	
		while (tail<= n-k) { 
		    while (head + 1 < n && (head - tail + 1 < k)) {
		        head++;
		        if (arr[head] == 1) cnt++;
		    }
		
		    if (head - tail + 1 == k && cnt < ans) { 
		        ans = cnt;
		        s = tail;
		    }
		    if (tail > head) {
		        tail++;
		        head = tail - 1;
		    } else {
		        if (arr[tail] == 1) cnt--;
		        tail++;
		    }
		}
    	
    	// System.out.println(ans + " " + " start : " + s + " end: " + (s+k-1));
    	int ops = (total_ones - ans) + ((ans)*(ans+1)/2);
		System.out.println(ops);
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