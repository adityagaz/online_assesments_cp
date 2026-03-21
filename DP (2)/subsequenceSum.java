package DP;
import java.util.*;

public class subsequenceSum {
    public static void main (String [] args) {
            int [] nums = {10,1,2,7,6,1,5};
            int target  = 8;
            //donot make a boolean dp array as it will not help
        int [][] dp = new int [nums.length][target +1];

//        System.out.println(targetSum(nums , target , nums.length -1 , dp));

        System.out.println(targetSumBU( nums , target));
    }
    static boolean targetSumRecursive(int [] nums , int target ,int index ) {
        if(target == 0) {
            return true;
        }
        if(index < 0) {
            return false;
        }
        boolean pick; boolean noPick;
        if(nums[index]  > target ) {
            noPick = targetSumRecursive(nums , target , index -1 );
            return noPick;
        }
        else {
            pick = targetSumRecursive(nums , target - nums[index] , index -1 );
            if(pick) return pick;
            noPick = targetSumRecursive(nums , target , index -1 );
            return pick || noPick;
        }
    }
    static boolean targetSum(int [] nums , int target ,int index , int [][] dp  ) {
        if(target == 0) {
            dp[index][target] = 1;
            return true;
        }
        if(index < 0) {
            dp[0][target] = -1;
            return false;
        }
        if(dp[index][target] != 0) {
            if(dp[index][target] == 1) return true;
            else {
                return false;
            }
         }
        boolean pick; boolean noPick;
        if(nums[index]  > target ) {
            noPick = targetSum(nums , target , index -1  , dp );
            return noPick;
        }
        else {
            pick = targetSum(nums , target - nums[index] , index -1  , dp );
            if(pick) {
                dp[index][target] = 1;
                return true;
            }
            noPick = targetSum(nums , target , index -1 ,dp );
            return pick || noPick;
        }
    }

    static boolean targetSumBU(int [] nums , int target) {
        int [][] dp = new int[nums.length][target+1];
        //whereever the target is 0 then we can mark it as true;
        for( int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = 1;
        }
        //now for all targets where we are on index 0 we can say true if target == nums[0];
        for( int t = 1; t <= target ; t++ ) {
            if(t == nums[0]) {
                dp[0][t] = 1;
            }
            else {
                dp[0][t] = -1;
            }
        }
        for( int i = 1 ; i < dp.length ; i++) {
            for( int t = 1; t <= target ; t++) {
                if(nums[i] > t) {
                    dp[i][t] = dp[i-1][t];
                }
                else {
                    if(dp[i-1][t-nums[i]] ==1) {
                        dp[i][t] = 1;
                    }
                    else {
                        dp[i][t] = dp[i-1][t];
                    }
                }
            }
        }
        return (dp[nums.length-1][target] ==1 );
    }
}
