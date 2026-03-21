package sliding_window;
import java.util.*;
public class no_of_subString_allCharacters {
    public static void main(String[] args) {
        String s = "aaacb";

        System.out.println(subString(s , 3));
    }


    static int subString(String s , int k) {
        int i = 0;
        int j = 0;
        int res = 0;

        HashMap<Character , Integer> og = new HashMap<>();
        while(j < s.length()) {
            if(og.size() < 3) {
                Character ch =s.charAt(j);
                og.put(ch , og.getOrDefault(ch , 0) +1 );
            }
            while(og.size() == 3) {
                res += s.length() - j;
                //move i forward
                if(og.get(s.charAt(i)) == 1) {
                    og.remove(s.charAt(i));
                }
                else {
                    og.put(s.charAt(i) , og.get(s.charAt(i)) - 1);
                }
                i++;
            }
            j++;
        }

        return res;
    }
}
