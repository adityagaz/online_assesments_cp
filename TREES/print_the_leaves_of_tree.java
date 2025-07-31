package TREES;

import java.util.*;

public class print_the_leaves_of_tree {
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         int n = s.nextInt();
         List<List<Integer>> tree = new ArrayList<>();
         for (int i = 0 ; i <= n ; i++ ) tree.add(new ArrayList<>());
         boolean [] vis = new boolean[n+1];
        for(int i = 0 ; i+1 < n ; i++  ) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
       }
       List<Integer> leaves = new ArrayList<>();
       printLeavesDfs(tree, vis, 1, -1 , leaves);
       System.out.println(leaves);
       vis = new boolean[n+1];
       printLeavesBfs(tree, vis, 1, -1);


    }


    static void printLeavesBfs(List<List<Integer>> tree , boolean [] vis , int node ,int parent) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> leaves = new ArrayList<>();
        q.add(node);
        vis[node]=true;
        while(!q.isEmpty()) {
            int nod = q.poll();
            boolean isLeaf = true;
            for( int i : tree.get(nod)) {
                if(!vis[i] && i != parent) {
                    //there are children of this node
                    vis[i]=true;
                    isLeaf= false;
                    q.add(i);
                }
            }
            if(isLeaf) leaves.add(nod);
        }

        System.out.println(leaves);
    }


    static void printLeavesDfs(List<List<Integer>> tree, boolean [] vis , int node , int parent , List<Integer> leaves) {
        vis[node]=true;
        boolean isLeaf = true;
        for( int i : tree.get(node)) {
            if(!vis[i ] && i != parent ) {
                isLeaf = false;
                //it means it has children
                printLeavesDfs(tree , vis, i , node , leaves);
            }
        }
        if(isLeaf) {
            leaves.add(node);
        }
    }
    /*
    7
    1 2
    1 3
    2 4
    2 5
    3 6
    3 7
    */
}
