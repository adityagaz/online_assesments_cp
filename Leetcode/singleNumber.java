package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    public static void main(String[] args) {
        int [] arr = {4,1,2,1,2}; //4
        int [] arr2 = {2,2,1}; //1

        int result  = single_occurrence(arr2);
        System.out.println(result);
    }

    static  int single_occurrence(int [] arr){
        int occurence = -1;
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++ ){
            if(map.containsKey(arr[i])){
                map.put(arr[i] , map.get(arr[i])+1);
            }
            else {
                map.put(arr[i] , 1);
            }
        }

        for (Map.Entry entry : map.entrySet()){
            int value = (Integer)entry.getValue();
            int key = (Integer)entry.getKey();
            if(value == 1) {
                occurence =key;
                return occurence;
            }
        }
        return occurence;
    }
}
