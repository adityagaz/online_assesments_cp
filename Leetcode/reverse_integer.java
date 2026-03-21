package Leetcode;

import java.util.Arrays;

public class reverse_integer {
    /*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
     */

    public static void main(String[] args) {
        int num  = -2147483412;
        System.out.println(rev_number(num));
    }

    static int rev_number( int num ) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;


        boolean flag_neg =false;
        if(num < 0 ){
        num *=-1;
        flag_neg = true;
    }

        int num_length = (int)(Math.log10(num)+ 1) ;
        int rev_num = 0;
        while ( num >  0 )
        {
            int rem  = num %10;
            if (rev_num > max / 10 || (rev_num == max / 10 && rem > 7)) {
                return 0;
            }
            if (rev_num < min / 10 || (rev_num == min / 10 && rem < -8)) {
                return 0;
            }
            rev_num = rev_num * 10 + rem;
            num/=10;
        }
        if(flag_neg){
            return rev_num*-1;
        }
        return rev_num;
    }
}
