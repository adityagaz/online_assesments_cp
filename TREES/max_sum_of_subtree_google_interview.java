package TREES;
import java.util.*;
public class max_sum_of_subtree_google_interview {

    static int [] subtree , val;
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        subtree = new int [n];
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

        dfs(0 , -1 , tree, vis);
        int max = Integer.MIN_VALUE;
        for( int i : subtree) {
            max = Math.max(i , max);
        }
        System.out.println(max);
    }

    static void dfs(int node , int parent, List<List<Integer>> tree , boolean [] vis) {
        vis[node]= true;
        for( int i : tree.get(node)) {
            if(i != parent && !vis[i]) {
                vis[i]= true;
                dfs(i , node , tree, vis);
            }
        }

        subtree[node] = val[node];
        for( int i : tree.get(node) ) {
            if(i != parent) {
                subtree[node] += subtree[i];
            }
        }

    }
}
