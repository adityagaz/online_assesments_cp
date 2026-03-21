package Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class twosum {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

     */
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int arr1[]  = {0,4,3,0};
        int [] result = index_two_sum(arr1  , 0);
        System.out.println(Arrays.toString(result));
    }
    static int[] index_two_sum(int[] arr, int target) {
        for (int k = 0; k < arr.length - 1; k++) {
            for (int l = k + 1; l < arr.length; l++) {
                if (arr[k] + arr[l] == target) {
                    return new int[]{k, l};
                }
            }
        }
        return arr;
    }

    static int [] two_sum_optimized(int [] nums , int target) {
        HashMap<Integer ,Integer > map = new HashMap<>();

        for( int i = 0 ; i < nums.length ; i++ ) {

            System.out.println(map);
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]) , i};
            }
            else
            {
                map.put(nums[i] , i);
            }
        }
        return new int [] {-1,-1};
    }
}
