package Strings;
import java.util.*;
public class uncommonWords {

    public static void main (String [] args) {

        String s1 = "apple apple";
        String s2 = "banana";

        System.out.println(Arrays.toString(uncommonFromSentences(s1,  s2)));


    }
    public static String[] uncommonFromSentences(String s1, String s2) {
        String [] str = s1.split(" ");
        String [] str2 = s2.split(" ");
        HashMap<String , Integer> s1_h = new HashMap <>();
        HashMap<String , Integer> s2_h = new HashMap <>();

        for( String i :str)
        {
            s1_h.put( i , s1_h.getOrDefault(i , 0 ) +1);
        }
        for( String j :str2)
        {
            s2_h.put(j  , s2_h.getOrDefault(j , 0 ) +1);
        }
        List<String> ans = new ArrayList<>();
        for( String i : str) {
            if(s1_h.get(i) ==  1 && !s2_h.containsKey(i)) {
                ans.add(i);
            }
        }
        for( String i : str2) {
            if(s2_h.get(i) ==  1 && !s1_h.containsKey(i)) {
                ans.add(i);
            }
        }
        String [] res =  ans.toArray(new String[0]);
         return res;
    }
}
