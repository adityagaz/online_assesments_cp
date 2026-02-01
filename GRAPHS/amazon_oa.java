import java.util.*;

public class amazon_oa {
    static boolean [][]vis;
    static int [][] g;
    static int [][] ans;
    static int [][] dir = {{0,1} ,{1 ,0} ,{-1, 0}, {0, -1}, {1 ,1}, {1, -1}, {-1, 1}, {-1, -1} };
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        vis = new boolean[n][m];
        g = new int[n][m];
        ans = new int [n][m];
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < m ; j++ ) {
                g[i][j]=s.nextInt();
            }
        }
        bfs(g , vis, ans);
    }
    static void bfs(int [][] g , boolean  [][] vis , int [][] ans) {
        Queue<int []> q = new LinkedList<>();
        int n = g.length , m = g[0].length;
       for( int i= 0 ; i< n; i++  ) {
            for (int j =0; j < m; j++ ) {
                if(g[i][j]==1){
                    q.add(new int [] {i,j ,0});
                    vis[i][j]=true;
                }
            }
       }
       while(!q.isEmpty()){
        int [] curr = q.poll();
        int r = curr[0] , c = curr[1] , level = curr[2];
        ans[r][c]=level;
            for( int [] d : dir ){
                int ni = d[0]+r;
                int nj = d[1] +c;
            if(ni>=0&&nj>=0&&ni<=n-1&&nj<=m-1 && !vis[ni][nj] && g[ni][nj]!=1){
                    q.add(new int [] {ni  , nj , level +1});
                    vis[ni][nj]=true;
                }
            }
       }
       for( int [] i : ans) {
            for( int j : i) System.out.print(j + " ");
            System.out.println();
       }


    } 
}
