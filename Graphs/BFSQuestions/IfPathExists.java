package Graphs.BFSQuestions;
import java.util.*;

public class IfPathExists {
    public static void main (String [] args) {
        int n = 6    ; //no of vertex
        int [][]edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int source = 0;
        int destination = 5;
        System.out.println(bfs(edges , source , destination , n ));
    }
    static boolean bfs ( int  [][] edges , int source , int destination , int n) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> vis = new ArrayList<>();
        List<List<Integer>> gp = new ArrayList<>();
        for(int i = 0 ; i< n   ;i++) {
            gp.add(new ArrayList<>());
            vis.add(0);
        }
        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            gp.get(u).add(v);
            gp.get(v).add(u);
        }
        q.add(source);
        vis.set(source , 1);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for( int i : gp.get(curr)) {
                if(vis.get(i) == 0) {
                    q.add(i);
                    vis.set(i , 1);
                }
            }
            if(vis.get(source) == 1 && vis.get(destination) ==1) {
                return true;
            }
        }

        return false;
    }


}
