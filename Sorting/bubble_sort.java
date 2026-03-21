package Sorting;
import java.util.*;
public class bubble_sort {

    public static void main(String [] args ) {
        int [] arr =  { 4,5,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    static void bubbleSort(int [] arr) {
        int asc_count =0;
        int desc_count = 0;
        // go till arr.len -1
        for (int i = 0 ; i < arr.length ; i++ ) {
            //compare elements from j =1  to arr.len - i
            for (int j = 1; j < arr.length - i ; j++ ) {
                //if the element is smaller than the previous one then swap those
                if(arr[j] < arr[j-1] ) {
                    asc_count++;
                    //swap
                    int temp = arr[j];
                    arr[j ] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    desc_count++;
                }
            }
        }
        System.out.println(desc_count);
        System.out.println(asc_count);
    }
 }
