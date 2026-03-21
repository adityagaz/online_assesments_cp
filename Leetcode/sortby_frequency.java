package Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.*;
public class sortby_frequency {
    public static void main(String[] args) {
        String s = "loveleetcode";
        sort_by_f(s);
//      works man good effort !!!!
    }
    static String sort_by_f(String str) {
        HashMap<Character , Integer > map  = new HashMap<>();
        for( int i =0 ; i < str.length() ; i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i) , 1);
            }
            else {
                map.put(str.charAt(i) , map.get(str.charAt(i))+1);
            }
        }

        //data stored in hashmap
        List<List<Character>> list = new ArrayList<>();

        //initialize the list with empty lists
        for(int i = 0 ; i <= str.length() ; i++ ){
            list.add(new ArrayList<>());
        }
        //iterate over the keyset
        
        for(Character i : map.keySet()) {
            int correct_index = map.get(i);
            list.get(correct_index).add(i);
        }
        System.out.println(list
        );
        StringBuilder result = new StringBuilder();
        //list populated
        for(int i = list.size()-1; i >=1 ; i--) {
            int size = list.get(i).size();
            if(size!=0){
                for(int j =0 ; j < size ; j++  ){
                    for(int l = 0 ; l  < i ; l++){
                        result.append(list.get(i).get(j));
                    }
                }
            }
        }
        //STRING BUILD
        System.out.println(result);
return result.toString();
    }
}
