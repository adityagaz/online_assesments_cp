package DP;
import java.util.*;

public class longestCommonSubsequence {
    public static void main(String[] args) {
        String a = "delete";
        String b = "leet";

        int [][] dp = new int [a.length()][b.length()];
        for( int [] i  : dp) {
            Arrays.fill(i ,-1);
        }




        System.out.println(LCS(a, b, a.length()-1 , b.length() -1 ,dp) );
    }
    //i and j are pointers to the strings a and b respectively
    static int LCS(String a , String b , int i ,int j , int [][] dp) {
        if(i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != -1) return  dp[i][j];
        int ans = 0;
        if(a.charAt(i) == b.charAt(j)) {

            ans =  1+ LCS(a, b, i-1, j-1 , dp);
        }
        else {
            //if not same
            ans = Math.max(LCS(a,b,i-1,j ,dp) , LCS(a ,b , i ,j-1 , dp));
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
}
