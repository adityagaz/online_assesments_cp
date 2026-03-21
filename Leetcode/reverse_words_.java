package Leetcode;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class reverse_words_ {

    public static void main(String[] args ) {
        String s = "the sky is blue";
        System.out.println(reverse_words(s));
    }
    static String reverse_words(String s ) {
        s = s.strip();
        String [] arr = s.split(" ");
        List<String> filtered =  new ArrayList<>();
        for(String word : arr) {
            if(!word.isEmpty()) {
                filtered.add(word);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = filtered.size()-1; i >=0 ; i--) {
            result.append(filtered.get(i)).append(" ");
        }
        return result.toString().strip();
    }
}
