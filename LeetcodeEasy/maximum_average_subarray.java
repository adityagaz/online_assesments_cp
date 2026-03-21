package LeetcodeEasy;

public class maximum_average_subarray {

    public static void main( String [] args) {
        int []  nums = {5};
        int  k = 1;
        //logic -->
        /*
        maintain a variable max_avg and use sliding window
        sliding window --> if you have to get the sum of three elements in an array which is smallest or largest
        so you can use start from zero to index k -1 then again the next subarray
        example [1,2,3,4,5,6]
        you have to find the maximum subarray of length 3
        so we can do brute force like
        [1,2,3,4,5,6] => [[1,2,3],4,5,6] => [1,[2,3,4],5,6] => [1,2,[3,4,5],6] =>and so on checking every subarray
        there we will have TC = O(n*k)
        to reduce the redundant calculation we use sliding window
        [1,2,3,4,5,6] => for i = 0 take 1,2,3 then for i = 1 remove previous (i)  element and add (K+i) element
        and loop till (length - k ) elements
         */

        System.out.println(max_average(nums , k ));
    }

    static double max_average(int [] arr  , int k) {
        double max_avg = 0;
        //initial sum
        for (int i = 0 ; i < k ; i++ ) {
            max_avg += arr[i];

        }
       double max =max_avg;
        max_avg /=k;
        //sliding window implemented
        for( int i  =  0; i < arr.length - k ; i++  ) {
            max -= arr[i];
            max+= arr[k+i];
            if( max / k > max_avg) {
                max_avg = max/k;
            }
        }
        return max_avg;
    }
}
