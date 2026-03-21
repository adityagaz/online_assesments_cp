package DP;
import java.util.*;
public class JumpGame {
    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
       int [] dp = new int[nums.length];
       Arrays.fill(dp , -1);
        System.out.println(canJump(nums  , 0 , dp));
    }

    static boolean canJump(int [] arr , int index  , int [] dp) {
        if(index == arr.length -1) return true;
        if(index >= arr.length) return false;
        if(arr[index] == 0 ) return false;
        if(dp[index]!=-1) {
            return dp[index] == 1;
        }
        boolean ans = false;
        for( int i = 1 ; i <= arr[index] ; i++) {
            if(ans) break;
            ans = canJump(arr, index+  i , dp);
        }
        if(ans) dp[index] = 1;
        else dp[index] = 0;
        return ans ;
    }
}
