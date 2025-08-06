package counting;

import java.util.*;

public class count_steps_to_reduce_to1 {
    /*
     * You are given a positive integer 'N’. Your task is to find and return the
     * minimum number of steps
     * that 'N' has to take to get reduced to 1.
     * You can perform any one of the following 3 steps:
     * 1) Subtract 1 from it. (n = n - ­1) ,
     * 2) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
     * 3) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).
     * 
     * dp[1] = 0
     * dp[2] = 1 + dp[1] (op1)
     * dp[2] = 1 + dp[1] (op2) similar to google OA ... 
     * 
     * 
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int way1 = 1 + dp[i - 1];
            int way2 = (i % 2 == 0) ? 1 + dp[i / 2] : (int) 1e8;
            int way3 = (i % 3 == 0) ? 1 + dp[i / 3] : (int) 1e8;
            dp[i] = Math.min(Math.min(way1, way2),way3);
        }

        System.out.println(dp[n]);

    }
}
