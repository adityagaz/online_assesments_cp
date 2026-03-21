package Graphs;
import java.util.*;
public class CycleDetectionBFS {
    public static void main(String [] args) {
        int [][] ad = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        List<List<Integer>> adj = new ArrayList<>();
        for ( int i = 0 ;  i  < ad.length ; i++) {
            adj.add(new ArrayList<>());
            for(int j = 0 ; j < ad[i].length ; j++ ){
                adj.get(i).add(ad[i][j]);
            }
        }
        System.out.println(isCycle( adj));

     }
    static boolean isCycle(List<List<Integer>> adj) {
        List<Integer> visited = new ArrayList<>(Collections.nCopies(adj.size(), 0));
        for( int i = 0 ;i < adj.size() ; i++ ) {
            if(visited.get(i) !=1 && isCycle(adj , visited , i)) {
                return true;
            }
        }
        return false;
    }

     static boolean isCycle(List<List<Integer>> adj , List<Integer> visited , int start) {//bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int [] { start , -1});
        visited.set(start ,1 );
        while( !q.isEmpty()) {
            int [] curr= q.poll();
            int node = curr[0];
            int parent = curr[1];
            for(int neighbour : adj.get(node)) {
                if(visited.get(neighbour) == 1 && parent!=neighbour) {
                    //cycle detected
                    return true;
                }
                else if(visited.get(neighbour) != 1) {
                    q.add(new int [] {neighbour , node});
                    visited.set(neighbour , 1);
                }
            }
        }

        return false;
    }
}
