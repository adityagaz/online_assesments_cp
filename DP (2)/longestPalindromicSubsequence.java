package DP;
import java.util.*;
public class longestPalindromicSubsequence {

    public static void main (String [] args) {
        String s = "cbbd";
        HashMap<String , Integer > mp = new HashMap<>();
        //i tried using pick no pick but it is exponential and not suitable
        //so i watched yt and got this solution
        //1. take two pointers i and j on indices 0 and len -1
        //2. if both are equal then add 2 and explore the further part
        //3. if both are unequal then we have two possibilities either skip i or skip j  (focus we need to find subsequences that is we can skip or delete characters)
        //4. and then we call the recursion and take the maximum of them

        int [][] dp = new int[s.length()][s.length()];
        for( int [] i : dp) {
            Arrays.fill(i, -1);
        }

        System.out.println(LPS(s ,0 , s.length()-1 , dp));
        System.out.println(LPSBU(s));

    }

    static int LPS(String s , int start , int end , int [][] dp )  {
        if(start >  end) return 0;
        if(start == end) return 1;
        if(dp[start][end] != -1) return dp[start][end];
        int ans = 0;

        if(s.charAt(start) == s.charAt(end)) {
            //then we have two characters already
            ans = 2 + LPS(s, start +1 , end -1 , dp);
        }
        else {
            //we have two options
            ans = Math.max(LPS(s , start +1 , end , dp) , LPS(s , start , end -1 , dp));
        }
        dp[start][end] = ans;
        return dp[start][end];
    }
    //bottom up solution.

    static int LPSBU(String s) {

        int len = s.length();
        int [][] dp = new int[len][len];
        for( int i  = 0 ; i < len ; i++ ) {
            dp[i][i] = 1;
        }

        for( int l = 1 ; l <= len ; l++) {
            for( int i = 0 ; i < len - l +1 ;i++ ) {
                int j = i + l -1 ;
                if(s.charAt(i) == s.charAt(j)) {
                     //check for edge cases
                    dp[i][j] = 2 + (l == 1 ? 0 : dp[i+1][j-1]);

                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
