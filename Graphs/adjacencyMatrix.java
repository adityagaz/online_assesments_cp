package Graphs;
import java.util.*;

public class adjacencyMatrix {
    public static void main (String  [] args) {
        //we will represent graphs by two mainly used ways and those are
        //1. adjacency matrix O(n^2) sc - and to find each neighbour we have O(n)
        //2. adjacency list O(2*v + e) sc and O(no of neighbour) time to traverse through all neighbours
        //now we will discuss the first way that is adjacency matrix
        int nodes = 5; // we have five nodes 0 , 1  ...5
        int no_of_edges = 4;
        //assume we have edges as a list [[0,1] , [ 1,2] , [3,4] , [1,4]
        //our adjacency matrix will : marked 1 wherever we have an edge and 0 if we donot
        //in case of undirected graph we will have [0,1] as edge and als0 [1,0] as an edge
        // and will be marked 0 if there is no edge

        int [][] edges  =  { {0,1} , {1,2 } , {3,4} , {1,4} };
        //iterate through these edges and make the adjacency matrix
        //initialize the adjacency matrix
        int [][]gr = new int [nodes][nodes];
        for( int [] i : gr ) {
            Arrays.fill(i , 0);
            //initially no connected components
        }
        for( int [] edge : edges) {
            int node1  = edge[0];
            int node2 = edge[1];
            //edge i is between two nodes for example between node1 = 0 and node1 = 1
            //now we need to update these in the adjacency matrix
            gr[node1][node2] = 1;
            //if an undirected graph also mark the opposite as 1
            gr[node2][node1] =1;
        }
        for( int [] row : gr) {
            System.out.println(Arrays.toString(row));
        }

    }
}
