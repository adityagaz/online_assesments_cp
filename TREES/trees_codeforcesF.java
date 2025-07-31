package TREES;
import java.util.*;


public class trees_codeforcesF {

    public static class Edge {
        int u;
        int v;
        int w;
        public Edge(int u , int v , int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    static int total_sum =0;
    static boolean [] vis;
    static int ans;
    static int[][] queries;
    static int  [] val;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt() , q = s.nextInt();
        List<Edge> tree = new ArrayList<>();
        val= new int[n];
        vis = new boolean[n];
        queries = new int[q][2];
        for( int i= 0 ; i < n ; i++ ) val[i]= s.nextInt();
        for( int i = 0 ; i+1 < n ; i++ ) {
            int u = s.nextInt();
            int v= s.nextInt();
            int w = s.nextInt();
            Edge ed = new Edge(u, v, w);
            tree.add(ed);
        }
        for( int i = 0 ; i <q; i++) {
            int v =  s.nextInt();
            int x = s.nextInt();
            queries[i][0]=v;
            queries[i][1]=x;
        }

        for( int i = 0 ; i < n; i++ ){
             
        }
    }

    static void dfs(int node , int parent , List<Edge> tree) {
        vis[node]=true;
        vis[parent]=true;
        for( Edge u : tree)  {
            if(!vis[u.u] && !vis[u.v]){

            }
        }

    }
}
