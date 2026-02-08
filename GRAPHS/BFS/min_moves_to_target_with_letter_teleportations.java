// package BFS;
//https://leetcode.com/problems/grid-teleportation-traversal/
import java.io.*;
import java.util.*;

/** 
 * @author 
 * Aditya Shandilya (RAM RAM`)
 */
class min_moves_to_target_with_letter_teleportations implements Runnable {
    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new min_moves_to_target_with_letter_teleportations(), "whatever", 1 << 30).start();
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


    Easy version of the problem -- There can be harder version where all the alphabets are allowed

    idea here is 

        meet in the middle...
        
        we donot need to worry about hops between different same alphabets 

        start -> A - > A -> A -> anyother alphabet -> end 
        will always incurr more moves than a simple 
        start -> A -> A -> end

        think greedily..!!!


        we can just compare 
        start -> any alphabet -> second occurrence -> end

        and that will do the job for us 



    Logic :


    */

    static void solve(FastReader sc) throws Exception {

        int t = sc.nextInt();
        // int t = 1;

        while (t-- > 0) {


            int n = sc.nextInt();
            int m = sc.nextInt();
            char [][] graph = new char[n][m];
            for( int i = 0; i < n ; i++ ) {
                graph[i] = sc.next().toCharArray();
            }

            Map<Character, Integer> start_map = new HashMap<>();
            Map<Character, Integer> end_map = new HashMap<>();

            for( int i = 0 ; i < 26; i++) {
                start_map.put((char)(i+'A') , (int)1e8);
                end_map.put((char)(i+'A'), (int)1e8);
            }


            int distanceWithoutTeleportations = bfs(graph , 0 , 0 , start_map,true);
            bfs(graph, n-1, m-1, end_map,false);

            int minMoves = (int)1e8;
            for( char ch : start_map.keySet()) {
                int startDistance = start_map.get(ch);
                int endDistance = end_map.get(ch);
                minMoves = Math.min(minMoves ,startDistance + endDistance);
            }

            //if min moves is still 1e8 means we did not find any valid teleportations.
            //Thus we need normal BFS.
            if(minMoves == (int)1e8) {
                minMoves = distanceWithoutTeleportations;
            }


            System.out.println(start_map);
            System.out.println(end_map);
            System.out.println(minMoves);
        }

    }

    static int [][] dir = {{0,1} , {0,-1} , {1 , 0} , {-1 ,0}};



    static int bfs(char [][] graph , int sx, int sy, Map<Character, Integer> map , boolean isStart) {
        int n=graph.length;
        int m=graph[0].length;
        int [][] dist  = new int[n][m];
        for( int [] i : dist ) Arrays.fill(i , (int)1e8);

        Queue<int [] > q = new LinkedList<>();
        q.add(new int [] {sx , sy , 0});
        dist[sx][sy] = 0;


        while(!q.isEmpty()) {
            int [] coord = q.poll();
            int x = coord[0];
            int y = coord[1];
            int distance = coord[2];
            char ch = graph[x][y];

            if(map.containsKey(ch)) {
                map.put(ch , Math.min(map.get(ch) , distance));
            }

            if(isStart && x == n-1 && y == m-1) return distance;
            
            
            for( int [] d : dir) {
                int nx = d[0] + x;
                int ny = d[1] + y;
                if(!isNotApplicable(nx, ny, n, m, graph) && dist[nx][ny]==(int)1e8) {
                    dist[nx][ny]=distance+1;
                    q.add(new int [] {nx ,ny , distance+1});
                }
            }            
        }

        return -1;
    }


    static boolean isNotApplicable( int x, int y , int n , int m , char [][] g) {
        return (x < 0 || y < 0 || x > n-1 ||  y > m-1 || g[x][y] == '#');
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