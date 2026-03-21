package Leetcode;

public class maximum_subarray {
/*
Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.


Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


i tried so hard for this question but couldnot complete
finally all test cases passed but time limit on leetcode exceeded !
now i will learn kadane's algorithm to improve the time complexity

 */
    public static void main(String[] args) {
        int [] arr3 = {-2,1};
        int [] arr = {-2,-3,4,-1,-2,1,5,-3};
        int [] arr2 = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maximum_sub_array_sum(arr3));
    }
    static int maximum_sub_array_sum (int [] arr){
        if(arr.length ==1 ){
            return arr[0];
        }
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int maximum_iter = arr[i];
            if(maximum_iter > max) {
                max = maximum_iter;
            }
            for (int j  = i+1 ; j < arr.length ; j++  ) {
                int sum = 0;
                sum = maximum_iter + arr[j];
                maximum_iter = sum;
                if (maximum_iter > max) {
                    max = maximum_iter;
                }
            }
        }
        return max;
    }
}
