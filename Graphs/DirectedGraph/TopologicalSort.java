package Graphs.DirectedGraph;
import java.util.*;

public class TopologicalSort {
    public static void main (String [] args) {
        //topological sorting says that we should print all the nodes in such a way that
        //when we pickup any edge between u ---> v
        //then we should see u appearing before v in our sorted order
        //so we can notice that dfs already does that
        //going to each node depth wise and then printing so
        //if we little bit use the property of stack that when we reach the last node then
        //it should be first in and during printing the stack we can say like it will be last
        //out so it will appear after all edge which was directing towards it and we can say
        // first push my children into the stack and then i will go into the stack
        //topo sort can be printed in many ways by choosing different starting points
        //topo sort can only be written in DIRECTED ACYCLIC GRAPH
        


    }
}
