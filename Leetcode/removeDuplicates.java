package Leetcode;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class removeDuplicates {
    /*
    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public static void main(String[] args) {
        int [] arr = {0,0,5,5,1,2,2,3,3,4};
        int [] arr2 = {-3,-1,0,0,0,3,3};
        int[]  result = remove_duplicates(arr);
        System.out.println(Arrays.toString(result));
    }
    static int[] remove_duplicates(int [] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }
            else{
                map.put(arr[i] , 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=0;
        }
        int index = 0;
        int size_unique = map.size();
        int [] temparr = new int[size_unique];

       for(Map.Entry entry : map.entrySet()){
           int key = (Integer)entry.getKey();
            temparr[index] = key;
            index++;
       }
       Arrays.sort(temparr);
        for (int i = 0; i < size_unique; i++) {
            arr[i]=temparr[i];
        }

       return arr;

    }
}
