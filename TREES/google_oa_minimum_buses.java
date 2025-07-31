package TREES;
import java.util.*;
public class google_oa_minimum_buses {

    /*

      COMPANY : GOOGLE
      CTC     : 60 LPA 
      TAGS    : DP ON TREES , DYNAMIC PROGRAMMING

      3
      1 1 1
      1 2
      1 3 
      ans = 2

      4
      1 1 1 1
      1 2
      2 3
      3 4
      ans = 1

      8
      0 1 1 0 1 1 0 1
      1 2
      1 8
      2 3
      2 5
      5 4
      5 6
      8 7
      ans = 3


     */
    static int [] dp , val;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0 ;i <= n ; i++ ) tree.add(new ArrayList<>());
        boolean [] vis = new boolean[n+1];
        dp = new int[n+1];
        val = new  int[n+1];
        for( int i = 1 ; i <= n ; i++ ) {
            val[i]= s.nextInt();
        }
        for( int i = 0 ; i+1<n;i++) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(1 , -1 , tree, vis);
        System.out.println(dp[1]);
    }
    static void dfs(int node , int parent , List<List<Integer>> tree , boolean [] vis) { 
        vis[node] = true;
        for( int i : tree.get(node)) {
            if(!vis[i] && i!= parent) {
                dfs(i  , node , tree, vis);
            }
        }

        int bus_req = 0;

        for( int child : tree.get(node)) {
            if(child != parent) {
                bus_req += dp[child];
            }
        }
        //this node requires bus_req no of buses
        if(bus_req == 0 ) {
            dp[node] = val[node];
        }
        else {
            dp[node]=bus_req;
        }
    }
}
