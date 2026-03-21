package Leetcode;
import java.util.*;

public class kth_smallest_element_in_sorted_matrix {

    public static void main ( String [ ]args) {


         int [][] arr = {
                 {1,   5,   9},
                 {10, 11, 13},
                 {12, 13, 15}
         };

         int kth_smallest_target = 6;
        k_th_smallest_in_2d_array(arr,kth_smallest_target );
        System.out.println(largest_kth_element(arr,kth_smallest_target));

    }

    static int k_th_smallest_in_2d_array (int [][] arr , int target) {
        List <Integer > list = new ArrayList<>();
        int element_count = 0 ;
        for( int i = 0 ; i < arr.length  ; i++ ){
            for ( int j =0 ; j <arr.length  ; j++ ){
                list.add(arr[i][j]);
            }
        }
///this solution will have  a memory complexity equal to n^2
        //so leetcode won't accept that

        //logic --> if the k the smallest element is asked then it is the (arr.len - k )th largest too!
        // so we could find the that largest using binary search

        Collections.sort(list);
        System.out.println(list);
        return -1;
    }

    static int largest_kth_element ( int [][]arr  , int k )
    {
        int stopping_count = (arr.length * arr[0].length) - k + 1;
        int count =0;
        int end = arr[0].length -1;
        int start = arr.length - 1;
        while ( end >= 0  && start <= arr.length -1 ) {
            int element = arr[start][end];
            if(element  < arr[start -1][arr[0].length -1]) {
                start --;
            }
            else {
                count++;
                if(count == stopping_count) {
                    return element;
                }
            }
            if(end == 0 ) {
                end = arr.length - 1;
            }else {
                end--;
            }
        }
return -1;
    }



}
