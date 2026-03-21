package sliding_window;
import javax.swing.*;
import java.util.*;
public class find_Anagrams {

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s , p ));
    }

    static  List<Integer> findAnagrams(String s , String p ) {
        HashMap<Character , Integer> og = new HashMap<>();
        for(int i = 0 ; i <  p.length() ;i++ ){
            og.put(p.charAt(i) , og.getOrDefault(p.charAt(i) , 0) +1);
        }
        //original count updated
        List<Integer> res = new ArrayList<>();
        int i= 0;
        int j = 0;
        int k = p.length();
        HashMap<Character , Integer> window_count = new HashMap<>();
        while( j < s.length()) {
            window_count.put(s.charAt(j) , window_count.getOrDefault(s.charAt(j) ,0) +1 );
            if(j -i +1  ==  k){
                //match the maps if there is a match then add the i index in the result array
               if(!window_count.isEmpty()) {
                   if(og.equals(window_count)) {
                       res.add(i);
                   }
                   if(window_count.get(s.charAt(i)) != 1){

                       window_count.put(s.charAt(i) , window_count.get(s.charAt(i)) -1);
                   }
                   else {
                       window_count.remove(s.charAt(i));
                   }
                   i++;
               }
            }
            j++;
        }
        return res;
    }

}
