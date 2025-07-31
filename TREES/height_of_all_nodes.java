package TREES;
import java.lang.reflect.Array;
import java.util.*;
public class height_of_all_nodes {

    static int [] height; 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        height = new int[n]; //stores height of each node
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0 ; i < n ; i++ ) {
            tree.add(new ArrayList<>());
        }
        boolean [] vis = new boolean[n];
        for( int i = 0 ; i < n-1; i++ ) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dfs(0 , -1 , tree , vis);
        System.out.println(Arrays.toString(height));
    }

    static void dfs( int node , int parent , List<List<Integer>> tree , boolean [] vis) {
        vis[node] = true;
        for( int  i  : tree.get(node) ) {
            if(!vis[i] && i!= parent) {
                dfs(i , node , tree, vis);
            }  
        }
        //Now you assume you are on a node for which all the subtree nodes are explored so write it like arry from here
        int h = 0;
        for( int i : tree.get(node)) {
            if(i!=parent) {
                //calculate the max height of all children 
                h = Math.max(h , height[i]);
            }
        }
        //if there are 0 children then height will be added to 1 and updated in the height array.
        height[node] = h + 1; 
    }
}
/*
  test case 
9
0 1
0 4
1 2
1 3
4 5
4 7
7 6
7 8

ans - 4 2 1 1 3 1 1 2 1
 */