package DP;
import java.util.*;
public class Min_asciiCode_LCS_Pattern {
//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";

        int [][] dp = new int [a.length()][b.length()];
        for( int [] i  : dp) {
            Arrays.fill(i ,-1);
        }
        int max_common = LCS(a, b, a.length()-1 , b.length() -1 ,dp);
        System.out.println(asciiString(a) + asciiString(b) - 2*max_common);

    }

    static int asciiString(String s  ) {
        int ascii = 0 ;
        for ( int i = 0 ; i < s.length() ; i++ ){
            ascii+= (int) s.charAt(i);
        }
        return  ascii;
    }

    static int LCS(String a , String b , int i ,int j , int [][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != -1) return  dp[i][j];
        int ans = 0;
        if(a.charAt(i) == b.charAt(j)) {
            int ascii = (int) a.charAt(i);
            ans =  ascii + LCS(a, b, i-1, j-1 , dp);
        }
        else {
            //if not same
            ans = Math.max(LCS(a,b,i-1,j ,dp) , LCS(a ,b , i ,j-1 , dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
