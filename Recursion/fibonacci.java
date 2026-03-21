package Recursion;

public class fibonacci {
    public static void main(String[] args) {

        int num_to_find = 5;
        System.out.println(fibonacci(50));
        //since this is a large number we cannot use simple recursion to get the answer
        // we will use dp and memoization to do this

    }

    static int fibonacci (int n) {
        if (n < 2) {
            return n;
        }
        int index = n-1;
        int [] dp = new int[n];
        if(dp[index] != 0) {
            return dp[index--];
        }
        dp[index] = fibonacci( n-1 ) + fibonacci( n -2 );
        return dp[index--];
    }
}
