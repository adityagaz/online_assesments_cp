package Leetcode;

import java.util.Arrays;

public class missing_number {
    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
     */
    public static void main(String[] args) {
        int [] arr = {0,1};
        System.out.println(missing_element(arr));
    }

    static int missing_element(int []arr) {
        //approach 1
        //sort the array
        //if the next element is
        Arrays.sort(arr); //here the complexity becomes O(nlogn)
        if(arr[0]!=0) {
            return 0;
        }
        for (int i = 0 ; i < arr.length -1 ; i++ ) {
            if(arr[i+1]  - arr[i] > 1) {
                return i+1;
            }
        }
        if(arr[arr.length-1] != arr.length) {
            return arr.length;
        }
        return -1;

        //we can do it via cycle sort

    }
}
