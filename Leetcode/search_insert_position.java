package Leetcode;

public class search_insert_position {
    /*
    35. Search Insert Position
Easy
Topics
Companies
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
     */

    public static void main(String[] args) {

        int [] arr = {1,3,5,6};
        int target = 2;
        System.out.println(search_position(arr, target));

    }
    static int search_position (int [] arr  , int target) {
        int start = 0; int end = arr.length-1;
        if(target  > arr[end]) return arr.length;
        while ( start < end ){
            int mid = start + (end - start)/2;
            if( target == arr[mid]) return mid;
            else if(target > arr[mid]) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return end;
    }
}
