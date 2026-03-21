package Leetcode;

public class validMountainArray {
     /*
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:
arr.length >= 3

There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true

      */


    public static void main(String[] args) {
     int []  arr  =  {0,3,2,1};
        System.out.println(isMountainArray(arr));
     
    }
    static boolean isMountainArray (int [] arr ){
        if( arr.length <3) {
            return false;
        }
        for (int i = 1; i < arr.length -2 ; i++) {
            if(isLeftSorted( arr , i) && isRightSorted(arr , i)) {
                return true;
            }
        }
        return false;
    }
    static boolean isLeftSorted(int [] arr , int index ) {
        for ( int  i  = 0 ; i  < index ; i++  ) {
            if( !(arr[i] < arr[i+1])){
                return false;
            }
        }
        return true;
    }
    static boolean isRightSorted(int [] arr , int index ) {
        for ( int  i  = index ; i< arr.length-1; i++) {
            if( !(arr[i] > arr[i+1])){
                return false;
            }
        }
        return true;
    }
}
//solved
