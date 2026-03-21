package LeetcodeEasy;
import java.util.*;

public class CircularSentence {

    public static void main (String [] args) {

        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircular(sentence));

    }

    static boolean isCircular(String sentence) {
        String [] string  = sentence.split(" ");
        if(string[0].charAt(0) != string[string.length-1].charAt(string[string.length-1].length()-1)){
            return false;
        }
        for( int i = 0 ; i < string.length -1 ; i++) {
            if(string[i].charAt(string[i].length() -1) != string[i+1].charAt(0)){
                return false;
            }
        }
        return true;
    }
}
