package basic;
import java.util.*;
public class ASCII_BACK_AND_FORTH {
    public static void main(String[] args) {
        List<Character> l = new ArrayList<>();
        for( int i = 0 ; i <  26 ; i++) {
            char b = (char) ('a' + i);
            l.add(b);

        }
        String s = "ad";
        StringBuilder str = new StringBuilder(s);
        System.out.println(str);

    }
}
