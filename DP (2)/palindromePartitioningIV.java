package DP;
import java.util.*;
public class palindromePartitioningIV {
    public static void main (String [] args) {
        String s = "bbab";
        int len = s.length();
        boolean [][] p_table = new boolean[s.length()][s.length()];
        //denotes that is str[i...j] is a palindrome.
        for( int i = 0 ;  i < len ; i++ ) {
            p_table[i][i] = true; //palindromes of length 1 is always true
        }

        for( int length =2  ; length <= s.length() ; length++) {
            for(int i = 0  ;i <= len - length ; i++ ) { //i --> start pointer
                int j = i + length -1; //end pointer
                if(s.charAt(i) == s.charAt(j)) {
                    if (length == 2) {
                        p_table[i][j] = true;
                    }
                    else {
                        p_table[i][j] = p_table[i+1][j-1];//look for inside string since the start and end  are same
                    }
                }
            }
         }

        System.out.println(is2CutPalindrome(s , 0 , p_table));
    }

    static  boolean is2CutPalindrome(String s , int idx  , boolean[][] dp) {

        for( int k  = idx ; k <= s.length() -3 ; k++) {
            if(dp[0][k]) {
                //it means before the first cut it is a palindrome
                //then we go for the second cut
                for(int l = k+1 ; l <= s.length() -2; l++) {
                    if(dp[k+1][l]) {
                        //it means the second is also a palindrome {
                        if(dp[l+1][s.length()-1]) {
                            return true;//all three are palindromes
                        }
                    }
                }
            }
        }
        return false;


    }
}
