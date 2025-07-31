

package minimization;
import java.util.*;
public class min_steps_to_reach_target {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for( int i = 0; i <n ; i++ ) arr[i] = s.nextInt();
        int res = minCost(arr , n);
        System.out.println(res);
        
    }
    
    static int minCost(int [] arr , int n)  {
        /*
          dp[i] -- means the minimum cost to reach the target index i
          target can be reached by i -1 or i -2

          dp[0] = 0 because the frog was already at index zero
          dp[1] = Math.abs(arr[1] - arr[0])
          dp[2] = Math.min(abs(arr[2] - arr[0] + dp[0]) , abs(arr[2] - arr[1] + dp[1]))
          ...
          dp[i] = min(abs(dp[i-1] + arr[i] - arr[i-1]) , abs (dp[i-2] + arr[i] - arr[i-2]));
         */
        int [] dp = new int[n];
        dp[0]=0;
        dp[1]=Math.abs(arr[1] - arr[0]);
        dp[2]=Math.min(Math.abs(arr[2] - arr[1]) + dp[1] , Math.abs(arr[2] - arr[0]) + dp[0]);
        for( int i = 3 ;i < n ; i++) {
            dp[i] = Math.min(Math.abs( (arr[i] - arr[i-1])) + dp[i-1]  , dp[i-2] + Math.abs( (arr[i] - arr[i-2])));
        }

        return dp[n-1];
    }
    
}