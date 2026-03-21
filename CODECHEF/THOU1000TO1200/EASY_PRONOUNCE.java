package CODECHEF.THOU1000TO1200;
import java.util.*;

public class EASY_PRONOUNCE {

    public static void main(String[] args) {
        String s = "polish";
        System.out.println(isEasyToPronounce(s));

    }
    static boolean isEasyToPronounce(String s ) {
        if(s.length() < 4 ){
            return true;
        }
        Set<Character>set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        List<Character> l = new ArrayList<>();
        int vowel_count =0 ;
        for( int i  = 0 ; i <  4 ; i ++ ) {
            l.add(s.charAt(i));
            if(set.contains(s.charAt(i))) {
                vowel_count++;
            }
        }
        if(vowel_count == 0 ) {
            return false;
        }
        //window created
        for( int i = 4 ; i < s.length() ; i++ ) {
            if (set.contains(l.get(0))) vowel_count--;
            l.remove(0);
            l.add(s.charAt(i));
            if (set.contains(s.charAt(i))) vowel_count++;
            if (vowel_count <1) {
                return false;
            }
        }
        return true;
    }

}
