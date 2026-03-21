package Leetcode;

import java.util.Arrays;

public class squares_of_sorted_array {
    /*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.



Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
     */

    public static void main(String[] args) {
        int [] arr = {-4,-1,0,3,10};

        System.out.println(Arrays.toString(sorted_squares(arr)));
    }
    static int[] sorted_squares(int [] arr){
        //O(n) complexity
        //it is very trivial to iterate through the array and then sort it also it will take O(nlogn) time
        int [] result = new int[arr.length];
        int i = 0 ; int j = arr.length-1;
        int index = arr.length-1;
        while(i<=j ) {
            int left_sq = arr[i] * arr[i];
            int right_sq = arr[j] * arr[j];
            if(left_sq < right_sq) {
                result[index--] = right_sq;
                j--;
            }
            else {
                result[index--] = left_sq;
                i++;
            }
        }
        return result;
    }

}
