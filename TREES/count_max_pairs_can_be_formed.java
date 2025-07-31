package TREES;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class count_max_pairs_can_be_formed {
    
    /*

      Tough OA -- Intuition  is Tough
      COMPANY : SERVICE NOW
      CTC     : 30 LPA
      TOPICS  : DP ON TREES , DFS , GREEDY
      Question -    
      Tree is a graph with N nodes and N-1 edges -> single component 
    -> Tree rooted at Node “1”
    -> Divide Tree in groups of size 2; (x,y) such that x and y have no parent-child or distant-parent-child relationship
    -> Task is to create; maximum number of such groups;   
     */

    static int [] count , ans; // count[i] will tell me the number of nodes below that node including that node 
    /*
7
1 0
2 0
3 2
4 1
5 1
6 3

ans - 3

4
1 0
2 1
3 0

4

ans = 1

4
1 0
2 1
3 2

ans = 0
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        count = new  int[n+1];
        ans = new int[n+1];
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0 ; i <= n  ; i++ ) {
            tree.add(new ArrayList<>());
        }
        boolean  [] vis = new boolean[n+1];
        for( int i = 0 ; i+1 < n ; i++) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dfs(0 , -1 , tree , vis);
        System.err.println(Arrays.toString(ans));
        
    }

    static void dfs(int node , int parent , List<List<Integer>> tree , boolean [] vis )  {
        vis[node]=true;
        for( int i : tree.get(node)) {
            if(!vis[i] && i != parent) {
                dfs(i , node , tree , vis);
            }
        }
        count[node]=1;
        for(int i : tree.get(node)) {
            if(i!=parent) {
                count[node] += count[i];
            }
        }
        int total_count = count[node] - 1 , max_count = 0 , max_count_idx = -1;
        for( int i : tree.get(node)) {
            if(count[i] > max_count ) {
                max_count = count[i];
                max_count_idx = i;
            }
        }
        if(max_count <= total_count / 2) {
            ans[node] = total_count/2;
        }
        else {
           int left_over = (2*max_count) - total_count;
           int already_formed = 2*ans[max_count_idx];
            if(left_over <= already_formed) {
                ans[node] = total_count/2;
            }
            else {
                ans[node] = (total_count - (left_over - already_formed)) /2;
            }
        }
    }
}
