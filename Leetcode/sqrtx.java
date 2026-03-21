package Leetcode;


public class sqrtx {

    /*
    Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.


Example 1:

Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
     */
    public static void main(String[] args) {

        int num = 8;
        System.out.println(round_sqrt(2147395599));
    }


    static int round_sqrt(int x ) {
        if(x < 0) {
            return 0;
        }
        if(x ==1 || x ==0 ){
            return x;
        }
        int i = 1;
        int index = 0;
        while (i*i <=x) {
            index = i;
            i++;
        }

        return index;
    }
}
