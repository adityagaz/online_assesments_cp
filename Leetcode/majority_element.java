package Leetcode;

import java.beans.Introspector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
public class majority_element {
    /*
    169. Majority Element
Easy
Topics
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
     */
    public static void main(String[] args) {
        int nums [] = {2,2,1,1,1,2,2};
        int length = nums.length/2;
        int count;
//        int [] arr = new int[10];
        //the array implementation can't store frequency of numbers which are greater than the length
        //of the array . Therefore we will use a hashmap instead to store the number and their frequencies


//        for (int i = 0; i < nums.length; i++) {
//            arr[nums[i]]++;
//        }

        HashMap< Integer ,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i] , map.get(nums[i])+1);
            }
            else{
                map.put(nums[i] , 1);
            }
        }
        int max_value = Integer.MIN_VALUE;
        int max_key = Integer.MIN_VALUE;
        for (Map.Entry entry :map.entrySet()) {
            //many a times you won't need to type cast the (Integer) but here we are facing error se did it.
            int value  = (Integer)entry.getValue();
            if(value > max_value) {
                max_key = (Integer) entry.getKey();
                max_value = value;
            }
        }
        System.out.println(max_value);
        System.out.println(max_key);
    }
}
