package DP;

import java.sql.SQLOutput;
import java.util.Arrays;

public class fibonacciDP {

    public static void main(String[] args) {
        //we know using recursion fibonacci takes a hefty O(2^n) time

        //so in order to reduce that we ca use a dp array

        int find_fib = 25;
        System.out.println(fibo_dp(find_fib));

    }

    static  int fibo_dp(int find_fib ) {

        //bottom up memoization approach but it is O(n) space // we can reduce it further by just taking the
        int [] f  = new int [find_fib];
        f[0] = 0;
        f[1] = 1;
        int i =2;
        for (; i < find_fib ; i++ ){
            int sum = 0;
            sum += f[i-1] + f[i-2];
            f[i] = sum;
        }
        System.out.println(Arrays.toString(f));
        //array approach
        return f[i-1];
    }


    static int fibo_dp_optimised(int find_fibo) {
        //now this approach is takes O(1) space and O(n) time
        int i = 0;
        int j  = 1 ;
        int prev_sum = 0;
        for( int l = 2 ;l <find_fibo ; l ++  ) {
            int sum = i + j;
            prev_sum = sum;
            i = j;
            j=prev_sum;
        }
        return prev_sum;
    }
}
