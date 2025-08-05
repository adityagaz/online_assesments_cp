package TREES;
import java.util.*;

// Link - https://leetcode.com/problems/find-subtree-sizes-after-changes/description/ 


// TOPICS - FIRST DFS , THEN BFS (DP on Trees)


public class re_arrange_tree {

    static List<List<Integer>> tree  , newTree;
    static  int [][] pos;
    static String val;
    static int [] ans;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        pos = new int[n][26];
        tree = new ArrayList<>();
        newTree  = new ArrayList<>();
        for( int  [] i : pos) Arrays.fill(i, -1);
        for( int i = 0 ; i < n ; i++ ) arr[i] = s.nextInt();
        for( int i = 0; i <= n;i++) {
             tree.add(new ArrayList<>());
             newTree.add(new ArrayList<>());
        }
        for( int i  = 1; i < n ; i++) {
            tree.get(arr[i]).add(i);
        }
        s.nextLine();
        val = s.nextLine();
        int [] newParentArray = bfs(0 , arr , val);
        for( int i = 1 ; i < n ; i++ ) {
            int u = i;
            int v = newParentArray[i];
            newTree.get(v).add(u);
        }
         
        ans = new int[n];
        dfs(0 , -1);
        System.out.println(Arrays.toString(ans));
        //bfs and collect all ancestors

    }

    static void dfs( int node , int parent) {
        for( int i : newTree.get(node)) {
            dfs(i , node);
        }
        ans[node] = 1;
        for( int i : newTree.get(node)) {
            ans[node]+=ans[i];
        }
    }

    static int [] bfs(int start , int [] parent , String val) {
        Queue<Integer> q= new LinkedList<>();
        int[] newParent = new int[parent.length];
        q.add(0);
        for(int [] i : pos) Arrays.fill(i , -1);
        newParent[0]=-1;
        pos[0][val.charAt(0) - 'a'] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for( int i : tree.get(node)) {
                q.add(i);
                System.arraycopy(pos[node], 0, pos[i], 0, 26);
                int ch = val.charAt(i) - 'a';
                if(pos[node][ch] != -1 ) {
                    newParent[i] = pos[node][ch];
                }
                else {
                    newParent[i] = parent[i];
                }

                pos[i][ch] = i;
            }

        }
        return newParent;
    }
}
