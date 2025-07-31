package TREES;
import java.util.*;

public class find_sum_of_subtrees {

    static int [] sum_subtree , val;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        val =  new int [n];
        for( int i = 0; i < n ; i++ ) val[i] = s.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0 ; i < n ; i++ ) {
            tree.add(new ArrayList<>());
        }
        for( int i = 0 ; i < n-1 ; i++ ) {
            int u = s.nextInt()  , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        sum_subtree  = new int[n];
        boolean [] vis = new boolean[n];
        dfs(0 , -1 , tree, vis);
        System.out.println(Arrays.toString(sum_subtree));


    }

    static void dfs (int node , int parent , List<List<Integer>> tree , boolean [] vis  )  {
        vis[node] = true;
        for( int i : tree.get(node )) 
        {
            if(i!=parent && !vis[i]) {
                vis[i]=true;
                dfs(i , node , tree, vis);
            }
        }
        sum_subtree[node] = val[node];
        for( int i : tree.get(node)) {
            if(i != parent ) {
                sum_subtree[node] += sum_subtree[i];
            }
        }

    }
     
}


/*
 7
 1 2 3 4 11 63 101
 0 1
 0 2
 1 3
 1 4
 2 5
 2 6
 */