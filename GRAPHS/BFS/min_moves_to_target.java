// package BFS; 
import java.io.*;
import java.util.*;

class min_moves_to_target implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new min_moves_to_target(), "whatever", 1 << 30).start();
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

    In a matrix of size m*n, 
    we can move in 4 directions (up, down, left, right) 
    # - denotes obstacles
    . - denotes free cell to move




    Logic :


    */



    static void solve(FastReader sc) throws Exception {

        // int t = sc.nextInt();
        int t = 1;

        while (t-- > 0) {
            //input matrix 

            int n = sc.nextInt();
            int m = sc.nextInt();
            char [][] graph = new char[n][m];
            for( int i =0 ; i < n ; i++) {
                graph[i] = sc.next().toCharArray();
            }

            System.out.println(bfs(graph));
            

        }
    }

    static int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    static int bfs(char [][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        int [][] vis = new int [n][m];
        for( int [] i : vis) Arrays.fill(i, -1);
        Queue<int []> queue = new LinkedList<>();
        vis[0][0]=1;
        queue.add(new int []{0 , 0 , 0});
        while(!queue.isEmpty()) {
            int [] coord = queue.poll();
            int x = coord[0];
            int y = coord[1];
            int moves = coord[2];
            if(x == n-1 && y == m-1) return coord[2];
            for( int [] d : dir) {
                int nx = x + d[0];
                int ny = y + d[1];
                if( !isOutOfbounds(nx, ny, n, m) && graph[nx][ny]=='.' && vis[nx][ny]!=1) {
                    vis[nx][ny]=1;
                    queue.add(new int [] {nx , ny , moves+1});
                }
            }
        }
        return -1;
    }


    static boolean isOutOfbounds( int x , int y , int n , int m ) {
        return !(x >=0 && y >= 0 && x < n && y < m);
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