package Leetcode;
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class single_element_sorted_array {
    public static void main(String[] args) {
        int [] arr = {1,1,2,2,3};
        System.out.println(single_elem_sorted_sorted(arr));
    }
    static int single_elem_sorted_sorted(int [] arr ) {
        if (arr.length ==1 ) return arr[0];
        boolean bias = false;
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end  = arr.length -1;
        while ( start <end) {
            int mid = start + (end - start  )/2;
            if(arr[mid-1] !=arr[mid] && arr[mid] != arr[mid + 1]) return arr[mid];
            if(mid % 2== 0) {
                bias = true;
            }
            else {
                bias= false;
            }
            if(bias) {
                if( arr[mid]  == arr[mid -1 ]) {
                    //go in left direction
                    end = mid - 2;
                }
                else {
                    //go in right direction
                    start = mid +2;
                }
            }
            else {
                if( arr[mid]  == arr[mid -1 ]) {
                    //go in left direction

                    start = mid +1;
                }
                else {
                    //go in right direction
                    end = mid - 1;
                }
            }
            if(end - start <= 2) {
                result = exact_once(arr, start , end);
                return result;
            }
        }
        return -1;
    }
    static int exact_once(int [] arr , int start , int end) {
        if(start == end ) {
            return arr[start];
        }
        if(arr[start] == arr[start +1]  ) {
            return arr[end];
        }
        else {
            return arr[start];
        }
    }
}
