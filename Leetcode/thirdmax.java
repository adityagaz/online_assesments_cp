package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class thirdmax {
    /*
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
     */
    public static void main(String[] args) {
        int [] arr = {2,2,1,3};

        System.out.println(third_max(arr));
    }
    static  int third_max(int [] arr2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int  i = 0;  i < arr2.length;  i++) {
            if(map.containsKey(arr2[i])) {
                map.put(arr2[i],map.get(arr2[i])+1 );
            }
            else {
                map.put(arr2[i] , 1);
            }
        }
        int arr [] =new int[map.size()];
        int index1 =0;
        for(Map.Entry entry : map.entrySet()){
            int key = (Integer)entry.getKey();
            arr[index1] = key;
            index1++;
        }
        if(arr.length < 2 ) {
            return arr[0];
        } else if (arr.length<3) {
            return Math.max(arr[0] ,arr[1]);
        }
        Arrays.sort(arr);
        return arr[arr.length-3];

        //without sorting logic by me!! but no need
//        int max1 = 0;
//        int count = 0;
//        while (count <=2) {
//            int max = arr[0];
//            int index = 0;
//            for (int j = 0; j < arr.length; j++) {
//                if (arr[j] > max) {
//                    max = arr[j];
//                    index = j;
//                }
//                if (count == 2) {
//                    third_max = max;
//                }
//            }
//            arr[index] = Integer.MIN_VALUE;
//            count++;
//        }
    }
}
