package Leetcode;

public class rotated_sorted_two {
    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,1,1};
        System.out.println(isPresent(arr , 2));
    }

    static boolean isPresent(int[] arr, int target) {
        if(arr.length == 1 && target == arr[0] ) return true;
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) return true;

                if(arr[mid] > arr[end]) {
                    //left part
                    if(target >= arr[start] && target < arr[mid]) {
                        //we are in the left part and target is also in the left part
                        end = mid -1;
                    }
                    else {
                        //jump to the right part of the array
                        start = mid+1;
                    }
                }
                else if(arr[mid] < arr[end]) {
                    //right part
                    if(target > arr[mid] && target <= arr[end]) {
                        start = mid+1;
                    }
                    else {
                        //jump to the left part
                        end = mid -1;
                    }
                }
                else {
                    end--;
                }

            }
            return false;
    }

}
