package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class trapping_rain_water {
    /*
    Hard
Topics
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.


Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
     */
    //given an array find the leftmost and the rightmost maximum for each element in the given array.
    //give the function arr
    public static void main(String[] args) {
        int [] arr = {0,1,0,2,1,0,1,3,2,1,2,1}; //ans = 6
        int [] arr2 = {4,2,0,3,2,5}; //ans = 9;
        int [] arr3 = {4,2,0,3};

        System.out.println(trapped_water_size(arr3));
    }
    static int trapped_water_size (int arr[]) {
        int sum = 0 ;

         int [] left_most_maximum = new int[arr.length];
         int [] right_most_maximum = new int[arr.length];

         left_most_maximum[0] = arr[0];
         for(int i = 1  ; i < arr.length ; i++)
         {
             left_most_maximum[i] = Math.max(arr[i], left_most_maximum[i-1]);
         }
         right_most_maximum[arr.length -1 ] = arr[arr.length -1];

         for (int i = arr.length -2  ; i >=0 ; i--) {
             right_most_maximum[i] = Math.max(arr[i] , right_most_maximum[i+1] );
         }

        for (int i = 0; i < arr.length; i++) {
            sum+= (Math.min(left_most_maximum[i] , right_most_maximum[i])) - arr[i];
        }
        System.out.println(Arrays.toString(left_most_maximum));
        System.out.println(Arrays.toString(right_most_maximum));
        return sum;
    }
//
//    static int left_most_maximum(int [] arr ,int index){
//        if(index == 0) {
//            return arr[0];
//        }
//        int left_max = Integer.MIN_VALUE;
//        for(int i  = 0 ; i <= index ; i++ ){
//            if(arr[i] > left_max) {
//                left_max = arr[i];
//            }
//        }
//        return left_max;
//    }
//    static  int right_most_maximum (int[] arr , int index) {
//        if(index == arr.length -1 ) {
//            return arr[arr.length-1];
//        }
//        int right_max =Integer.MIN_VALUE ;
//        for (int i = index; i < arr.length ; i++) {
//            if(arr[i] > right_max ){
//                right_max  = arr[i];
//            }
//        }
//        return right_max;
//    }

}
