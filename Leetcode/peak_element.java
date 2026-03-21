package Leetcode;

public class peak_element {

    public static void main(String[] args) {
        int [] arr = {0,1,0}; //
        System.out.println( peakIndex(arr));
    }



    static int peakIndex(int [] arr) {
        //logn solution
        int start =0;
        int end = arr.length-1;
        while (start <= end) {
             int mid = start + (end - start ) /2;
             if(arr[mid] > arr[mid+1]) {
                 //it means we are in the decreasing part of the array
                 //this may be the answer but look left
                 end = mid;
             }
             else {
                 start = mid +1;
                 //we are in the increasing part of the array and our answer is in the part which is mid+1 till the end
             }
        }
        return start;
    }
    static int peakIndexInMountainArray(int[] arr) {

        //O(n) solution
        int start =0;
        int end = arr.length -1;
        while ( start  <= end ) {
            if( start == end) {
                return  start;
            }
            if( arr[start ] < arr [start +1]  ) {
                start ++;
            }
            if(arr[end - 1] > arr[end]) {
                end --;
            }
        }
        return -1;
    }
}

/*
//works for all test cases
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
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

}
 */
