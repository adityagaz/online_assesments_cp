package Graphs;
import java.util.*;
public class adjacencyList {
    public static void main  (String  [] args) {
        //we will now focus on representing the graph by the adjacency matrix
        //make the adjacency list
        List<List<Integer>> gp = new ArrayList<>();
        //add a new array list  in each node for graph
        int [][] edges  =  {{0,1},{1,2},{2,3},{1,3}};
        int no_of_edges = 4;
        for( int i =0 ; i  < no_of_edges ;i++ ) {
            gp.add(new ArrayList<>());
        }

        for(int [] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            gp.get(node1).add(node2);
            //in case of undirected graph we have to add node2 as node1
            gp.get(node2).add(node1);
        }
        for(List<Integer> edge : gp ) {
            System.out.println(edge);
        }

     }
}
