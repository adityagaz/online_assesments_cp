package LeetcodeHard;

public class split_aray_largest_sum {

    public static void main(String[] args) {
        int [] arr = {7,2,5,10,8};
        System.out.println(largest_sum(arr, 2));
        /*check for brute force method or check every subarray and take the maximum of every sub array and store it in
      an array now return the minimum of the array
      for n size array for k=2 combinations would be [1] , [2 ...n]  , [1 ,2 ] [3 ... n] , ....more such combinations so it
      won't get accepted on leetcode as it would take O(n^2 * k ) sums and also a hell lot of space O(n)
        */
//optimized logic
    //logic -->
    /*
    1. think of what can be the minimum answer that would be the max of the array of k =1
    2. and the max value of the answer could be when the array of size n is divided into size of n elements.
    3. so we have to find the answer between this min and the max value ... so idea... binary search
    4. now we need to check if we have the threshold as mid value and if no of arrays that we could divide into
    exceeds the allowed limit. if no of arrays are more then the threshold is very low
    and vice versa so accordingly we will change the end and the start.

    i recommend to to apply debugging points and go through the search at each point and dry run in your mind;
         */
    }
    static int largest_sum(int [] arr , int k ) {
        int min = arr[0]; // this is the maximum element in the array
        int upper_limit = 0 ; //this is the sum of all elements
        for(int i : arr ){
            upper_limit += i;
            if (i > min) min = i;
        }
        int mid =-1;
        while ( min < upper_limit ) {
             mid = min + (upper_limit - min)/2;
            int subarray_count = no_of_sub_arrays(arr , mid);
            if(  subarray_count < k   ) {
                upper_limit = mid;
            }
            else if(subarray_count > k) {
                min = mid +1;
            }
            else {
                upper_limit = mid;
            }
        }
        return min;
    }
    static int no_of_sub_arrays (int [] arr  , int threshold) {


        //logic --> to check the number of subarrays we have to apply greedy algorithm
        int no_of_subarray = 0 ;
        int sum =arr[0];
        for (int i=1 ; i<= arr.length-1; i++ ){
            if(sum + arr[i]<= threshold) {
                sum+=arr[i];
            }
            else {
                i--;
                no_of_subarray ++ ;
                sum =0;
            }
        }
        return no_of_subarray+1;
    }
}
