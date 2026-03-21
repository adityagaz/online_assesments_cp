package Leetcode;
import java.util.Arrays;

public class first_and_last_position {
/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
    public static void main(String[] args) {

        int arr [] = {1,2,2};
        System.out.println(Arrays.toString(searchRange(arr , 2)));

    }

    static int [] searchRange(int [] arr , int target) {

        int left = first_and_last(arr,target ,true);
        int right= first_and_last(arr,target , false);
        return new int[]{left, right};
    }
    static int  first_and_last(int [] arr , int target , boolean bias )  {
            int start = 0 ;
            int end = arr.length-1;
            int index =-1;
            while ( start <= end ) {
                int mid = start + (end  - start ) /2;

                if(target  > arr[mid] ) {
                    start = mid +1;
                } else if ( target < arr[mid]) {
                    end = mid -1;
                }
                else {
                    index = mid;
                    if(bias) {
                        end = mid -1;
                    }
                    else{
                        start = mid+1;
                    }
                }
            }
            return index;
    }
}

/*
one more similar approach

class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] array = new int[2];
        array[0] = -1;
        array[1] = -1;

        if (arr.length == 0) {
            return array;
        }

        array[0] = findFirstPosition(arr, target);
        array[1] = findLastPosition(arr, target);

        return array;
    }

    private int findFirstPosition(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                result = mid;
                end = mid - 1; // continue searching to the left
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private int findLastPosition(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                result = mid;
                start = mid + 1; // continue searching to the right
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
 */
