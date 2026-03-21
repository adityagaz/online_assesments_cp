package Sorting;
import java.util.*;
public class SelectionSort {
    public static void main  (String [] args) {
        int [] arr = {4,5,1,2,3};
        insertionSort_max(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort_max( int [] arr) {
        for (int i  = 0 ; i < arr.length ; i++ ){
            //for each pass of i calculate the max in the non sorted part of the array
            int max = Integer.MIN_VALUE;
            int max_index = -1;
            for( int j = 0 ; j <= arr.length - i -1 ; j++ ) {
                if( arr [j] > max ){
                    max = arr[j];
                    max_index = j;
                }
            }
            //after finding the max element swap it with the last index or n- i -1 th index
            int temp = arr[arr.length-i-1];
            arr[arr.length -  i - 1] = max;
            arr[max_index] = temp;
        }
    }static void insertionSort_min( int [] arr) {
        for (int i  = 0 ; i < arr.length ; i++ ){
            //for each pass of i calculate the min in the non sorted part of the array
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for( int j = i ; j <= arr.length-1 ; j++ ) {
                if( arr [j] < min  ){
                    min = arr[j];
                    min_index = j;
                }
            }
            //after finding the min element swap it with the i th index
            int temp = arr[i];
            arr[i] = min;
            arr[min_index] = temp;
        }
    }



}
