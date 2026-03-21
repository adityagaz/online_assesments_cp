package DP;
import java.util.*;
public class houseRobber {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        int [] dp = new int[nums.length +1 ];
        Arrays.fill(dp , -1);
        System.out.println(maxRobberMemo(nums , nums.length -1 , dp));
        System.out.println(maxRobberBU(nums));
    }
    //pure recursive code O(2^n)
//    static  int maxRobber(int  [] nums , int house) {
//        if(house  < 0 ) {
//            return 0;
//        }
//        int money = Math.max(maxRobber(nums , house -2 ) + nums[house] , maxRobber(nums, house -1));
//        return money;
//    }

    //recursive + memo
    static int maxRobberMemo(int [] nums , int house , int [] dp) {
        if( house  < 0) {
            return 0;
        }
        if(dp[house] != -1) {
            return dp[house];
        }
        dp[house]  = Math.max(nums[house] + maxRobberMemo(nums, house-2 , dp) , maxRobberMemo(nums , house -1 , dp));
        return dp[house];
    }

    //top-down  DP
    static  int maxRobberBU(int [] nums) {
        int [] dp = new int[nums.length +1];
        //since we have the base cases going till -1 we have to shift the dp by 1
        dp[0] = 0; //stores when it goes -1;
        dp[1] = nums[0];
        for( int i = 2 ; i <= nums.length;i++){
            dp[i] = Math.max(nums[i-1] + dp[i-2] , dp[i-1]);
        }
        return dp[nums.length];
    }
}
