package Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main (String [] args) {


        int [] arr = {10, 80, 30 , 5 ,40 , 50 ,70 };
        qs(arr, 0 , arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    static void   qs(int [] arr  , int start  ,int end) {
        //base case
        if(start >= end  ) {
            return;
        }

        int pivot = PlaceCorrect(arr, start , end );

        qs(arr, 0 ,pivot);
        qs(arr, pivot+1, end);

    }
    static int PlaceCorrect(int [] arr , int start , int end)  {

        int pivot = start + (end -  start) /2;
        int pivot_el = arr[pivot];
        while (start < end ) {
            if(arr[start] < pivot_el) {
                start++;
            }
            if(arr[end] > pivot_el ){
                end--;
            }
            else {
                swap(arr, start , end);
            }
        }
        return start;
    }
    static void swap (int [] arr, int a , int b ) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
