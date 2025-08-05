package counting;
import java.util.*;
public class count_even_odd_paths {

    /*
      COMPANY -- GOOGLE 
      TOPICS - DP 
      Find the number of journeys where you start from index 1 and end at index ‘n’ 
      and the sum of every journey should be odd/even..
      Allowed to make jumps of size 1 or 2.

     */
    public static void main(String[] args) {
        Scanner s = new  Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for( int i = 0; i < n ; i++ ) {
            arr[i] = s.nextInt();
        }

        //dp[i][even] -- no of paths such ending at index i such that their path sum is even.
        // if arr[i] is even then it can connect to all dp[i-2][even] + dp[i-1][even]
        // if arr[i] is odd then it can connect dp[i-2][odd] + dp[i-1][odd]

        // for achieving odd sum 
        /*
          if arr[i] is even  we can connect to previous odd
          dp[i][odd] = dp[i-1][odd] + dp[i-2][odd]
          if arr[i] is odd
          dp[i][odd] = dp[i-1][even] + dp[i-2][even]

         */
        int [][] dp = new int[n][2];
         if((arr[0]&1) ==  1) {
            //odd 
            dp[0][0] = 1;
         }
         else {
            dp[0][1] = 1;
         }

         if((arr[1]&1)==1) {
            dp[1][0] = dp[0][1];
            dp[1][1] = dp[0][0];
         }
         else {
            dp[1][0] = dp[0][0];
            dp[1][1] = dp[0][1];
         }
         for( int i = 2 ; i < n ; i++ ) {
            if((arr[i]&1)==1) {
                //num is odd and we want odd 
                dp[i][0] = dp[i-1][1] + dp[i-2][1];
                dp[i][1] = dp[i-1][0] + dp[i-2][0];
            }
            else {
                // arr[i] --> even 
                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];

            }
         }

         System.out.println(dp[n-1][0] + " " +  dp[n-1][1]);

    }
}
