package TREES;


import java.util.*;


public class sum_of_all_nodes_from_i_to_root {
    /*
      Given a tree with N nodes and N-1 edges for each node print the vertical path sum of that node till it's root.

      Approach - Do a Type 1 DFS and store the sum at each index in an array.
     */


    static int [] sum , val;
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        List<List<Integer>> tree= new ArrayList<>();
        val = new int[n];
        for(int i=0 ; i <= n; i++ ) {
            tree.add(new ArrayList<>());
        }
        boolean [] vis = new boolean[n];
        sum = new int[n];
        for( int i = 0 ; i < n ; i++ ) val[i] = s.nextInt();
        for( int i = 0 ; i + 1 < n ; i++ ) {
            int u = s.nextInt();
            int v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        dfs(0, -1, vis, tree , 0);
        System.out.println(Arrays.toString(sum));

    }

    static void dfs(int node , int parent , boolean  [] vis , List<List<Integer>> tree , int sm) {
        ////////////////
        vis[node]=true;
        sm+=val[node]; //have a sum variable increment it whenever you are at a node by it's value
        System.out.println("Going down.... at node" + node  +" -> "+ sm);
        sum[node]=sm; // store that sum till now for that index in an array.
        ///////////////
        
        // This above section is when you are going down the tree
        
        //////////////
        for( int u : tree.get(node)) {
            if(u != parent && !vis[u ]) {
                dfs(u , node , vis , tree ,sm);
            }
        }
        /////////////
    
        //This below section is when you are going up the tree.

        
        /////////////
        
        sm -= val[node]; //When you are going up in this tree delete the sum.
        System.out.println("Going up.... at node" + node +" -> "+sm);
        ////////////
    }
}
/*
8
1 2 3 4 5 6 7 8
0 1
0 2
1 3
1 4
4 5
2 6
2 7

  ans = [1 3 4 7 8 14 11 12]


  visualisation ->
    Going down.... at node0 -> 1
    Going down.... at node1 -> 3
    Going down.... at node3 -> 7
    Going up.... at node3 -> 3
    Going down.... at node4 -> 8
    Going down.... at node5 -> 14
    Going up.... at node5 -> 8
    Going up.... at node4 -> 3
    Going up.... at node1 -> 1
    Going down.... at node2 -> 4
    Going down.... at node6 -> 11
    Going up.... at node6 -> 4
    Going down.... at node7 -> 12
    Going up.... at node7 -> 4
    Going up.... at node2 -> 1
    Going up.... at node0 -> 0

 */