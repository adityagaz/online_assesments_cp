
import java.util.*;
public class juspay_oa {

    static int  [] val , ways;

    public static void main(String[] args) {
        /*
          OA : JUSPAY
          CTC : 28LPA

          Given a graph of n nodes and n-1 edges and a threshold m.
          Graph nodes can be either 0 or 1. 0 means non hazardous and 1 means hazardous.
          We want to calculate the no of paths that lead to leaf nodes from node no 1 such that it doesnot take  > m consecutive hazards
          hazards in the way

          first line denotes n = 7
          next we have m = 1
          next we have no of edges =  k = 6
          next n lines have numbers 0 or 1 denoting hazardous or not
          next k lines is the number the edges array

          7
          1
          6
          1 0 1 1 0 0 0
          1 2
          1 3
          2 4
          2 5
          3 6   
          3 7

          ans -- 2

          TEST case ii  -
          5
          2
          4
          1 1 0 1 1
          1 2
          2 3
          3 4
          4 5

          ANS - 1



          bfs kar do and ek array mein har node pe no of visits if hazard <= m ki count ki value save karlo 
          finally go to each node in the adj list check if it is a leaf 
          and then check no of ways and add them up

         */

         Scanner s = new Scanner(System.in);
         int n = s.nextInt() , m = s.nextInt() , k = s.nextInt();
         val = new int [n+1];
         for( int i = 1; i <=n ; i++ ) {
            val[i] = s.nextInt();
         }
         List<List<Integer>> tree = new ArrayList<>();
         for( int i = 0 ; i <= n ; i++ ) {
            tree.add(new ArrayList<>());
         }
         for( int i = 0 ; i < k ; i++ ) {
            int u = s.nextInt() , v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
         }

         boolean [] vis = new boolean[n+1];
         ways = new int [n+1];
         bfs(1 , -1, tree, vis, val, m);


         
    }

    static void bfs(int node , int parent , List<List<Integer>> tree , boolean [] vis  , int [] val , int m) {
        Queue<int []> q = new LinkedList<>();
        int hazard = val[1];
        q.add(new int [] {node , parent , hazard});
        vis[node] = true;
        while (!q.isEmpty()) { 
            int [] curr = q.poll();
            int nod = curr[0] , par = curr[1];
            hazard = curr[2];
            for(int i : tree.get(nod)) {
                if(i!=par) {
                    if(hazard <= m ) {
                        ways[i]++;
                    }
                }
                if(i!=par && !vis[i]) {
                    int new_hazard = val[i] == 0 ? 0 : hazard + val[i];
                    vis[i] =true;
                    q.add(new int [] { i , nod , new_hazard});
                }
            } 
            
        }
        int ans =  0;
        int n = tree.size();
        for ( int i = 1 ; i < n ; i++ ) {
            if(tree.get(i).size() == 1 ) {
                ans += ways[i];
            }
        }

        System.out.println(ans);
    }


}
