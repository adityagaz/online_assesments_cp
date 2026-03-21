package LeetcodeHard;

public class find_in_mountain {

    public static void main( String [] args) {
        int [] arr = {1,2,3,4,5,3,1};
        int target =3;
        // 3 appears at index 2 and index 5 therefore return 2 as the answer

        System.out.println(find_in_mountain_array(arr , target));

    }

    static int find_in_mountain_array(int [] array  , int target) {
        int peak = peakIndexInMountainArray(array);

        int first_try = order_agnostic_binary_search(array, target , 0 , peak );
        if( first_try !=-1) {
            return first_try;
        }
        return order_agnostic_binary_search(array , target , peak+1 , array.length -1);
    }
    static int peakIndexInMountainArray(int[] arr) {
        int start =0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = start + (end - start ) /2;
            if((mid == 0 || arr[mid] > arr[mid-1]) && (mid == arr.length -1 ||arr[mid] > arr[mid+1])) {
                return mid;
            }
            else if( mid > 0  && arr[mid] < arr[mid-1] ) {
                end = mid -1;
            }
            else {
                start = mid+1;
            }
        }
        return -1;
    }
    static int order_agnostic_binary_search (int [] arr , int target , int start , int end ) {
        //order agnostic means that this binary search would work both ascending and descending arrays.
        boolean isAsc = true;
        if (arr[start] > arr[end]) {
            //it means the array is descending
            isAsc = false;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
