package Leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class uniqueOccurences {
    /*
    Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:
Input: arr = [1,2]
Output: false
Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
     */
    public static void main(String[] args) {
        int [] input_arr = {-3,0,1,-3,1,1,1,-3,10,0}; //failing test case for negative numbers
        System.out.println(uniqueOccur(input_arr));
    }

    static boolean uniqueOccur(int [] given_arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < given_arr.length; i++) {
            if(map.containsKey(given_arr[i])){
                map.put(given_arr[i] , map.get(given_arr[i])+1);
            }
            else {
                map.put(given_arr[i] , 1);
            }
        }
        Collection<Integer> values= map.values();

        return isAllElementsDistinct(values);
    }

    static boolean isAllElementsDistinct(Collection<Integer> arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr ) {
            if(!set.add(i)){
                return false;
            }
        }
        return true;
    }




//    static boolean uniqueOccur(int [] input_arr) {
//        int [] occurences = new int[10];
//        for (int i = 0; i < input_arr.length; i++) {
//            occurences[input_arr[i]]++;
//        }
//        for (int i = 0; i < occurences.length; i++) {
//            if(occurences[i] !=0 ) {
//                for (int j = i+1; j < occurences.length; j++) {
//                    if(occurences[j] != 0 ){
//                        if (occurences[j] == occurences[i]){
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
}

//this approach is only valid to inculcate positive numbers but in case of a negative number we can't store it in an array index
// because array index starts from 0 till positive integer values.

//here we need to use hash maps