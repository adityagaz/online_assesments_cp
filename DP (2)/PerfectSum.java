package DP;
import java.util.*;
public class PerfectSum {
    public static void main(String[] args) {
        int [] arr = {5 ,2 ,3 ,10 ,6 ,8};
        int target = 10;
        int [][] dp = new int[arr.length][target+1];
        for( int [] i : dp) {
            Arrays.fill(i , -1);
        }
        System.out.println(recurMemo(arr, target , arr.length -1 , dp));
    }
    static int recur(int [] nums , int target , int index) {
        if(target  == 0 ) {
            return 1;
        }
        if(index < 0 ) {
            return 0;
        }
        int pick = recur(nums , target-nums[index], index-1) ;
        int notPick= recur(nums , target , index -1);
        return pick + notPick;
    }

    static int recurMemo(int [] nums , int target , int index , int [][]dp) {
        if(index == 0) {
            if(target == 0 &&  nums[0] == 0) {
                return 2;
            }
            else if(target == 0 || nums[0] == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if(target < 0) return 0;
        if(index < 0 ) {
            return 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int pick = recurMemo(nums , target-nums[index], index-1 , dp) ;
        int notPick= recurMemo(nums , target , index -1 , dp);
        dp[index][target] = pick + notPick;
        return dp[index][target];
    }

//    static int perfectSumBU()
}
