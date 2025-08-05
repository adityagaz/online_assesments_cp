package minimization;
import java.util.*;
public class at_coder_dp_task {
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);

         int n = s.nextInt();
            int [] arr = new int[n+1];
            long [] dp = new long[n+1];
            for ( int i = 1 ; i <= n ; i++ ) {
                arr[i]= s.nextInt();
            }
            // dp[i] -- minimum cost to reach city at index i .... Ans = min cost to reach city N
            dp[1] = 0;
            for( int i = 2 ; i <= n ; i++ ) {
                long way1 = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
                long way2 = i-2 < 1 ? Long.MAX_VALUE : dp[i-2] + Math.abs(arr[i] - arr[i-2]);
                dp[i] = Math.min(way1, way2);
            }
            System.out.println(dp[n]);
        }

    }

