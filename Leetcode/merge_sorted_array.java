package Leetcode;

import java.util.Arrays;

public class merge_sorted_array {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,0,0,0};
        int [] arr2 = {2,5,6};
        merge_arrays(arr1 ,3, arr2 , 3);
    }
    static void merge_arrays(int [] nums1 , int m , int [] nums2  , int n) {
        if(nums1.length == 0 ) {
            System.out.println(nums2);
        }
        if(nums2.length == 0) {
            System.out.println(nums1);
        }
        for (int i = m, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
//        System.out.println(Arrays.toString(nums1));
    }
}
