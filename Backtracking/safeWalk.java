package Backtracking;
import java.util.*;

public class safeWalk {
    public static void main (String [] args) {


        int [][]arr = {
                {0,1,1,0,0,0},{1,0,1,0,0,0},{0,1,1,1,0,1},{0,0,1,0,1,0}
        };
        int [][]arr1 = {
                {1,1,1,1}
        };

        List<List<Integer>> grid = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++) {
            List<Integer> temp = new ArrayList<>();
            for( int j =0 ; j < arr[0].length ; j++) {
                temp.add(arr[i][j]);
            }
            grid.add(temp);
        }

        System.out.println(grid);

        boolean [][] maz = new boolean[grid.size()][grid.get(grid.size() -1 ).size()];
        int health  =4;

        System.out.println(findSafeWalk(grid , health));



    }

    static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        boolean [][] maz = new boolean[grid.size()][grid.get(0).size()];
        Boolean[][][] dp = new Boolean[grid.size()][grid.get(0).size()][health + 1];
        return isSafe(grid , health , 0 ,0 ,maz ,dp);
    }

    static boolean isSafe(List<List<Integer>> grid, int health , int row , int col , boolean [][] maz , Boolean [][][]dp) {
        if(grid.get(row).get(col) == 1) {
            health -= 1;
        }

        if( health >= 1 && row  == grid.size()-1 && col == grid.get(0).size() -1 )  {
            return true;
        }

        if( row < 0 || col < 0  || col >= grid.get(0).size() || row >= grid.size() ) {
            return false;
        }

        if(health < 1){
            return false;
        }

        if(maz[row][col]) {
            return false;
        }
        if(dp[row][col][health]!=null) {
            return dp[row][col][health];
        }

        maz[row][col] = true;





        int newHealth = health;


        boolean result = false;

        //go left
        if(col > 0) {

            result = result || isSafe(grid , newHealth , row , col-1, maz ,dp);

        }

        //go up

        if(row > 0){
            result = result || isSafe(grid , newHealth , row-1 , col ,maz ,dp);
        }

        //go right
        if(col < grid.get(0).size() -1 ) {

            result = result || isSafe(grid , newHealth , row , col +1, maz ,dp);

        }
        //go down
        if(row < grid.size() -1  ) {

            result = result || isSafe(grid , newHealth , row +1 , col, maz , dp);
        }

        dp[row][col][health] = result;
        maz[row][col] = false;

        return result;
    }
}
