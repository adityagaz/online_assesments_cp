// package your.package.name;

import java.io.*;
import java.util.*;

class grid_teleportation_traversal implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new grid_teleportation_traversal(), "whatever", 1 << 30).start();
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


         We can do a bfs starting from 0 , 0 
            whenever we reach a cell which is marked (A...Z)

                then we have the option to teleport 
                    since it is the nearest teleportation portal we incur the minimum cost here 
                    add all the coordinates where we can go to the queue

                    bfs will automatically go to the shortest paths from there.

                    just think of extending the idea of bfs..



                    if anytime we get to n-1, m-1 we immediately return.

                    and that's our answer.

                





    Logic :


    */



    static void solve(FastReader sc) throws Exception {

        // int t = sc.nextInt();
        int t = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char [][] graph = new char[n][m];
            for( int i = 0 ; i < n ; i++ ) graph[i]=sc.next().toCharArray();
            int minMoves = bfs(graph);
            System.out.println(minMoves);
        }

    }

    static int bfs(char [][] graph) 
    {
        int n = graph.length;
        int m = graph[0].length;
        boolean [][] vis = new boolean[n][m];
        Map<Character , List<int []>> map = new HashMap<>();
        for( int i = 0 ; i < 26; i++) {
            map.put((char) ('A' + i ), new ArrayList<>());
        }
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < m ;j++) {
                char ch = graph[i][j];
                if(ch >= 'A' && ch <= 'Z') {
                    map.get(ch).add(new int [] {i,j});
                }
            }
        }

        Deque<int []> q = new ArrayDeque<>();
        q.add(new int [] {0,0,0});
        vis[0][0]=true;

        while(!q.isEmpty()) {
            int [] coord = q.poll();
            
            int x = coord[0];
            int y = coord[1];
            int distance = coord[2];

            if(x == n-1 && y ==m-1) return distance;

            char ch = graph[x][y];

            if(ch >= 'A' && ch <= 'Z' && map.containsKey(ch)) {
                for( int [] cords : map.get(ch)) {
                    q.addFirst(new int []{cords[0] , cords[1] , distance});
                    vis[cords[0]][cords[1]] = true;
                    
                }
                map.remove(ch);
            }

            for( int [] d : dir ) {
                int nx = d[0] + x;
                int ny = d[1] + y;
                if(!isNotApplicable(nx , ny , n , m , graph) && !vis[nx][ny]) {
                    q.addLast(new int [] {nx ,ny , distance + 1});
                    vis[nx][ny]=true;
                }
            }
        }

        return -1;
    }

    static boolean isNotApplicable( int x, int y , int n , int m , char [][] g) {
        return (x < 0 || y < 0 || x > n-1 ||  y > m-1 || g[x][y] == '#');
    }
    static int [][] dir = {{0,1} , {0,-1} , {1 , 0} , {-1 ,0}};








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