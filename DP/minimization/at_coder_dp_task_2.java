
package minimization;
import java.util.*;
public class at_coder_dp_task_2 {
    

    /*
    //https://atcoder.jp/contests/dp/tasks/dp_b

There are N stones, numbered  1,2,…,N. For each i (1≤i≤N), the height of Stone is hi
There is a frog who is initially on Stone 
1. He will repeat the following action some number of times to reach Stone N:
If the frog is currently on Stone 
i, jump to one of the following: Stone 
i+1,i+2,…,i+K. Here, a cost of |hi- hj| is incurred, where 
j is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone N.
     */
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);

            int n = s.nextInt();
            int k = s.nextInt();
            int [] arr = new int[n+1];
            long [] dp = new long[n+1];
            for ( int i = 1 ; i <= n ; i++ ) {
                arr[i]= s.nextInt();
            }
            // dp[i] -- minimum cost to reach city at index i .... Ans = min cost to reach city N
            Arrays.fill(dp, Long.MAX_VALUE);
            dp[1] = 0;
            dp[2] = Math.abs(arr[2]-arr[1]);
            for( int i = 3 ; i <= n ; i++ ) {
                for( int j = 1; j <= k; j++ ) {
                    long way1 = i-j < 1 ? Long.MAX_VALUE : dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    dp[i] = Math.min(dp[i], way1);
                }
            }
            System.out.println(dp[n]);
        }

    }

