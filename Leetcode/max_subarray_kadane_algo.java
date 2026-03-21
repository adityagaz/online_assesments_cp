package Leetcode;

import java.util.ArrayList;

public class max_subarray_kadane_algo {

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

        System.out.println(maximum_sub_array_sum(arr));

    }
    //finally this algorithm prints the perfect maximum sub array sum and also finds the array.
    static int maximum_sub_array_sum (int [] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        int startindex = -1;int end = -1; int start =-1;
        for (int i = 0; i < arr.length; i++) {
            if(sum == 0) {
                start = i ;
            }
            sum+=arr[i];
            if (sum > maxi) {
                maxi = sum;
                startindex =start;
                end = i;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        for (int i = startindex ; i <=end ; i++) {
            list.add(arr[i]);
        }
        System.out.println(list);
        return maxi;
    }
}
