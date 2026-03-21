package Leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/description/
public class k_of_each_character_from_left_and_right {

    public static void main(String[] args) {
        String s =  "acbcc";
        int k = 1;
        System.out.println(min_operations(s, k));
    }


    static int min_operations(String s , int k  ) {

        if(k == 0 ) {
            return 0;
        }
        if((k *3) > s.length()) return -1;

        HashMap<Character , Integer> map = new HashMap<>();
        for( int i  = 0 ; i  < s.length() ; i++ ) {
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) +1);
        }
        if (map.getOrDefault('a' , 0) < k || map.getOrDefault('b' ,0 ) < k || map.getOrDefault('c' , 0) < k) return -1;
        //now update those values
        for(Character key : map.keySet()) {
            map.put(key , map.get(key) - k);
        }
        int start = 0 ; int end = 0 ;int max =0;
        StringBuilder str = new StringBuilder();
        Character ch =  s.charAt(0);
        str.append(ch);
        if(isUnderLimits(map , str)) {

            if(str.length() > max) {
                max = str.length();
            }
            start++;
            str.append(s.charAt(start));
        }
        else{
            end++;
            str.replace(0,1,"");
        }

        while  (start  < s.length()) {

            if(isUnderLimits(map, str)) {

            }
            else {
                end++;
                str.replace(0,1,"");
            }
        }
        return s.length() -max;
    }

    static boolean isUnderLimits(HashMap<Character , Integer> map , StringBuilder s ) {
        if(s.isEmpty()) return true;
        int c_a = 0 ; int c_b =0 ; int c_c = 0;
        for(int i =0 ; i < s.length() ; i++ ) {
            if(s.charAt(i) == 'a') {
                c_a++;
            }
            else if(s.charAt(i) == 'b') {
                c_b++;
            }
            else {
                c_c++;
            }
        }
        if(c_a <= map.get('a') &&  c_b <= map.get('b' ) && c_c <= map.get('c'))  {
            return true;
        }
        else {
            return false;
        }
    }
}
