package Arrays;

public class order_agnostic_binary_search {
    public static void main ( String[] args ) {
        int arr [] = { 6,4,3,2,1,-34};
        int target =  4;
        System.out.println(order_agnostic_binary_search(arr , target));
    }

    static int order_agnostic_binary_search (int [] arr , int target ) {
        //order agnostic means that this binary search would work both ascending and descending arrays.
        int start = 0;
        int end = arr.length - 1;
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
