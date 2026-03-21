package Leetcode;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;

public class remove_element {
    public static void main(String[] args) {
        int [] nums = {3,2,2,3};
        int val = 3;
        int count =0;
        int [] arr = new int[nums.length];
        Arrays.fill(arr, Integer.MIN_VALUE);
        int index =0;
        for (int i = 0 ; i < nums.length  ; i ++) {
            if (nums[i] != val) {
                arr[index] = nums[i];
                index++;
            }
        }
        for (int j : arr) {
            if (j != Integer.MIN_VALUE) {
                count++;
            }
        }
        nums =arr;
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}
