package TREES;

import java.util.*;

public class google_oa_ {
    /*
     Problem : GOOGLE OA | TREES | DP ON TREES 
    You are given an undirected tree with n nodes numbered from 0 to n–1. 
    Each node holds a value of either 0 or 1. Your task is to compute, for every node u, 
    the total number of 1s on the unique path from the root (node 0) to u, inclusive of u itself.

    Input Format

    Line 1: Integer n, the number of nodes.
    Line 2: n space‑separated integers v₀ v₁ … vₙ₋₁, each either 0 or 1, where vᵢ is the value at node i.
    Next n–1 lines: Each line has two integers u w (0 ≤ u,w < n), indicating an undirected edge between u and w.

    Output Format
    A single line with n space‑separated integers c₀ c₁ … cₙ₋₁, where cᵤ is the count of 1s on the path from node 0 to node u.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
            int w = s.nextInt();
            val[i] = w;
        }
        for (int i = 0; i < n - 1; i++) {
            int u = s.nextInt(), v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int[] dp = new int[n];
        // base case if root is zero then dp[0] = 0 or else dp[0] = 1, basically dp[0] =
        // val[0]
        dp[0] = val[0];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i : tree.get(curr)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(i);
                    dp[i] = val[i] == 1 ? 1 + dp[curr] : dp[curr];
                } else {
                    // parent
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        /*
         * 9
         * 0 1 0 1 1 1 1 0 1
         * 0 1
         * 0 4
         * 1 2
         * 1 3
         * 4 5
         * 4 7
         * 7 6
         * 7 8
         * 
         * Ans - 0 1 1 2 1 2 2 1 2

         */

    }

}