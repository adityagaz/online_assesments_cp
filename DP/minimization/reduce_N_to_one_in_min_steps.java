package minimization;
import java.util.*;
public class reduce_N_to_one_in_min_steps {
    public static void main(String[] args) {
        int n = 93;
        int res = solve(n);
        System.out.println(res);
    }

    static int solve(int n) {
        /*
          Options we have 1. decrement the number by 1 2. decrement the number by 2
          3. divide the number by seven only if it is divisible by 7

          dp[i] -- means min steps to reduce the number i to 1 
          final answer is dp[n] -- min steps to reduce the number n to 1 and that's what we want

          so dp[1] = dp[0] = 0
          dp[2] = 1
          dp[3] = Math.min(1+ dp[3-1] , 1+dp[3-2] , 1 + dp[3/7] if 3 is >= 7 and divisible) 
          so.... dp[n] = min(dp[n-1] , dp[n-2] , INT_MAX if not divisible or less than 7 else dp[n/7]);

         */

         int [] dp = new int[n+1];
         dp[1] =0;
         dp[2] =1;
         for( int i = 3  ; i <= n ; i++ ) {
            if(i%7==0) {
                dp[i] = Math.min(dp[i/7]+1, Math.min(dp[i-1] +1, dp[i-2]+1));
            }
          
           else {
                dp[i] =  Math.min(dp[i-1]+1 , dp[i-2]+1);
           }
         }
         //93 -> 91 -> 13 -> 11 -> 9 -> 7 -> 1

         return dp[n];
    }
}
