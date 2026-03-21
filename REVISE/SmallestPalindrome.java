package REVISE;
import java.util.*;
public class SmallestPalindrome {

    public static void main(String [] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }
    static String shortestPalindrome(String s) {
        StringBuilder temp = new StringBuilder(s);
        String rev= temp.reverse().toString();
        if( rev.equals(s))
        {
            return rev;
        }

        else
        {
            int n = s.length();
            int i = 1;
            for(; i < n ; i++ ) {
                if(s.substring(0 ,n-i).equals(rev.substring(i)) ) {
                    break;
                }
            }
            return rev.substring(0 ,i ) + s;
        }
    }
}
