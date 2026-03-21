package Graphs.DirectedGraph;
import java.util.*;
public class CycleDFS {

    public static void main (String [] args) {
        int [][] ad = {{3,1} , {2} , {3} , {0}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for ( int i = 0 ;  i  < ad.length ; i++) {
            adj.add(new ArrayList<>());
            for(int j = 0 ; j < ad[i].length ; j++ ){
                adj.get(i).add(ad[i][j]);
            }
        }
        System.out.println(isCyclic(adj.size() , adj));
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        List<Integer> visited = new ArrayList<>();
        List<Integer> inrec = new ArrayList<>();
        for( int i = 0 ; i < V ; i++ ) {
            visited.add(0);inrec.add(0);
        }
        for( int i = 0 ; i< V ;i++) {
            if(dfs_directed(adj , visited , inrec , i)){
                return true;
            }
        }
        return false;
    }
    static boolean dfs_directed( ArrayList<ArrayList<Integer>> adj , List<Integer> visited , List<Integer> inrec , int start ) {
        if(visited.get(start) == 1) {
            return false;
        }
        visited.set(start , 1);
        inrec.set(start , 1);
        boolean answer = false;
        for( int i : adj.get(start) ) {
            if(visited.get(i)==1 && inrec.get(i) == 1 ) {
                //cycle detected
                answer = true;
                return answer;
            }
            else {
                answer = answer | dfs_directed(adj , visited , inrec , i);
            }
        }
        inrec.set(start , 0);
        return answer;
    }

}
