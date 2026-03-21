package LeetcodeEasy;

public class check_if_array_sorted {
    public static void main(String[] args) {
        int [] arr = {2,1,3,4};
        System.out.println(check_rotated_sorted(arr));
    }
    static boolean check_sorted_rotated(int [] arr) {
        //this method handles the duplicates as well
        //logic --> for each element in the loop check for the next element if it is smaller

        /*so in case of sorted [1,2,3,4] rotate(1) --> [4,1,2,3] --> [3,4,1,2] --> [2,3,4,1] --> [1,2,3,4]
        in this rotation we can observe that i > i+1 only once in any rotated array
         so we will have the count for that condition and it count remains <= 1 till the whole iteration then we
         will return true
        the moment count becomes > 1 we immediately return false;
        */
        int count = 0;
        for (int i  = 0 ; i <arr.length ; i++ ){
            if( arr[i ] > arr[(i+1) % arr.length]) {
                count++;
            }
            if( count >1 ) {
                return false;
            }
        }

        return true;
        }

    static boolean check_rotated_sorted( int [] arr) {
        //but this approach won't work for duplicate elements
        //it will not run on leetcode
        //basic approach is find min and max
        // check if min index not equal zero and max index = min -1 or not
        //if min is zero then last index is max or not
        /*
        logic --> consider arr = [ 1,2,3,4]
        rotate by 1 place it becomes  [ 4,1,2,3]
        by two places [3,4,1,2]
        by three places [2,3,4,1]
        by four places we get the same array back [1,2,3,4]
        so you can observe that the max element is always one index behind the min element in case of
        any rotation
        and if the array is rotated by k where k is multiple of length of the array then
        the min is zero and the max is at last index.

        also to reduce the complexity we can use binary search to reduce it to O(logn)
         */

        //simple O(n) approach

        //find the max_index
        int max_index = -1;
        int max = Integer.MIN_VALUE;
        int min_index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i  < arr.length ; i++ ){
            if(arr[i] > max ) {
                max = arr[i];
                max_index = i ;
            }
        }
        for(int i = 0 ; i  < arr.length ; i++ ){
            if(arr[i] < min  ) {
                min = arr[i];
                min_index = i ;
            }
        }
        if(min_index == 0 && max_index == arr.length-1) {
            return true;
        }else if (min_index - max_index == 1) {
            return true;
        }
        else {
            return false;
        }
    }


    //approach 2 is finding max and min index using binary search only in rotated sorted arrays
//the boolean when true it says find max element otherwise find min element
    static int min_max_element_binary_search(int []  arr , boolean findMax ) {
        //remember this method of finding the max element only works for rotated arrays
        //not for all arrays
        int start = 0 ;
        int end = arr.length-1;
        while (start < end) {
            int mid  = start + (end - start ) /2;

            if(!findMax) {
                if( arr[mid ] > arr[end]) {
                    start = mid +1;
                }
                else {
                    end = mid;
                }
            }

            // 3 4 5 6 7 0 1 2
            else {
                if(arr [mid ] > arr[end]){
                    start = mid;
                }
                else {
                    end = mid -1;
                }
            }
        }
        return start;
    }
}
