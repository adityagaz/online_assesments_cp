package TREES;
import java.util.*;

/*
    
    In a tree of zeroes and ones , 
    give the final answer as no.of islands can be formed. 
    It forms an island where ones are connected and surrounded by zeroes .

    Example : 
    

                   0(a)
                /        \
            1(b)         1(c)
            /             /    \      
        0 (d)         1(e)    0(f)
        /       \                   
    1(g)        1(h)           
    /                \
    1(i)              1(j)


    Ans:
    No.of islands formed : 4 {
    b - 1 island
    g,i - 2 island
    c,e - 3 island
    h,j - 4 island
    }

    Test case -
1
10
0 1 1 0 1 0 1 1 1 1
0 1
0 2 
1 3
2 4
2 5
3 6
3 7
6 8
7 9

ans = 4

1
21
1 1 1 0 1 1 0 1 1 0 1 1 1 0 1 0 1 1 1 1 0
0 1
0 2
1 3
1 4
2 5
2 6
3 7
3 8
4 9
5 10
9 11
9 12
10 13
10 14
12 15
14 16
15 17
16 18
8 19
19 20

ans - 6 
 */

public class No_of_islands {    

    static int ans = 0;
    static int [] dp;
    static int [] val;
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            dp = new int[n];
            val = new int[n];
            boolean [] vis = new boolean[n];
            List<List<Integer>> tree = new ArrayList<>();
            for( int i = 0; i <= n ; i++ ) tree.add(new ArrayList<>());
            for( int i  =0 ; i< n ; i++ ) val[i] = s.nextInt();
            for (int i = 0; i < n - 1; i++) {
              int u = s.nextInt(), v = s.nextInt();
            //   if (val[u] != 0 && val[v] != 0) {
            //     tree.get(u).add(v);
            //     tree.get(v).add(u);
            //   }
                tree.get(u).add(v);
                tree.get(v).add(u);
            }

            dfs(0 , -1 , vis , tree);

            System.out.println(dp[0]);

            //DFS 2 METHOD -- DONOT MAKE EGDES WITH OPPOSITE NODES
            //Then tree automatically gets divided into many sections now we can do individual dfs and count them.

            // int cnt =0;
            // for( int i = 0; i < n ; i++ ) {
            //     if(!vis[i] && val[i]!=0) {
            //         cnt++;
            //         dfs2(i , vis , tree);
            //     }
            // }
            // System.out.println(cnt);
        }
    

    }

    static void dfs(int node , int parent, boolean [] vis , List<List<Integer>> tree ) {

        vis[node] = true;
        for( int u : tree.get(node)) {
            if(!vis[u] && u!=parent) {
                dfs(u , node , vis , tree);
            }
        }

        // now bottom up

        if(tree.get(node).size() ==1 && parent != -1) {
            dp[node] = val[node];
        }
        int cnt =0;
        for( int i : tree.get(node)) {
            if(val[node] == 0) {
                dp[node] += dp[i];
            }
            else {
                if(val[i] == 1) {
                    //it can be mixed with this node and form a connected component
                    dp[node] += dp[i] -1;
                }
                else {
                    // it can't form a connected component
                    // so here we need to add the answer for this node
                    cnt++;
                    dp[node] += dp[i];
                }
            }
        }
        if(cnt == tree.get(node).size() -1) {
            dp[node] = 1;
        }
    }
    static void dfs2(int node , boolean [] vis , List<List<Integer>> tree ) {
        vis[node]=true;
        for( int u : tree.get(node)) {
            if(!vis[u]) {
                dfs2(u , vis , tree);
            }
        }
    }
}
