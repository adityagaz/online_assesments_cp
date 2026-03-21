package Graphs;
import java.util.*;
public class BFS_ADJACENCY_MATRIIX {
    public static void main (String  [] args) {
        int nodes = 5; // 0 .. 4
        int [][] edges =  {{0,1},{1,2},{2,3},{1,3},{0,3}};
        int [][] gp = new int[nodes][nodes];
        for( int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            gp[u][v] =1 ;
            gp[v][u] =1; //undirected graph
        }
        int source = 0; //assume source
        bfs(gp ,source );
    }
    static void bfs(int [][] gp , int source) {
        //make a visited array
        int no_of_nodes = gp.length;
        List<Integer> vis = new ArrayList<>();
        for (int i = 0 ; i <  no_of_nodes ; i++) {
            vis.add(0);
        }
        //make a queue
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis.set(source , 1);
        while(!q.isEmpty()) {
            int curr  = q.poll();
            System.out.print(curr + " ");
            for( int  i = 0; i < gp.length ; i++) {
                if(vis.get(i) ==0 && gp[curr][i] !=0) {
                    q.add(i);
                    vis.set(i, 1);
                }
            }
        }
    }
}
