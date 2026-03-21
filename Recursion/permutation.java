package Recursion;
import java.util.*;
public class permutation {
    public static void main (String [] args) {
        String  original = "abc";
        StringBuilder str = new StringBuilder();
        System.out.println(generatePermutations(str , original));

    }
    static List<String> generatePermutations (StringBuilder s ,String original) {
        if(original.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(s.toString());
            return temp;
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i <= s.length(); i++ ){
            List<String>  temp = generatePermutations(s.insert(i, original.charAt(0)) , original.substring(1) );
            s.deleteCharAt(i);
            ans.addAll(temp);
        }

        return ans;
    }
}
