
import java.util.*;
public class subsequences_max_len_such_that_adjacent_elem_modK_is_same {
    public static void main(String[] args) {
        /*
         Question - 
         Given an array of length n 
         we have to make subsequence from array of maximum length such that 
         every adjacent element's sum % k is same 
         Formally, 
         say the subsequence was {a , b, ,c, d, e}
         then (a+b)%k == (b+c)%k ==(c+d)%k == (d+e)%k

         Approach-
         Now how to think this problem 
         Simplify the constraint 
         let's discuss for k = 2
         now we know that remainders can be only in the range [0..1]
         i.e 0 or 1
         Now 
         so one option is if we have 0,0,0,0,0,...
         another option is chain all ones 1,1,1,1,...
         now 0,1,0,1,0,1,...can also be an option because (0+1) = (1+0) = (0+1) and so on...
         also 1,0,1,0...can be an option

         Now we observe two things here 
         if we are at index i then we can check what is the maximum length of subsequence 
         if current remainder is i and prev was also i
         so states of dp can be [current_remainder][prev_remainder]
         now let's say we are at i and arr[i]%2 = 0
         now we can chain this 0 to previous chain of zeros or we can chain this to previous chain on 1 whose
         previous was 0 (i mean alternating)
         dp[0][0] --> current_rem = 0 and prev_rem = 0 i.e we want to chain with 0 (where all the remainders in chain are 0s only)
         dp[0][1] --> current_rem = 0 and prev_rem = 1 we want to chain with 1 whose prev was 0 and whose prev was 1 and so on...

         Formulating the first condition is easy as dp[0][0] = max(dp[0][0] , 1 + dp[0][0]) //just adding 1 to chain
         Now we have maintained dp states as curr_rem and prev_rem because
         dp[0][1] --> curr_rem = 0 , want prev_rem as 1
         dp[1][0] --> curr_rem = 1 , want prev_rem as 0 //voilaa! solved 
         we can say dp[0][1] = max(dp[0][1] , 1 + dp[1][0]) --> means add 1 to prev remainder 1 and whose required was 0 making
         it alternating.
         
         finally we can write return max(dp[0][0] , dp[1][1] , dp[0][1] , dp[1][0])
         but, now lovely people 
         what if the k was not 2 and it was k then our remainder would have been [0...k-1] 
         so we will do the same again 
         just add a k for loop
         int max = INT_MIN; 
         for( i = 0 to n) 
            int rem = arr[i]%k;
            for( int j = 0 to k) 
                dp[rem][j] = max(dp[rem][j] , 1 + dp[j][rem]);
                max = max(max, dp[rem][j]);
        These two loops will make sure that all the combinations are generated
        k = 2
        0 ,0 
        0, 1,
        1 ,0 
        1 ,1

        return max
         */


         Scanner s = new Scanner(System.in);
         int t = s.nextInt();
         while(t-- > 0 ) {
            int n = s.nextInt();
            int k = s.nextInt();
            int [] arr = new int [n];
            for( int i =0 ;i < n ; i++ ) arr[i] = s.nextInt();
            solve(arr , n,k);
         }
    }

    static void solve( int [] arr , int n , int k) {
        int [][] dp = new int[k][k];
        int ans= 0;
        for( int i = 0 ; i < n ; i++ )  {
            int rem = arr[i]%k;
            for( int j = 0; j < k ; j++ ) {
                dp[rem][j] = Math.max(dp[rem][j] , 1 + dp[j][rem]); 
                ans = Math.max(ans , dp[rem][j]);
            }
        }

        System.out.println(ans);

    }
}
