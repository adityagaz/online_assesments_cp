import java.util.*;
public class No_of_nodes_in_subtree_i {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<List<Integer>> adj = new ArrayList<>();
    int [] dp = new int[n+1];
    int [] dp1 = new int[n+1];
    for(int i = 0; i <= n; i++ ) {
      adj.add(new ArrayList<>());
    }
    for( int i = 1 ; i<= n-1; i++ ) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      adj.get(u).add(v);
      adj.get(v).add(u);
    }
    boolean [] used = new boolean[n+1];
    dfs(1 , -1 , used , adj , dp,dp1);
    System.out.println(dp1[1]);

  }

  static void dfs(int node , int parent , boolean []  used , List<List<Integer>> graph , int [] dp, int [] dp1) {
    used[node] = true;
    for( int i : graph.get(node)) {
      if(i != parent && !used[i]) {
        dfs( i , node , used ,  graph , dp,dp1);
      }
    }
    dp[node] = 1;
    dp1[node] = 0;
    for( int i : graph.get(node)) {
     if(i != parent) {
      dp[node] += dp[i]; 
      dp1[node] += dp1[i] + dp[i];
     }
    }
  }
  
}
