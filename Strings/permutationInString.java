package Strings;
import java.util.*;
public class permutationInString {
     public static void main (String [] args) {
         String s2  =  "asdfasefrvrwrkasdfassdgfg";
         String s1  =  "rvwrk";
        System.out.println(checkInclusion(s1, s2));
     }

    static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character , Integer> s1map = new HashMap<>();
        HashMap<Character , Integer> s2map = new HashMap<>();

        for( int i = 0 ; i < s1.length() ; i++) {
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i =  0 ; i < s1.length() ; i++ ) {
            s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if(s1map.equals(s2map)) {
            return true;
        }

        for( int i = s1.length() ; i < s2.length() ; i++ ) {
            char key = s2.charAt(i - s1.length());
            s2map.put(key,s2map.get(key) -1);

            if (s2map.get(key) == 0) {
                s2map.remove(key);
            }
            s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i) ,0) +1);
            if(s1map.equals(s2map)) {
                return true;
            }
        }

        return false;
    }
}
