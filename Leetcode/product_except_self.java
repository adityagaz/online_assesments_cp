package Leetcode;

import java.util.Arrays;

public class product_except_self {
    /*
    leetcode
238. Product of Array Except Self
Medium
Topics
Companies
Hint
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
     */

    public static void main(String[] args) {

        int arr []  = {1,2,3,4};
        int [] arr2 = {-1,1,0,-3,3};
        int [] arr3 = {1,0};
        int [] arr4 = { 0,0};
        int [] arr5 = {1,1};
        int []result = find_product(arr5);
        System.out.println(Arrays.toString(result));


    }
    static int[] find_product (int [] arr) {
        int [] answer = new int[arr.length];
        int skip_index  = 0 ;
        int product  = 1;
        if(multiple_zeros(arr)){
            for (int i = 0; i < arr.length; i++) {
                answer[i]=0;
            }
        }
        else{
            if( ContainsZero(arr) == 0 ) {
                for (int i = 0; i < arr.length* arr.length; i++) {
                    int rem = i % arr.length;
                    if(rem != skip_index) {
                        product *= arr[rem];
                    }
                    if ( rem == arr.length -1) {
                        answer[skip_index++] = product;
                        product =1;
                    }
                }
            }
            else {
                skip_index = ContainsZero(arr);
                for (int i = 0; i < arr.length; i++) {
                    if(i != skip_index) {
                        product*=arr[i];
                    }
                }
                answer[skip_index] = product;
            }
        }
        return answer;
    }

    static int ContainsZero(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                 return i;
            }
        }
        return 0;
    }static boolean multiple_zeros(int [] arr) {
        int count=0;
        for (int i = 0 ; i < arr.length; i++ ){
            if(count > 1){
                break;
            }
            else{
                if (arr[i]==0) {
                    count++;}
            }
        }
        return count>1 ? true :false;
    }

}
