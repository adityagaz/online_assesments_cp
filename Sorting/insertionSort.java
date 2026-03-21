package Sorting;
import java.util.*;
public class insertionSort {

    public static void main (String [] args ) {

        int [] arr = {4,5,1,2,3};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertionSort(int [] arr ){
        for (int i  = 0 ;  i < arr.length -1 ; i++ ){
            //i will go from i = 0 till length -2
            for(int j =  i+1 ; j>0; j -- ) {
                //for every i , j will start from the next step and then compare the previous element
                //if it is smaller then it will keep swapping and once if finds that the element is greater
                //then it breaks because all the elements to the left are smaller than that .
                if(arr[j ] < arr[j-1] ) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] =temp;
                }
                else {
                    break;
                }
             }
        }
    }
}
