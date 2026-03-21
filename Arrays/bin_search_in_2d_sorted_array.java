package Arrays;
import java.util.*;
public class bin_search_in_2d_sorted_array {

    public static void main (String [ ]args) {

        int[][] sorted_2d_arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        int target = 25;
//now we are supposed to apply binary search on this
//logic -->
/*
we can observe here that the logic will be slightly different then before
here we can see the last elment of each row is smaller than the first element of the next row.
1. start from comparing the last element of the first row. see if the target is smaller than the first
row then it is confirmed that it lies in the same row.
so we need to just minimize the column space
2. if the target element is greater than the last element of the first row then it is sure that
the element doesnot lie in the first row therefore we do increment a row and we do that by making start ++;
as it represents the row.
3. finally if the target is found then we simply return the target and if the loop ends
then we return -1,-1.
4. it is important to check when the loop ends because if start < arr[0].length && end >=0
this condition is to ensure that the start has the range [0 ... arr.length] and end also has the range

this algorithm won't work on arrays if an array has a no of columns greater than the first row
in that case we would have to know the max no. of columns before hand.

something like array.shape in python and idk if similar thing is there in java.
         */
        System.out.println(Arrays.toString(bin_search_in_2d_sorted(sorted_2d_arr, target)));
    }

    static int [] bin_search_in_2d_sorted (int [][] arr , int target) {
        int start=0;
        int end = arr[0].length -1;

        while (start < arr.length && end >=0) {
            int element = arr[start][end];
            if(element == target ) return new int [] {start , end} ;
            else if(target > element ) {
                start++;
            }
            else {
                end--;
            }
        }

        return new int [] {-1,-1};
    }
}
