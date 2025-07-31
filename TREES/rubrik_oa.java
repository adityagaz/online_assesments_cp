package TREES;

import java.util.*;
public class rubrik_oa {
    static final int MAX = Integer.MAX_VALUE;
    static int [] dp , val , sum;

    static int n , m , k;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n = s.nextInt() ;m = s.nextInt(); k = s.nextInt();
        dp = new int[n+1];
        val = new int[n+1];
        sum = new int[n+1];
        boolean [] vis = new boolean[n+1];
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0; i<=n;i++) {
            tree.add(new ArrayList<>());
            if(i>0) {
                val[i] = s.nextInt();
            }
        }
        for( int i = 2 ; i<=n; i++ ) {
            int u = s.nextInt() , v = i;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        for( int i : val ) {
            if( i > k) {
                System.out.println(-1);
                return;
            }
        }
        dfs(1 ,-1, tree, vis);
        int ans = dp[1];
        if(dp[1] <= m) {
            ans +=1;
        }
        else {
            ans = -1;
        }
        System.out.println(ans);
    }

    static void dfs(int node , int parent , List<List<Integer>> tree,  boolean [] vis) {
        vis[node]=true;
        for( int i : tree.get(node)) {
            if(i!=parent && !vis[i]) {
                dfs(i , node , tree, vis);
            }
        }

        int min_sum = MAX , min_idx = MAX ;
        dp[node]=0; sum[node]= val[node];
        for( int i : tree.get(node) ) {
            if(i != parent) {
                if(sum[i] < min_sum) {
                min_sum = sum[i];
                min_idx = i;
            }
            }
        }
        //Now we have the min index and the min sum
        if(tree.get(node).size() > 1) {

            int no_of_children = tree.get(node).size();
            if(min_sum + val[node] <= k  ) {
                //remove all nodes except one
                dp[node] = node == 1 ? no_of_children -1 : no_of_children-2;
                sum[node] += sum[min_idx];
            }
            else {
                //remove all nodes 
                dp[node]= node == 1  ? no_of_children :   no_of_children -1;
            }
            for( int i : tree.get(node)) {
                   if(i != parent) {
                     dp[node] += dp[i];
                   }
            }
         }

        
    }
}
