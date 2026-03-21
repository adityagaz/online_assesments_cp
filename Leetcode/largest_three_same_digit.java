package Leetcode;
/*
You are given a string num representing a large integer. An integer is good if it meets the following conditions:

It is a substring of num with length 3.
It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.

Note:

A substring is a contiguous sequence of characters within a string.
There may be leading zeroes in num or a good integer.


Example 1:

Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:

Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:

Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.


Constraints:

3 <= num.length <= 1000
num only consists of digits.


 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class largest_three_same_digit {

    public static void main(String[] args) {

        String number = "42352338";
        System.out.println(good_maximum_substring(number));

    }
    static String good_maximum_substring ( String number ){
        int [] num_array = new int [number.length()];
        for ( int i = 0  ; i< num_array.length ; i++ ){
            num_array[i] = number.charAt(i) - '0';
            //to convert character into integer
        }
        ArrayList<Integer> good_substring = new ArrayList<>();
        for (int i = 0 ; i < num_array.length -2 ; i++   )
        {
            if(num_array[i] == num_array[i+1] && num_array[i] == num_array[i+2]) {
                if(!good_substring.contains(num_array[i])){
                    good_substring.add(num_array[i]);
                }
            }
        }
        if(!good_substring.isEmpty()){
//            int max = Collections.max(good_substring);
            int max = Integer.MIN_VALUE;
            for ( int i =0 ; i < good_substring.size() ; i++ ){
                if(good_substring.get(i) > max) {
                    max = good_substring.get(i);
                }
            }
            int[] good_arr = {max, max, max};

            StringBuilder sb = new StringBuilder();
            for (int num : good_arr) {
                sb.append(num);
            }
            return sb.toString();
        }
        return "";

//
    }
}
