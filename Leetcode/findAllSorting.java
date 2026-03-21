package Leetcode;
import java.util.*;
public class findAllSorting {

    public static void main( String [] args) {
        int arr [] = {1,1,2};
        System.out.println(all_duplicates(arr));

    }

    static List<Integer> all_duplicates (int [] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < arr.length ) {
            int correct= arr[i] -1;
            //basic cyclic sort logic

            if( arr[i] != arr[correct]) {
                int temp= arr[correct];
                arr[correct] = arr[i];
                arr[i]= temp;
            }

            else {
                i++;
            }
        }

        //after this loop we will check what all elements are not at their correct index.
        // we will apply loop from backward direction to ensure that the smaller elements are added
        //first in the list.
        //those elements would be added to the list.

        for( int j = arr.length - 1 ; j>=0 ; j--) {
            if (arr[j] != j+1 ){
                list.add(arr[j]);
            }
        }
        return list;

    }
}
