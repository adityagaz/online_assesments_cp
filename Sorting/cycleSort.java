package Sorting;
import java.util.*;
public class cycleSort {

    public static void main (String [] args) {
        int [] arr = {2,7,4,5,6,1,3,8};
        int [] arr2 = {3,4,-1,1};
        cycleSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    static void cycleSort(int [] arr) {
        //this method basically works if the elements in the array range from
        // 1 to N both inclusive.
         // logic --> iterate through the whole array and shift the elements to the index = value -1;
        int i = 0 ;
        while ( i < arr.length ) {
            int correct = arr[i] -1;
            if(arr[i] < 0 ){
                i++;
            }
            else if( arr[i] != arr[correct] ) {
                 int temp = arr[i];
                 arr[i] = arr[correct];
                 arr[correct] = temp;
            }
            else {
                i++;
            }
        }



    }

}
