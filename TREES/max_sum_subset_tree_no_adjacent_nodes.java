package TREES;
import java.util.*;;
public class max_sum_subset_tree_no_adjacent_nodes {
    /*
     * 
6
1 2 3 4 5 6
1 2
1 3
2 4
3 5
3 6


ans = 16

3
11 1 2
1 2
1 3
     */


    static int [] val;
    static int [][] dp;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0; i <= n ; i++ ) {
            tree.add(new ArrayList<>());
        }
        val = new int[n+1];

        dp = new int[n+1][2];
        for( int i = 1; i <= n ; i++ ) {
            val[i]=s.nextInt();
        }
        for( int i = 0 ; i+1 < n ; i++ ) {
            int u = s.nextInt();
            int v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        boolean [] vis = new boolean[n+1];
        dfs( 1 , - 1, tree, vis);

        System.out.println(Math.max(dp[1][0] , dp[1][1]));
    }

    static void dfs( int node , int parent , List<List<Integer>> tree , boolean [] vis ) {
        vis[node]= true;
        for( int i : tree.get(node) ) {
            if(i != parent && !vis[i]) {
                dfs(i , node , tree, vis);
            }
        }

        dp[node][1] = val[node];
        dp[node][0] = 0;
        for( int i : tree.get(node)) {
            if( i == parent) continue;
            dp[node][1] += dp[i][0];
            dp[node][0] += Math.max(dp[i][0 ] , dp[i][1]);
        }
    }
}
