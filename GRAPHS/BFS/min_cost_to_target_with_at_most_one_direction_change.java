// package ;

import java.io.*;
import java.util.*;

class min_cost_to_target_with_at_most_one_direction_change implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new min_cost_to_target_with_at_most_one_direction_change(), "whatever", 1 << 30).start();
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(System.out);
            FastReader sc = new FastReader();

            solve(sc);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    Small Observations:
         
        At each cell we have the direction to go to another cell and that leads
        to only one direction per cell visit 

        how ever we can change one cell's direction atmost once so...
        what if we change it...

        so possibility 1 :
            we go to the same direction as defined in the cell and then cell in the direction to the queue.
            it has zero cost....

            if the direction is outside of the matrix we are forced to change the direction.
        
        possibility 2 : 

            we try other three directions by pushing them one by one in the queue at a cost of 1

        it's similar to 0-1 bfs

            so,...
                we incurr cost 1 in changing direction so we add it at the last of the deque...

        we also check if we reach (n-1,m-1) we take the minimum cost of all the paths that lead to it.

    Logic :


    */



    static void solve(FastReader sc) throws Exception {

        // int t = sc.nextInt();
        int t = 1;

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][] graph = new int[n][m];
            for( int i = 0 ; i < n ; i++) {
                for( int j = 0 ; j< m; j++) {
                    graph[i][j]= sc.nextInt();
                }
            }
             
            int result = bfs(graph , n , m);
            System.out.println(result);


        }

    }

    static int bfs(int [][] graph , int n , int m ) {
        int [][] vis = new int[n][m];
        int [][] costing = new int[n][m];
        for( int [] i : costing ) {
            Arrays.fill(i, (int)1e8);
        }
        Deque<int []> dqueue = new ArrayDeque<>();
        dqueue.add(new int [] {0,0,0});
        vis[0][0]= 2;
        int ans = (int)1e8;

        while(!dqueue.isEmpty()){
            int [] coords = dqueue.poll();
            int x = coords[0];
            int y = coords[1];
            int cost = coords[2];



            // System.out.println("x :: " + x + " y :: " + y + " cost :: " + cost);
            if(x == n -1 && y == m-1) {
                //we have our possible answer but keep checking 
                ans = Math.min(ans , cost);
            }

            int num = graph[x][y];
            int nx = -1 , ny = -1;

            if(num == 1) {
                //right
                //check for outside pointers
                nx = x ; ny = y+1;
            }
            else if (num == 2) {
                nx = x  ; ny = y-1;
            }
            else if(num == 3 ) {
                //down
                nx= x+1 ; ny = y;
            }    
            else {
                nx = x-1 ; ny = y;
            }   
            if(!isOutOfbounds(nx, ny, n, m, graph) && vis[nx][ny]!=2){
                dqueue.addFirst(new int [] {nx , ny , cost});
                costing[nx][ny]=cost;
                vis[nx][ny]=2;
            }
            for( int [] d : dir) {
                nx = x + d[0];
                ny = y + d[1];
                if(!isOutOfbounds(nx, ny, n, m, graph) &&  vis[nx][ny]!=1 && vis[nx][ny]!=2) {
                        dqueue.addLast(new int [] {nx , ny, cost + 1});
                        costing[nx][ny]=cost+1;
                        vis[nx][ny]=1;
                }
            }
        }
        return ans;
    }
    
    static int [][] dir = {{1,0} , {-1,0} , {0,1} , {0,-1}};


    static boolean isOutOfbounds( int x ,int y , int n , int m , int [][] g) {
        return (x < 0 || x > n-1 || y < 0 || y > m-1);
    }





    static class FastReader {
        BufferedReader b; StringTokenizer s;
        public FastReader() { b = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (s == null || !s.hasMoreElements()) { try { s = new StringTokenizer(b.readLine()); } catch (IOException e) { e.printStackTrace(); } } return s.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() { String str = ""; try { if (s != null && s.hasMoreTokens()) str = s.nextToken("\n"); else str = b.readLine(); } catch (IOException e) { e.printStackTrace(); } return str; }
    }
}