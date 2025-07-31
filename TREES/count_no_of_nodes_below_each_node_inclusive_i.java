package TREES;
import java.util.*;


public class count_no_of_nodes_below_each_node_inclusive_i {
    static int [] dp; // dp[i] will tell me the number of nodes below that node including that node 
    /*
      if node is leaf dp[leaf] = 0;
      otherwise dp[non-leaf] = 1 + sum of (dp[children])

      9
      1 2 
      1 5
      2 3
      2 4
      5 6
      5 7
      7 8
      7 9

      ans = 9 3 1 1 5 1 3 1 1 

     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        dp = new  int[n+1];
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0 ; i <= n  ; i++ ) {
            tree.add(new ArrayList<>());
        }
        boolean  [] vis = new boolean[n+1];
        for( int i = 0 ; i+1 < n ; i++) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dfs(1 , -1 , tree , vis);
        System.err.println(Arrays.toString(dp));
        
    }

    static void dfs(int node , int parent , List<List<Integer>> tree , boolean [] vis )  {
        vis[node]=true;
        for( int i : tree.get(node)) {
            if(!vis[i] && i != parent) {
                dfs(i , node , tree , vis);
            }
        }

        dp[node]=1;
        for(int i : tree.get(node)) {
            if(i!=parent) {
                dp[node] += dp[i];
            }
        }

    }

}
