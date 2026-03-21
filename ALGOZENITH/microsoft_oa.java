import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class microsoft_oa {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        int t=  sc.nextInt();

        while(t-- > 0) {
        	int n= sc.nextInt();
        	int k = sc.nextInt();
        	int [] arr = new int[n+1];	
        	for( int i = 1; i <= n ; i++ ) arr[i] = sc.nextInt();
        	solve(n , k , arr);
        }


        out.flush();
    }

    static void solve(int n , int k , int [] arr  ) {
        // your solution here
    	int []dp = new int[n+1];
    	Arrays.fill(dp , Integer.MAX_VALUE);   	
    	/*
    	dp[i] -- minimum cost to reach index i from index
    	*/

    	TreeMap<Integer , Integer> tmap = new TreeMap<>();


    	tmap.put(0 , 1); //first element has incurred 0 cost

    	dp[0]=0;
    	
    	//we start from the second index.
    	for( int i = 1 ; i <= n ; i++ ) {
    		int min_from_map = tmap.firstKey(); // O(logK) -- O(1)
    		dp[i] = min_from_map + arr[i];

    		tmap.put(dp[i] , tmap.getOrDefault(dp[i], 0)+1);

    		if(i-k>=0){
    			int count = tmap.get(dp[i-k]);
    			if(count == 1) tmap.remove(dp[i-k]);
    			else tmap.put(dp[i-k] , count-1);
    		}
    	}




    	/*
    	Optimisation -- 
    		We can observe here that we need the minimum of previous k dp values 
    			dp[i] = min (dp[i-j] such that i-k <= j <= i-1)

    			We can use a Multiset in order to store the minimum of a window of dp[i] values.

    			At an index i : 
    				1. query the TreeMap<> for the minimum element
    			
    			    2. update answer dp[i] = min_from_multiset + arr[i];

    			    3. add dp[i] to the multiset

    			    4. decrement dp[i-k] frequency by -1 if i-k>=1

    			    5. if mp.get(dp[i-k]) == 0 remove the element



    			Whenever new element is inserted just add dp[i] to the set

    			Time complexity -- O(N*log(k)) (worst case)
    			Insertion & deletion in the map -- O(1)
				Balancing operation O(logK)

				Space complexity - (O(n) + O(k))


    	*/




        /*


        Here is my idea to Problem three in Weekly contest 464
        1. We have two choices at each step to go to right or left
        2. Intuition -- n<=1e5 -- cannot be dp , more towards greedy

        We have to find the maximum element so we can move towards left and keep 
        moving left till we get the maximum....

        3. From any index i we can directly move to anywhere to the left to get the maximum
        So, we will maintain a prefix max array which shows that for the current i
        what is the maximum element on the left of it including i.

        4. so our possible max answer could lie on pref_max[i] for every i.

        5. now, the second option is to go to right only when the elements are smaller
        but wait why we will go to right if elements are getting smaller..

        take this example [75, 5 , 100 , 2] suppose we are at index 2 a[2] = 5
        now from option we have answer as 75
        but but but we can go from 5 -> 2 coz 2 is on the right and less than 5 and again 
        go from 2 -> 100

        so a[2] = 100 can be achieved with two moves.

        so, what is always best -- greedy choice is go to pref-max[i] and if from there 
        you can go to right is always a better choice coz you can go directly to left and then to right
        or go to best answer and then go to right to explore more.

        2. Maintain a suffix_min array for each element i -- shows what is the minimum element on the right

        we are required to go to the extreme minimum so we will use binary search and if we get a better answer 
        we will store it.

        voila that's it

        dry_run 
        TestCase --
        


        arr :       9, 4, 7, 2, 16, 3,  1,  100, 22,  11
        pref_max : [9, 9, 9, 9, 16, 16, 16, 100, 100, 100]
        suff_min : [1, 1, 1, 1, 1, 1, 1, 11, 11, 11]

        We will also start counting from right to left 
        for ans[n-1] = no option to go to right so ans[n-1] = pref_max[n-1];
        and then for each 
            ans[i] = Math.max(pref_max[i] , get_from_binary_search(i+1 , n-1));
        return ans;

        */

    	System.out.println(dp[n]);


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
        String nextLine(){ String str=""; try{ if(s!=null&&s.hasMoreTokens()) str=s.nextToken("\\n"); else str=b.readLine(); } catch(IOException e){ e.printStackTrace(); } return str; }
    }
}