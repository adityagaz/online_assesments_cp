package Recursion;

public class Maze {

    public static void main (String [] args) {
        //given a maze of n * n output the number of paths so that we can reach to the end
        //for example we have to react (0,0) from (3,3)

        int row = 20;
        int column = 20;
        Integer[][] arr = new Integer[row+1][column+1];

        long start_naive = System.nanoTime();
        System.out.println(maze_paths(row,column,arr));
//        System.out.println(maze_paths_two(row,column));
        long end_naive = System.nanoTime();
        System.out.println((end_naive - start_naive)/Math.pow(10,9));


    }
    //with memoization
    static int maze_paths(int r , int c , Integer[][] dp){
        if( r== 1 || c == 1){
            return 1;
        }

        if(dp[r][c] != null ) {
            return dp[r][c];
        }

        dp[r][c] = maze_paths(r-1 , c , dp)+ maze_paths(r , c-1 , dp);
        return dp[r][c];

    }
    //without memoization
    static int maze_paths_two(int r , int c ){
        if( r== 1 || c == 1){
            return 1;
        }

      return maze_paths_two(r-1 , c )+ maze_paths_two(r , c-1 );
    }
}
