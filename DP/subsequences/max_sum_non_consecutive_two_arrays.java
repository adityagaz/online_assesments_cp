import java.util.*;
public class max_sum_non_consecutive_two_arrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr1 = new int[n];
        int [] arr2 = new int[n];
        for( int i =  0 ; i < n ; i++) arr1[i] = s.nextInt();
        for( int i =  0 ; i < n ; i++) arr2[i] = s.nextInt();
        int res = solve( arr1 , arr2 , n);
        System.out.println(res);
    }

    static int solve(int [] arr1 , int [] arr2 , int n) {
        /*
        option 1 is to choosing to take elements from arr1 and arr2
        so we must take the max of those to maximize the sum 
        dp[i] -- max sum taken till index i from both arrays considering that no two elements were taken consecutively from any of the arrays
        for ex if we choose to take the index 5 from arr1  then we can't take index 4 from arr1 or array2 and also can't take index 5 from arr2
        --> Option 1 
        Choose
        dp[i] -- Max(arr1[i] , arr2[i] ) + dp[i-2];
        Skip 
        dp[i] -- dp[i-1]
        finally 
        dp[i] -- max(max(arr1[i] , arr2[i] ) + dp[i-2] , dp[i-1])
        @base cases 
        both arrays are of length 1 
        dp[0] = max(arr1[0] , arr2[0]);
        both arrays are of length 2
        dp[1] = max(max(arr1[1] , arr2[1] ) , dp[0])
        then the loop continues
        */
        int [] dp = new int[n];
        dp[0] = Math.max(arr1[0] , arr2[0]);
        dp[1] = Math.max(Math.max(arr1[1] , arr2[1]) , dp[0]);
        for( int i = 2 ; i < n ; i++ ) {
            dp[i] = Math.max(Math.max(arr1[i] , arr2[i] ) + dp[i-2] , dp[i-1]);
        }
        return dp[n-1];
    }
}
