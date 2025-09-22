import java.io.*;
import java.util.*;

public class BFS_0_1 implements Runnable {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;


    public static void main(String[] args) {
        new Thread(null, new BFS_0_1 (), "whatever", 1 << 30).start();
    }

    @Override
    public void run() {
        try {
            setupIO(); 
            out = new PrintWriter(System.out);
            FastReader sc = new FastReader();

            solve(sc);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    BFS 0 - 1

    We use 0 - 1 bfs whenever the graph only has the weights 0 or 1
    Instead of using Djikstra's we use 0-1 BFS to optimise it to O(V+E)

    Uses- 
    i. The graph in the use cases will be given as matrix most of the times in 
    disguise. There will be walls in the matrix if we go through wall we need to break it
    and it incurs at cost of 1 otherwise cost is zero. 

    Modelling -- One task - 0 cost , Others - + 1 cost 

    Example - At each cell we have up , down , left , right written 
    If we move in any other direction than specified we incur a cost of 1. 
    otherwise 0.

    Similar problems on codeforces can be seen where we have to model the problem into a graph one
    then apply SSSP algos or MSSP.

    0-1 BFS also works on the multisource points.

    The idea is whenever we push into the queue we have two choices that 
    	i. neighbour is at a same distance as this node. + 0 
    	ii. neighbour is at a distance one more than node. + 1

    	So, To process the neighbours with same distance with require them to be put again in the queue
    	before the one distance ones.


    	voila!

    	IN 0-1 BFS we use Deque where we can insert at the front and the end both.
		
		Changes --
			We insert the neighbour with the same distance in the front of the queue and neighbour with + 1 
			distance at the end of the queue.

			This suffices because, we traverse in the order of shortest distances.


			A node can atmost can inserted in the dequeue at most two times 

			T.C - O(2 * (V+E)
			S.C - o(2 * N)




    */
    public static class Pair {
    	int e ,w;
    	public Pair( int y ,int z)  {
    		e=y;w=z;
    	}
    }
    static List<List<Pair >> g;
    static int [] vis;
    static int [] dist;
    static void solve(FastReader sc ) throws Exception {

        // int t = sc.nextInt();
        int t = 1;

        while(t-- > 0) {
        	int n = sc.nextInt();
        	int m = sc.nextInt();
        	g = new ArrayList<>();
        	vis = new int[n+1];
        	dist = new int[n+1];
        	for(int i  = 0; i <= n ; i++ ) {
        		g.add(new ArrayList<>());
        	}
        	for( int i  = 0; i < m; i++)  {
        		int u = sc.nextInt();
        		int v = sc.nextInt();
        		int w = sc.nextInt();

        		g.get(u).add(new Pair(v, w));
        		g.get(v).add(new Pair(u , w));
        	}

        	BFS01(1);

           System.out.println(Arrays.toString(dist));
        }

    }

   	static void BFS01 (int node ) {
   		ArrayDeque<Integer> dq = new ArrayDeque<>();
   		Arrays.fill(dist, (int)1e9);
   		dist[node] = 0;
   		dq.add(node);
   		while(!dq.isEmpty()) {
   			int currNode= dq.poll();
   			//standard practice

   			if(vis[currNode]==1) continue;
   			vis[currNode] = 1;

   			//standard practice

   			for( Pair neigh : g.get(currNode)) { // check all neighbours
   				int nei = neigh.e;
   				int w = neigh.w;

   				if( dist[nei] > dist[currNode] + w ) { // relax
   					dist[nei] = dist[currNode] + w;
   					
   					//update
   					if(w == 0) {
   						dq.addFirst(nei);
   					}
   					else {
   						dq.addLast(nei);
   					}

   				}

   			}
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