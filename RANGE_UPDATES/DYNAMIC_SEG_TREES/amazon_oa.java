package RANGE_UPDATES.DYNAMIC_SEG_TREES; // comment this line to run in online compilers...

import java.io.*;
import java.util.*;

public class amazon_oa {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    /*
    Author - Aditya Shandilya
    PROBLEM - AMAZON OA | RANGE UPDATES DYNAMIC | MULTISETS | STRING
    Amazon data analysts are analyzing a string of length n, called data. 
    The string is processed through q operations given by a 2D array called queries.

    Each query is of one of the following two types:

    Type 1: [1, i, x] Given integers i and x, 
    change the i-th character of data to the x-th lowercase English letter.

    Type 2: [2, l, r] Given integers l and r, 
    determine the number of distinct characters in the substring of data 
    between the l-th and r-th characters (inclusive).

    Example:

    Let n = 7, data = "abcccda", q = 5, and 
    queries = [[2, 1, 5], [1, 3, r], [2, 1, 3], [1, 7, c], [2, 1, 7]]

    Then:
    i = 2, l = 1, r = 5 "abccc" contains 3 kinds of letters: b, c, and a → answer = [3]
    i = 1, x = 3 → data = "abcccda"
    i = 2, l = 1, r = 3 "abc" contains 3 kinds of letters: c → answer = [3]
    i = 1, x = 7 → data = "abcccda"
    i = 2, l = 1, r = 7 "abcccda" contains 4 kinds of letters: a, b, c, d → answer = [4]

    Output - 
    3
    3
    4

    Test Cases 
    Input:
    1
    7
    abccbda
    5
    2 3 6
    1 2 3
    2 2 4
    1 1 5
    2 1 7

    Output:
    3
    1
    5

    Approach - Make 26 TreeSets to maintain the frequencies of what element occurs in what range and then 
    if a type 1 query comes then remove the previous index from the characters and update the index in new character
    in type 2 query do a .floor() on the tree set and then you can find the largest numbers <= r
    if that number is also >= l then we have to count it 
    we will do it for all 26 characters. and voila we have got the answer.

    // TC -- O( Nlog(N) + Q*26*Log(N)) 
    //         \____/    \_________/
    //         building     querying

    // SC -- O(26*N)



    */


    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        // int t = 1;

        while(t-- > 0) {
        	int n = sc.nextInt();
        	sc.nextLine();

        	char [] string = new char[n+1];
        	String  ip = sc.nextLine();
        	for( int i = 1 ; i <= n ; i++ ) {
        		string[i] = ip.charAt(i-1);
        	}
        	int queries = sc.nextInt();
        	int [][]  q = new int[queries][3];
        	for( int i = 0 ; i < queries; i++ ) {
        		int type = sc.nextInt();
        		int x = sc.nextInt(); 
        		int y = sc.nextInt();
        		q[i][0]=type;
        		q[i][1]=x;
        		q[i][2]=y;
        	}

        	

            solveOptimal( n , queries , string , q);
        }



        out.flush();
    }

    static void solveOptimal( int n  , int queries , char[] string , int [][] q) {
        // your solution here
    	List<TreeSet<Integer>> ds  = new ArrayList<>(26);
    	for( int i = 0 ; i < 26 ; i++ ) ds.add(new TreeSet<>());
    	for( int i =  1 ; i <= n ; i++ ) {
    		int ch = string[i];
    		ds.get(ch - 'a').add(i);
    	}
        for( int i = 0 ; i < queries ; i++ ) {
            int type= q[i][0];
            if(type==1) {
                //update
                int char_to_be_replaced = string[q[i][1]]-'a';
                int char_replaced_with = q[i][2]-1;
                ds.get(char_to_be_replaced).remove(q[i][1]);
                ds.get(char_replaced_with).add(q[i][1]);

                //O(2*Log(N)) update
            }
            else {

                int ul = q[i][2];
                int cnt = 0;

                for( int j = 0 ; j < 26 ; j ++) {
                    if(ds.get(j).floor(ul)!=null) {
                        if(q[i][1] <= ds.get(j).floor(ul)) {
                            cnt++;
                        }
                    }
                }

                //O(26*log(n)) query
                printl(cnt);

            }

             // TC -- ( Nlog(N) + Q*26*Log(N)) 
             //         \____/    \_________/
            //         building     querying
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