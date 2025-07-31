package GRAPHS;
import java.util.*;

public class find_no_of_shortest_paths_to_every_node_from_root {

    static int [] ways , level;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt() , m = s.nextInt();

        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            g.add(new ArrayList<>());
        }
        ways = new int[n];
        level = new int[n];
        boolean [] vis = new boolean[n];
        for( int i = 0 ; i < m ; i++ ) {
            int u = s.nextInt() , v = s.nextInt();
            g.get(u).add(v);
        }

        int start = s.nextInt();
        ways[start] = 1;
        level[start]  = 0;

        Queue<int [] > q = new LinkedList<>();
        vis[start] = true;
        q.add(new int [] {start , 0});
        while(!q.isEmpty()) {
            int [] curr = q.poll();
            int node  =  curr[0] , curr_level = curr[1];
            for( int i : g.get(node)) {
                if(!vis[i]) {
                    vis[i]=true;
                    ways[i] = ways[node];
                    level[i] = curr_level +1;
                    q.add(new int [] { i , curr_level +1});
                }
                else {
                    //now we know the node is already visited
                    // so there could be two possibilities that it is being visited again from another shortest path
                    //or a longer path if it is longer then we will ignore otherwise if it is one more shortest path we 
                    // can add all the ways of that node also
                    //Question is how to check if it is another shortest path??
                    // if(level[node] + 1 == level[end] ) then yes why? see
                    /*
                      if end is already visited then level[end] must be updated in advance so we will check if we are again at 
                      the same level or not

                     */
                    if(level[node] +1 == level[i]) {
                        ways[i] += ways[node];
                    }

                    }
                }
            }

            System.out.println(Arrays.toString(ways));
        }


    }

    /*
      n = 7 , m = 9
        7 9
        0 1
        0 2
        1 2
        1 3
        2 3
        3 4
        3 5
        4 6
        5 6
        0

        case 1
         if 6 is not visited  path[]

     */
    

