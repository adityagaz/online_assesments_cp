package Leetcode;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class sum_of_squares {
    /*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
Example 1:
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: c = 3
Output: false
     */
    public static void main(String[] args) {

        int num = 3;
        System.out.println(is_sum_square(3));
    }
    static boolean is_sum_square(int target) {
        if(target <0) return false;

        int start = 0;
        int end = (int) Math.sqrt(target);
        while (start <= end) {
            long sum_of_squares = (long)(start * start) + (long)(end*end);

            if(sum_of_squares == target){
                return true;
            }
            if(sum_of_squares > target) {
                end--;
            }
            else  {
                start++;
            }
        }
        return false;
    }

}
