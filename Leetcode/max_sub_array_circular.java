package Leetcode;

public class max_sub_array_circular {

    public static void main( String [] args) {

        int [] arr=  {5,-3,5};

        System.out.println(max_sub_circular(arr));
    }

    static int max_sub_circular(int [] arr ) {
        int global_max = arr[0] ;
        int curr_max = 0 ;
        int sum =0;

        int global_min = 0;
        int curr_min =0 ;
        for ( int i  = 0 ; i < arr.length ; i++ ) {
            curr_max = Math.max(arr[i] , curr_max + arr[i]);
            curr_min = Math.min(arr[i] , curr_min + arr[i]);
            sum+=arr[i];
            if( curr_max > global_max) {
                global_max = curr_max;
            }
            if(curr_min < global_min) {
                global_min = curr_min;
            }
        }
        if(global_max < 0) {
            return global_max;
        }
        else {
            return Math.max(global_max , sum - global_min);
        }
    }
}
