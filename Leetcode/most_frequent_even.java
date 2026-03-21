package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class most_frequent_even {
    public static void main(String[] args) {
        int arr[] = {0,1,2,2,4,4,1}; //ans =2
        int arr1[] = {4,4,4,9,2,4}; //ans =4
        int arr2[] = {29,47,21,41,13,37,25,7}; //ans =-1


        System.out.println(mostFrequentEven(arr2));
    }

    static  int mostFrequentEven (int [] nums) {

        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 ==0 ){
                if(map.containsKey(nums[i])){
                    map.put(nums[i] , map.get(nums[i])+1);
                }
                else {
                    map.put(nums[i] , 1);
                }
            }
        }
        if (map.isEmpty()) {
            return -1;
        }
            int max = Integer.MIN_VALUE;
        //finding the maximum value
        for(Map.Entry entry : map.entrySet()) {
            int value = (Integer)entry.getValue();
            if (value >= max) {
                max = value;
            }
        }
        int min = Integer.MAX_VALUE;
        for(Map.Entry entry : map.entrySet()){
            int value = (Integer)entry.getValue();
            int key = (Integer)entry.getKey();
            if ( value ==max) {
                if(key < min) {
                    min = key;
                }
            }
        }

        return min;
    }
}



