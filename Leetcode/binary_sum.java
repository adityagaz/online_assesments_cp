package Leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class binary_sum {
    /*
    67. Add Binary
Easy
Topics
Companies
Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"

     */

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(binary_sum(a,b));


    }
    static String binary_sum(String a ,String b ) {
        char [] input_arr = a.toCharArray();
        char [] input_arr2 = b.toCharArray();
        int value_one = convert_to_base_ten(input_arr);
        int value_two = convert_to_base_ten(input_arr2);
        value_one +=value_two;
        String s = convert_to_binary_string(value_one);
        return s;
    }

    static int convert_to_base_ten(char [] arr) {
        int decimal = 0;
        for (int i = 0; i < arr.length; i++) {
            decimal = decimal * 2 + (arr[i] - '0');
        }
        return decimal;
    }

    static String convert_to_binary_string(int num) {
        StringBuilder s = new StringBuilder();
        while ( num >  0) {
            int rem = num %2;
            num/=2;
            s.append(rem);
        }
        s.reverse();
        return s.toString();
    }


}
