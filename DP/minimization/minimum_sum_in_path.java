package minimization;

import java.util.Scanner;

// Company Google 
/*
  Problem - 
  You’re given an array A of length N (1-indexed), which may contain positive or negative integers.
You start at index 1 and must reach index N.  From index i you may jump to index
  • i+1,
  • i+3, or
  • i+5
(as long as it doesn’t exceed N).  Your score is the sum of all A[i] you land on (including A[1] and A[N]).  
Compute the maximum possible score.

Constraints
— 1 ≤ N ≤ 10^5  
— –10^9 ≤ A[i] ≤ 10^9  
— Sum of all N over all tests ≤ 10^6  

Input
T
N
A[1] A[2] … A[N]
… (repeat T cases)

Output
one line per test: the maximum total score.
 */
public class minimum_sum_in_path {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int []arr = new int[n+1];
            for( int i = 1 ; i<= n ; i++ ) arr[i] =s.nextInt();
            int [] dp = new int[n+1];
            //dp[i] -- represents max score till index i if we can jump i+1 , i+3 , i + 5
            dp[1] = arr[1];
            for( int i = 2 ; i <= n ; i++ ) {
                int way1 = i-1 < 1 ? Integer.MIN_VALUE  : dp[i-1] + arr[i];
                int way2 = i-3 < 1 ? Integer.MIN_VALUE : dp[i-3] + arr[i] ;
                int way3 = i-5 < 1 ? Integer.MIN_VALUE : dp[i-5] + arr[i];
                dp[i] = Math.max(way1,Math.max( way2 , way3));
            }
            System.out.println(dp[n]);
        }
    }
    
}
