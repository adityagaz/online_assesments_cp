package Graphs;
import java.util.*;

public class DFS_ADJACENCY_LIST {
    public static void main(String [] args) {
        int [][] edges  =  {{0,1},{1,2},{2,3},{1,3},{0,3}}; //given edges
        int v  = 4; //nodes are 0, 1 ... 3 (  0 to n-1)
        int start =0; //say start node is 0

        DFS(edges , start , v);
    }
    static void DFS(int [][] edges , int start , int n) {
        //make an adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> vis = new ArrayList<>();

        for( int i  = 0 ; i < n ; i++) {
            adj.add(new ArrayList<>());
            vis.add(0);
        }

        for( int [] edge : edges ) {
            int u  =  edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            //if undirected graph mentioned
            adj.get(v).add(u);
        }
       System.out.println( dfs(adj , start , vis));
    }
    static List<Integer> dfs(List<List<Integer>> adj , int v, List<Integer> vis) {
        if(vis.get(v) == 1) {
            //if the node is visited then no need to do it visit this again
            return  new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        //declare ans array to combine answers from below calls;
        vis.set(v , 1);
        //mark the incoming node as visited
        ans.add(v);
        //add to the visited list
        for( int i : adj.get(v)) {
            if(vis.get(i) != 1) {
                //if it is not in the visited list
                List<Integer> belowCalls = dfs(adj , i  , vis);
                //after the below calls are completed then add the below answers to the ans list
                ans.addAll(belowCalls);
            }
        }
        //finally return ans
        return ans;
    }

}
