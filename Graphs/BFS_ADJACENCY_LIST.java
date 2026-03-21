package Graphs;
import java.util.*;

public class BFS_ADJACENCY_LIST {
    public static void main (String [] args) {
        int [][] edges  =  {{0,1},{1,2},{2,3},{1,3},{0,3}};

        int v  = 4; //nodes are 0, 1 ... 3 (  0 to n-1)
        //making an adjacency list
        List<List<Integer>> gp = new ArrayList<>();
        for ( int i =0 ; i  < v ; i++) {
            gp.add(new ArrayList<>());
        }
        for( int [] edge : edges) {
            int node1 = edge[0]; int node2 = edge[1];
            gp.get(node1).add(node2);
            //for undirected graph
            gp.get(node2).add(node1);
        }
        //graph is made
        // int e = edges.length;
        //assume any source node say n 0
        int source = 0;
        bfs(gp  , v  , source);
    }
    static void bfs(List<List<Integer>> gp, int v , int source ) {
        //make a visited array
        List<Integer> vis = new ArrayList<>(Collections.nCopies( v ,0));

        //make a queue
        Queue<Integer> queue = new LinkedList<>();
        //in java queue is implemented using linked list
        //step 1. add the source node to the linked list
        queue.add(source);
        //mark it as visited
        vis.set(source , 1);
        //now we se start our algorithm
        while (!queue.isEmpty()) {
            //pop the source and add it's neighbours
            int curr = queue.poll();
            System.out.println(curr); //this will show the order of the bfs traversal
            //now that you have popped each element add all it's neighbours to the queue
            for( int i : gp.get(curr)) {
                if(vis.get(i) == 0) {
                    //the above condition checks if the edge is visited or not
                    queue.add(i);
                    //after adding we shall set it as visited
                    vis.set(i , 1);
                }
            }
        }
    }
}
