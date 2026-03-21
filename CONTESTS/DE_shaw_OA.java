import java.util.*;


public class DE_shaw_OA {
  public static void main(String[] args) {

    /*
      Given a tree of N nodes starting from 1...N. Nodes are coloured red or blue which denotes two cities in a tree network
      find the no of cycles that can be formed by connecting two edges such that 
      1. all the nodes in the cycle belongs to one city.
      2. there should be minimum three nodes

      LOGIC -- 
      for a linear tree with only one color nodes 
      1 -> 2 -> 3 -> 4 -> 5 there are 5 nodes n = 5
      1 can connect to three other 3 ,4 , 5  = 3
      2 can connect to two other nodes 4 , 5 = 2
      3 can connect to one other node 5 = 1
      therefore for n = 5 ans = 3 + 2 + 1 
      similarly if we observe the answer for n = 6 is 4 + 3 + 2 + 1
      so for n the answer is n = summation of (n-2) = (n-1) * (n-2) /2 ; summation (n) = n * (n-1)/2 therefore summation (n-2 ) -> put n = n-2


      EXTENDING IDEA FROM ARRAY TO TREE
      for any tree this is the amazing observation that the same works as the array 
      why ?
      because if you observe all the edges except the adjacent ones which are connected contribute to a cycle which has more than >= 3 nodes
      so for tree of n nodes or array of n nodes the  formula remains the same

      Proof - complete graph nodes n*(n-1)/2 - n-1 = (n-1)*(n-2)/2; --> same as Array

      ans for n nodes  =  (n-1)*(n-2)/2;

      now since we have two cities in the tree network we can just segregate all subtrees of one color together and run dfs to count nodes 
      and then and answers for both cities together
      NOTE - we need to sepearate two sections because any edge between color and the another color will lead to invalid cycle

      How to segregate ?? 
      when you take the input itself donot make and edge between two cities if they are of different colors 
      now, automatically the tree is broken into components

      Other way --> 
      do the dfs on whole tree, while exploring the child nodes donot call the dfs if they are of different color

     */

     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     List<List<Integer>> tree = new ArrayList<>();

     for( int i = 0 ; i <= n ;  i++ ) {
      tree.add(new ArrayList<>());
     }
     boolean [] vis  = new boolean[n+1];
     int [] color = new int[n+1];
     for( int i = 1 ; i <= n ; i++ ){
      color[i] = sc.nextInt();
     }
     for( int i = 1; i <= n-1 ; i++ ) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      
        tree.get(u).add(v);
        tree.get(v).add(u);
      
     }
     int sum =  0;
     for( int i =1 ; i <= n ; i++ ) {
      if(!vis[i]) {
        int nodes_per_component = dfs(i , -1 , tree , vis , color );
        sum += ((nodes_per_component-2) * (nodes_per_component-1))/2;
      }
     }

     System.out.println(sum);
  }

  static int dfs(int node , int parent , List<List<Integer>> tree , boolean [] vis , int [] color) {
    vis[node] = true;
    int count = 1;
    for( int ch : tree.get(node)) {
      if(ch != parent && !vis[ch] && color[node] == color[ch]) {
          count += dfs(ch , node , tree , vis , color);
      }
    }
    return count;
  
  }

  




  
}
