package minimization;

import java.util.*;

public class min_steps_to_reach_target_hard_version {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [] arr = new int[n];
        for( int i = 0; i <n ; i++ ) arr[i] = s.nextInt();
        int res = minCost(arr , n , k);
        System.out.println(res);
        
    }

    static int minCost( int [] arr , int n , int  k) {
        int [] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = Math.abs(arr[1] - arr[0]);

        for( int i = 2 ; i < n ; i++  ) {
            for( int j = 1 ; j <=k  ; j++ ) 
            {
                if(i-j < 0 ) continue;
                dp[i] = Math.min(dp[i] ,  dp[i-j] + Math.abs(arr[i] - arr[i - j]) );
            }
        }

        return dp[n-1];
    }
}
