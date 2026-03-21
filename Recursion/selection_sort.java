package Recursion;

import java.util.Arrays;

public class selection_sort {

    public static void main(String[] args) {


        int [] arr = { 4,3,2,1};
        selectionSortUsingRecursion(arr, arr.length -1  , 0);
        System.out.println(Arrays.toString(arr));

    }

    static void selectionSortUsingRecursion(int [] arr , int r ,int c) {
        if(r == 0 ) {
            return;
        }
        if( c<r ) {
            if(arr[c]  > arr[r]) {
                //swap
                int temp = arr[c];
                arr[c] = arr[r];
                arr[r] = temp;
            }
            //if not found check the next element
            selectionSortUsingRecursion(arr, r, c+1);
        }
        //reset the row
        selectionSortUsingRecursion(arr, r-1 , 0);
    }

}
