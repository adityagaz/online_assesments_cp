package TREES;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class max_alternating_sum_at_each_node_from_root {
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
 
    final static long mod = 1000000007L;

     static long [] val;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            val = new long[n+1];
            for( int i = 1; i <= n ; i++ ) {
                val[i] = sc.nextInt();
            }
            List<List<Integer>> tree = new ArrayList<>();
            for( int i =  0 ; i <=n ;i++) {
                tree.add(new ArrayList<>());
            }
            for( int i = 0; i+1<n ; i++ ) {
                int u = sc.nextInt() , v = sc.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }
            boolean [] vis = new boolean[n+1];

            bfs(1 ,-1  , tree, vis,n);

        }
    }

    static void bfs(int start , int parent , List<List<Integer>> tree , boolean []vis,int n ) {
        long [] mxP = new long[n+1];
        long [] mxN = new long[n+1];
        mxP[1]= val[start];
        mxN[1]= -val[start];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start]=true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for( int i : tree.get(node)) {
                if(!vis[i]) {
                    vis[i]=true;
                    mxP[i] = Math.max(val[i] , val[i] + mxN[node]);
                    mxN[i] = Math.max(-val[i] , -val[i] + mxP[node]);
                    q.add(i);
                }
            }
        }

        for( long i : mxP) {
            System.out.print(i == 0 ? "" :  i + " ");
        }
        System.out.println();
    }

    
}
