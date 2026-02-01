
import java.io.*;
import java.util.*;

public class amazon_oa {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) throws Exception {
        // setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        System.out.println("hello");
        int [] arr = new int[n+1];
        for( int i = 1 ; i <=  n; i++ ) arr[i]= sc.nextInt();
        int q = sc.nextInt();
        int c = sc.nextInt();
        long  [][] catalouge = new long[q+1][3];
        for( int i = 1 ; i <= q ; i++) {
        	catalouge[i][1]=sc.nextInt();
        	catalouge[i][2]=sc.nextInt();
        }

        System.out.println(Arrays.toString(arr));
        System.out.println( q + " " + " " + c);
        for( long [] i : catalouge ) {
        	System.out.println(Arrays.toString(i)); 
        }

        solveBrute(arr, catalouge , q, n);
 
        out.flush();
    }

    static void solveBrute( int [] arr , long [][] catalouge , int q , int n) {
    	long sum = Arrays.stream(arr).sum();
    	Arrays.sort(arr);
        long min = Long.MAX_VALUE;
    	for( int query = 1 ; query <= q ;  query++) {

    		for( int num = 1 ; num <= n ; num++) {
    			long c1=0 , c2=0;
    			long diff1 = arr[num] - catalouge[query][1];
    			c1 =  diff1 < 0 ?  -1L*diff1 : 0; 
    			long diff2 = (sum - arr[num] )- catalouge[query][1];
    			c2 = diff2 < 0  ? -1L*diff2 : 0;
    			min = Math.min(min , c1+c2);
    		}
    		System.out.println(min);
     	}

     	
    }

    static void solveBS(int [] arr , long [][] catalouge , int q , int n) {
    	long sum = 0L;
    	for( int i : arr) sum = (long)sum + i;

    	Arrays.sort(arr);
    	for( int query = 1 ; query <= q ;  query++) {
    		int [] options= new int[4];
    		long min = Long.MAX_VALUE;
    		options[1] = bs(query  , n , arr , catalouge , sum , true);
    		options[2] = bs(query  , n , arr , catalouge , sum , false);
    		options[3] = 1; // choose any index doesnot matter

    		for(int option = 1 ; option<= 3 ; option++) {
    			long a = arr[options[option]];
				long x = catalouge[query][1], y = catalouge[query][2];
				long c1 = Math.max(0L, x - a);                
				long c2 = Math.max(0L, y - (sum - a));
				min = Math.min(min, c1 + c2);
    		}
    		
    		System.out.println(min);
     	}



     	/*

     	Author : Kumar K (RAM RAM)
     	Student Approach - Aditya Shandilya 
     	we have to minimize =  | arr[i] - x | +  | rem - y |

     	where | | is a modulus -- >  
     							| f(|x|) = x  , x >= 0 |
     							|	     = -x , x <  0 |

     	Four cases -- 
			both +ve:

     		a[i] -x + rem - y -> sum - (x+y) --> minimize -->  any index same answer

     		first -ve:
			
			x - a[i] + rem - y -> rem - a[i] + x - y -- > sum - a[i] - a[i] + x - y
													 -- > (sum + x - y) - 2a[i]
													 	   \__________/   \___/
													 	   	 constant      var

													 	   	 It is a monotone


			second -ve:

			a[i] - x  + y - rem --> a[i] - rem + y - x -- > a[i] - (sum - a[i]) + y - x
															2a[i] - (sum + y - x)
															\___/	\__________/
															 var	   constant

															 It is a monotone too! ram ram
			both -ve:       

			x - a[i] + y - rem -->  (x+y) - rem -- > minimize --> any index same answer	


     	*/

    }

    static int bs(int query , int n ,int [] arr , long [][] catalouge , long sum , boolean flag) {
    	int l = 1 , r = n;
    	int ans = r;
    	while(l<=r) {
    		int mid = (l+r)>>>1; 
    		if(flag) {
    			if(check1(mid , query , catalouge , arr, sum )) {
	    			ans=mid;
	    			r = mid -1;
    			}
	    		else {
	    			l = mid +1;
	    		}
    		}
    		else {
    			if(check2(mid , query , catalouge , arr, sum )) {
	    			ans=mid;
	    			r = mid -1;
    			}
	    		else {
	    			l = mid +1;
	    		}

    		}
    	}

    	return ans;
    }

    static boolean check1(int mid ,int query, long [][] catalouge , int [] arr , long sum ) {
    	long x =catalouge[query][1];
    	long y = catalouge[query][2];

    	return 2*arr[mid] < (sum + y - x) ;
    }
    static boolean check2(int mid ,int query, long [][] catalouge , int [] arr , long sum ) {
    	long x =catalouge[query][1];
    	long y = catalouge[query][2];

    	return   (sum - y + x) < 2*arr[mid]  ;
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