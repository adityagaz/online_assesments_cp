package TREES;
import java.util.*;
public class vm_ware_oa {
    /*
     Problem -> https://www.desiqna.in/12818/vmware-sde1-coding-questions-and-solutions-india-april-2023 
    Given a Tree of “N” nodes and “N-1” edges; each node has a value; b[i] -> value of the ith node.
     Tree is rooted at node 1(1—>N)
    -1e9<=b[i]<=1e9
    Find any path in the tree with a maximum sum such that it only goes downwards. 

     */
    static int [] max_path_sum , val;
    public static void main(String[] args) {
          
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        max_path_sum = new int [n];
        val = new int [n];
        for( int i =0 ; i < n ; i++) {
            val[i]= s.nextInt();
        }
        List<List<Integer>>  tree= new ArrayList<>();
        for( int i = 0 ; i < n ; i++ ) {
            tree.add(new ArrayList<>());
        }
        boolean [] vis = new boolean[n];
        for( int i = 0 ; i < n-1 ; i++ ) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(0 ,-1, tree, vis);
        int ans = 0;
        for ( int i : max_path_sum) {
            ans = Math.max(ans , i);
        }
        System.out.println(ans);
    }

    static void dfs(int node , int parent , List<List<Integer>> tree , boolean [] vis ) {
        vis[node]=true;
        for( int i : tree.get(node)) {
            if(i != parent && !vis[i]) {
                dfs(i , node , tree , vis);
            }
        }

        max_path_sum[node]=val[node];
        int max = 0;
        for(int i : tree.get(node)) {
            max = Math.max(max , max_path_sum[i]);
        }
        max_path_sum[node] += max;
    }
    
    /*
      5
      5 7 -10 4 15
      0 1
      0 4
      1 2
      2 3

      ans - 20
     */
}
