package DP;
import java.util.*;
public class coinChangeii {
    public static void main(String[] args) {
        int [] arr = {1,2,5};
        int amount = 5; // return total number of ways in which we can get to 5

        int [][] dp = new int[amount +1 ][arr.length];
        for( int [] i : dp ) {
            Arrays.fill(i , -1);
        }
        System.out.println(allWays(arr , amount ,arr.length -1,dp));
        System.out.println(allWaysBU(arr, amount));

    }

    static  int allWays(int [] arr , int amount , int index , int [][] dp ) {
        if(amount == 0) return  1;
        if(amount < 0 || index < 0) return 0;

        if(dp[amount][index] != -1) return dp[amount][index];
        int takeAndStay = 0;
        if(arr[index] <= amount )  {
             takeAndStay = allWays(arr , amount - arr[index] , index , dp);
        }
        int notTake = allWays(arr , amount , index -1 ,dp);
        dp[amount][index] = notTake + takeAndStay;
        return dp[amount][index];
    }

    static int allWaysBU(int [] coins , int amount) {
        int [][] dp = new int[amount +1][coins.length];
        //if amount == 0
        for( int col = 0 ; col < coins.length ; col ++ ) {
            dp[0][col] = 1;
        }
        //if index == 0
        for( int row = 1; row < amount+1 ; row++) {
            if(row % coins[0] == 0) {
                dp[row][0] = 1;
            }
            else {
                dp[row][0] = 0;
            }
        }

        for( int row =1 ; row < amount +1 ; row++) {
            for( int col = 1; col < coins.length ; col++) {
                int takeAndStay =0;
                if(coins[col] <= row) {
                    takeAndStay = dp[row - coins[col]][col];//allWays(arr , amount - arr[index] , index , dp);
                }
                int notTake = dp[row][col-1];//allWays(arr , amount , index -1 ,dp);
                dp[row][col] = notTake + takeAndStay;
            }
        }
        return  dp[amount][coins.length -1];
    }

}
