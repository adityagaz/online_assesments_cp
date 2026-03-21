package Arrays;
import java.util.*;
public class binaysearch_in_2D_array {
    public static void main( String [] args ) {
        int [][] two_dimensional_array = {
                {10,20,30,40},
                {15,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        int target = 50;
        /*
        logic -->
        we have to apply binary search in this 2D array
        so now we can think of two things
        lower limit = 0 and upper limit is arr[0].length -1 ;
        see now if suppose the target is 37 and we start comparing with last
        1. if target < last then notice 37 is smaller than the whole column where j = last
        --> so we will do column --; that will reduce the search and will not search in that column
        2. now we will compare 37 with next element in the reverse order that is 30 so it is greater
        than 30 then observe the target element is greater than the entire row of 30
        --> so we will do a row increment to reduce the search space even further.
        3. eventually if we find the target element we will return.

        4. condition for the termination of the while loop could be like when the last crosses the start.
         */
        System.out.println(Arrays.toString(find_target_in_2d_array(two_dimensional_array, target)));
    }
    static int [] find_target_in_2d_array(int [][] arr , int target) {
        int start = 0;
        int end = arr[0].length -1;
        while (start  <= end) {
            int element = arr[start][end];
            if( target == element ) {
                return new int [] {start , end };
            }
            else if(target  < element) {
                end--;
            }
            else {
                start++;
            }
        }
        return new int [] {-1,-1};
    }

}
