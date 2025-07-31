import java.util.*;
public class max_sum_non_consecutive {
    

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 10, 7};
        System.out.println("Maximum sum of non-consecutive elements: " + maxSum_Non_Consecutive(arr, arr.length));
    }

    static int maxSum_Non_Consecutive(int [] arr , int n  ) {
        /*
          dp[i] -- denotes max sum till the index i where no non-consective elements are taken
          --> Option 1 : if we take the current element we can't take the previous element 
          dp[i] = arr[i] + dp[i-2];
          --> Option 2 : if we choose to skip this element then the answer till the last index is the answer for this index also 
          dp[i] = dp[i-1];

          Now, the base cases 

          dp[0] = arr[0]
          dp[1] = max(dp[0] , dp[1])


         */
        int [] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0] , arr[1]);
        for( int i = 2; i < n ; i++ ) {
            dp[i] = Math.max(arr[i] + dp[i-2] , dp[i-1]);
        }

        return dp[n-1];
    }
}