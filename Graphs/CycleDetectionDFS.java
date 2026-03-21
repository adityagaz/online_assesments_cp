package Graphs;
import java.util.*;
public class CycleDetectionDFS {

    public static void main  (String [] args) {
        int [][] ad =  {{},{2} , {1,3}, {2}};
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0 ;  i  < ad.length ; i++) {
            adj.add(new ArrayList<>());
            for(int j = 0 ; j < ad[i].length ; j++ ){
                adj.get(i).add(ad[i][j]);
            }
        }
         //can do cycle detection by checking ki if a graph has the node visited and it is not the parent
        //we need to pass the parent in each recursive call
        List<Integer> visited = new ArrayList<>(Collections.nCopies(adj.size(), 0));

        System.out.println(isCycle(adj));

    }

    static boolean isCycle(List<List<Integer>> adj) {
        List<Integer> visited = new ArrayList<>(Collections.nCopies(adj.size(), 0));
        for( int i = 0 ;i < adj.size() ; i++ ) {
            if(visited.get(i) !=1 && undirected_graph_cycle_dfs(adj , -1, i, visited)) {
                return true;
            }
        }
        return false;
    }

    static boolean  undirected_graph_cycle_dfs(List<List<Integer>> adj ,int parent , int start , List<Integer> visited ) {
        if(visited.get(start) == 1) {
            return false;
        }
        visited.set(start ,1);
        boolean ans = false;
        for( int i  : adj.get(start)) {
            if(visited.get(i) ==1 ) {
               if(parent != i ) {
                   return true;
               }
            }
            else {
                ans = ans | undirected_graph_cycle_dfs(adj , start , i , visited);
            }
        }
        return ans;
    }
}
