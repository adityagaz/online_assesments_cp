package Leetcode;
import java.util.*;
/*
https://leetcode.com/problems/set-mismatch/description/
You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.



Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 */

public class set_mismatch {
    public static void main (String [] args ) {
        int [] arr=  {1,1};
        System.out.println(Arrays.toString(set_mismatch(arr)));

    }

    static int [] set_mismatch (int []  nums ) {
//logic --> return an array of number which appeared twice and find the missing number and return the array
//find duplicate using cycle sort . see the number that will appear at the incorrect index will be the repeated one and d
//and the index +1 will the number that was supposed to be there and is missing now so add arr[i]<-- duplicate  , j+1 <-- missing number
        int [] result = new int[2];
        int i = 0 ;
        while(i < nums.length ) {
            int correct = nums[i] -1;
            if(nums[i] != nums[correct]) {
                int temp= nums[i];
                nums[i]= nums[correct];
                nums[correct] = temp;
            }
            else {
                i++;
            }
        }

        //check the array for missing and duplicate

        for( int j =0 ; j < nums.length  ; j++ ){
            if(nums[j] != j+1){
                result[0] = nums[j];
                result[1] = j+1;
            }
        }
        return result;
    }
}
