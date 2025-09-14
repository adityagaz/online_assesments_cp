import java.io.*;
import java.util.*;

public class print_all_cycles_in_directed_graph {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;


    static List<List<Integer>> g;
    static int [] vis;
    static List<Integer> any_cycle;
    static List<List<Integer>> all_cycles;

    static List<Integer> parent;

    static boolean isCycle =true;


    public static void main(String[] args) throws Exception {
        setupIO();
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        
        int t = sc.nextInt();
        // int t = 1;

        while(t-- > 0) {

        	int n = sc.nextInt();
        	int e = sc.nextInt();

        	g = new ArrayList<>();
        	parent = new ArrayList<>(n+1);
        	any_cycle = new ArrayList<>();
        	all_cycles = new ArrayList<>();
        	vis = new int[n+1];
        	Arrays.fill(vis, 1);
        	for( int i = 0 ; i <= n ; i++ ) {
        		g.add(new ArrayList<>());
        		parent.add(0);
        	}
        	for( int i = 0; i < e ; i++ ) {
        		int u = sc.nextInt();
        		int v = sc.nextInt();
        		g.get(u).add(v);
        	}

        	for( int i = 1 ; i <= n ; i++ ){
        		if(vis[i]==1){
        			dfs(i , 0);
        		}
        	}

        	System.out.println(all_cycles);

        }



        out.flush();
    }

    static void dfs(int node , int par ) {
    	vis[node] = 2;
    	parent.set(node , par);
    	for( int nei : g.get(node)) {
    		if(vis[nei] == 1 ) {
    			dfs(nei  , node);

    		}
    		else if(vis[nei] == 2) {
    			//already visited and again looking at that edge
    			int temp = node;
    			while(temp != nei) {
    				any_cycle.add(temp);
    				temp = parent.get(temp);
    			}
    			any_cycle.add(temp);
    			Collections.reverse(any_cycle);
    			all_cycles.add(any_cycle);
    			any_cycle = new ArrayList<>();
    		}

    	}
    	// when complete assign label 3
    	vis[node] = 3;
    }

    // —— MODULAR ARITHMETIC ——
   

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