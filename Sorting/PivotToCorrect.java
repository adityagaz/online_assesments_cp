package Sorting;
import  java.util.*;
public class PivotToCorrect {

    public static void main(String [] args ) {

        //try to solve the sub problem (Quick Sort) that is putting a pivot to the correct place

        //[10 , 80 , 30 ,90  40 , 50 , 70 ]
        // say out pivot is 30 so we shift all the elements in such a way that we have
        // all the elements smaller to 30 on the left side of 30
        // and all the elements greater than 30 to the right side of 30
        //OUTPUT --> [10,30,90,40,50,70]
        //basically try to place the pivot in the correct place


        int [] arr = {10, 80, 30 , 5 ,40 , 50 ,70 };
        int pivot = 0;

        PlaceCorrect(arr ,0 , arr.length -1);
        System.out.println(Arrays.toString(arr));


    }

    static void PlaceCorrect(int [] arr , int start , int end)  {

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
    }


    static void swap (int [] arr, int a , int b ) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
