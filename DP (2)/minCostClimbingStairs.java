package DP;
import java.util.*;

public class minCostClimbingStairs {
    public static void main(String[] args) {
        int [] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostBU(cost));
    }
    static int minCostClimbingStairs(int[] nums) {
        int [] dp = new int[nums.length +1];
        Arrays.fill(dp , -1);
        return Math.min(minCost(nums , 0 , dp) , minCost(nums ,1 ,dp));


    }
    //top-down
    static int minCost( int [] nums , int step  , int [] dp) {
        if(step >= nums.length) {
            return 0;
        }
        if(dp[step] != -1) {
            return dp[step];
        }
        dp[step] =  nums[step] + Math.min(minCost(nums, step+1 ,dp ) ,minCost(nums, step+2 ,dp));
        return dp[step];
    }
    //bottom-up

    static  int minCostBU(int [] nums ){
        int [] dp = new int[nums.length +1];
        Arrays.fill(dp, -1);
        dp[0]= 0;
        dp[1] = 0;
        for(int i= 2 ; i <= nums.length ; i++) {
            dp[i]  = Math.min(dp[i-1] + nums[i-1]  , dp[i-2] + nums[i-2] );
        }
        return dp[nums.length];
    }
}
