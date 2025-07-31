package TREES;

import java.util.*;

public class google_oa_no_of_ones_in_vertical_path {

    /*
      In a tree of zeroes and ones , find the longest vertical path of all containing “1”s.

     */

    static int[] dp, dp2, val;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            List<List<Integer>> tree = new ArrayList<>();
            boolean[] vis = new boolean[n];
            val = new int[n];
            dp = new int[n];
            dp2 = new int[n];
            for (int i = 0; i < n; i++) {
                val[i] = s.nextInt();
                tree.add(new ArrayList<>());
            }

            for (int i = 0; i + 1 < n; i++) {
                int u = s.nextInt(), v = s.nextInt();
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            dfs(0, -1, tree);
            dfs2(0, -1, tree);
            int vertical_max = Arrays.stream(dp).max().getAsInt();
            int inverted_v_max = Arrays.stream(dp2).max().getAsInt();
            System.out.println(Math.max(vertical_max, inverted_v_max));
        }

        s.close();

    }

    static void dfs(int node, int parent, List<List<Integer>> tree) {
        for (int u : tree.get(node)) {
            if (u != parent) {
                dfs(u, node, tree);
            }
        }
        int max_val = 0;
        for (int u : tree.get(node)) {
            if (u != parent) {
                max_val = Math.max(dp[u], max_val);
            }
        }
        if (val[node] == 0) {
            dp[node] = 0;

        } else {
            dp[node] = 1 + max_val;
        }
    }
    // TC (O(N)) , SC - O(N)

    // Follow up

    /*
     * the longest path need not be a a vertical path it can be from any node to any
     * node which has the maximum
     * number of ones.
     * 
     * if val[node] == 0 then this can't contribute so dp[node] =0;
     * else dp[node] = Math.max(vertical paths , 2 maximums from dp[children])
     * 
     * 1. dp[max_child] , dp[second_max_child]
     * 
     */

    static void dfs2(int node, int parent, List<List<Integer>> tree) {
        for (int u : tree.get(node)) {
            if (u != parent) {
                dfs2(u, node, tree);
            }
        }
        int max = 0, second_max = 0;
        for (int u : tree.get(node)) {
            if (u != parent) {
                if (dp[u] > max) {
                    second_max = max;
                    max = dp[u];
                } else if (dp[u] > second_max) {
                    second_max = dp[u];

                }
            }
        }
        max = second_max + max;
        dp2[node] = val[node] == 0 ? 0 : 1 + max;
    }
    /*
     * TEST CASE -
     * 13
     * 0 1 1 1 1 1 1 0 1 1 1 1 1
     * 0 1
     * 1 2
     * 0 3
     * 2 4
     * 2 5
     * 2 6
     * 4 7
     * 6 8
     * 5 9
     * 5 10
     * 3 11
     * 3 12
     * 
     * ANS - 5
     */
}
