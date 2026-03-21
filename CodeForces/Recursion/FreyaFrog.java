package CodeForces.Recursion;

import java.util.Scanner;

//this code fails at larger test cases and is not correct!!!

public class FreyaFrog {

    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0 ; i < n ; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            int k = s.nextInt();
            System.out.println(solve(x , y , k ));
        }

    }
    static int solve(int a ,int b , int k)  {
        int size = Math.max(a , b);
        boolean [][] visited = new boolean [size*1000][size*1000];

        Integer [][][]dp =  new Integer[size*10][size*10][size*10];
        return paths(a, b, k , visited , 0, 0,0,0 ,dp );

    }
    static int paths (int a , int b , int k  , boolean [][] visited , int x ,int y , int count , int chance ,Integer [][][]dp) {
        count++;
        if(x == a  && y == b ) {
            int res = count;
            return res-1;
        }

        if(visited[x][y]){
            return 0;
        }
        if(dp[x][y][count]!=null) {
            return dp[x][y][count];
        }

        if( y > b || x > a) {
            return 0;
        }
        visited[x][y] = true;
        int ans = Integer.MAX_VALUE;

        for (int i  = 1 ; i <= k ; i++) {
            if(chance == 0 ){
                int temp = paths(a , b , k , visited , x+i , y, count ,chance ^1 ,dp);
                if(temp != 0) {
                    ans = Math.min(ans , temp);
                }
            }
            else {
                int temp = paths(a , b , k , visited , x , y+i, count ,chance ^1 ,dp);
                if(temp != 0) {
                    ans = Math.min(ans , temp);
                }
            }
        }
        dp[x][y][count] = ans;
        visited[x][y] = false;

        return ans;

    }
}
