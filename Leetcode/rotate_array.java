package Leetcode;

import java.util.Arrays;

public class rotate_array {
    /*
    leetcode 189
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100
     */
    public static void main(String[] args) {
        int [] given_arr ={1,2,3,4,5,6,7};
        rotate_array_by_k_places(given_arr , 3);
        System.out.println(Arrays.toString(given_arr));
    }
    static void rotate_array_by_k_places ( int [] arr , int k ){
        int [] newarr = new int[arr.length];
        int rem= k% arr.length;

        for (int i = 0; i < arr.length; i++) {
            int index = (i + k ) % arr.length;
            newarr[index] = arr[i];
        }
        arr=newarr;
    }
}
