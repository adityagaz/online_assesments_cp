package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majority_element_medium {
    /*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.



Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]

     */

    public static void main(String[] args) {
        int [] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }

    static List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<Integer>();
        int length = nums.length/3;

        HashMap< Integer ,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i] , map.get(nums[i])+1);
            }
            else{
                map.put(nums[i] , 1);
            }
        }

        for(Map.Entry entry :map.entrySet() ){
            int value = (Integer)entry.getValue();
            if(value  > length){
                int key  = (Integer)entry.getKey();
                list.add(key);
            }
        }
        return list;
    }
    }


