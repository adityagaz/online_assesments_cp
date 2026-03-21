package LeetcodeHard;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.awt.image.ImageProducer;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class minimum_window_substring {

    public static void main (String [] args ) {
        String temp_s = "ab";
        String check= "A";
        System.out.println(min_window(temp_s, check));

    }

    static String min_window(String s ,String t) {
        if(s.length() < t.length()) return "";

        if(s.length() ==1 ) {
            if(s.equals(t)) {
                return t;
            }
            else {
                return "";
            }
        }
        int j =0; int  i =0 ;
        int start_i = 0 ;
        int req_count = t.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int k = 0 ; k < t.length() ; k++) {
            if(map.containsKey(t.charAt(k))) {
                map.put(t.charAt(k) , map.get(t.charAt(k)) +1 );
            }
            else  {
                map.put(t.charAt(k) ,1) ;
            }
        }

        int min_diff =Integer.MAX_VALUE;
        while (j < s.length()) {
            if(map.containsKey(s.charAt(j)) ) {

                map.put(s.charAt(j) , map.get(s.charAt(j)) -1);
                if(map.get(s.charAt(j)) >=0) {
                    req_count--;
                }
            }

            while (req_count == 0 ) {
                int window_size = j-i+1;
                if(window_size < min_diff ) {
                    min_diff = window_size;
                    start_i = i;
                }
                if(map.containsKey(s.charAt(i)) ) {
                    if(map.get(s.charAt(i)) ==0) {
                        req_count++;
                    }
                    map.put(s.charAt(i) , map.get(s.charAt(i)) +1) ;
                }
                i++;
            }
            j++;
        }
        if(min_diff == Integer.MAX_VALUE) return "";
        StringBuilder result = new StringBuilder();
        for(int l = start_i; l < (start_i + min_diff)  ; l++) {
            result.append(s.charAt(l));
        }


        return result.toString();
    }
}
