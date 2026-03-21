package DP;
import java.util.*;

public class palindrome_partitioning {
    public static void main(String[] args) {

        String str = "a";
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        System.out.println(palindromePartitioning(str , ans, result));

    }

    static List<List<String>> palindromePartitioning(String s , List<String> ans , List<List<String>> result) {
        if(s.isEmpty()) {
            //we have all palindromes
            result.add(new ArrayList<>(ans));
            return result;
        }
        for( int i = 1 ; i <= s.length() ; i++) {
            String subString = s.substring(0 ,i);
            if(isPalindrome(subString)){
                ans.add(subString);
                palindromePartitioning(s.substring(i) , ans , result);
                ans.remove(ans.size() -1);
            }
        }return result;

    }

    static boolean isPalindrome(String s ) {
        int i = 0 ;
        int j = s.length()-1;

        while (i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;j--;
        }

        return true;
    }
}
