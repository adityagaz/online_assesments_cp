package DP;
import java.util.*;
public class plaindromePartitioningii {
    public static void main(String[] args) {
        String str = "aaba";
        //minimum cut to make all substrings palindrome
        int [][] dp = new int[str.length()][str.length()];
        for( int [] i : dp  ) {
            Arrays.fill(i ,-1);
        }
        //using map as dp array
        //in this solution we are getting time limit exceeded even with memo
        // so we need to precompute the palindromes for every length
        // idea is to build a dp array where dp[i][j] stores if str[i...j]  is a palindrome or not . True if yes otherwise no
        boolean [][] t = new boolean[str.length()][str.length()]; //denotes if a string is palindrome or not

        //initialize all with same character as true;
        for ( int i  = 0 ; i < t.length ; i++ ){
            t[i][i] = true; // we can't place this in the loop because this is initialization
        }
        //for length 2 and above
        for( int l = 2 ; l <= str.length() ; l++ ) {
            for( int i  = 0 ; i <= str.length() - l  ; i++  ) {
                int j =  i + l -1;
                if (l == 2) {
                    t[i][j] = (str.charAt(i) == str.charAt(j));
                }
                else  {
                    t[i][j] = ((str.charAt(i) == str.charAt(j)) && t[i+1][j-1]);
                }
            }
        }

        //bottom up solution
        int [] ans = new int[str.length()];
        Arrays.fill(ans , Integer.MAX_VALUE);
        for ( int i = 0 ; i < str.length() ; i++) {
            if(t[0][i]) {
                //it is a palindrome till this so no need to do anything;
                ans[i] = 0;
            }
            else {
                //applying k cuts
                for( int k = 0 ; k < i ; k++  ) {
                    if(t[k+1][i]) {
                        //the part the cut and till i is palindrome then only we can apply cut there
                        if(1 + ans[k] < ans[i]) {
                            //one cut at k + the cuts required till index k if it is lesser than the answer stored it means we got a new answer
                            //therefore we will update it
                            ans[i] = 1 + ans[k];
                        }
                    }
                }
            }
        }
        //finally we will get out answer in ans[n-1] that will store the min no of cuts at till that index
        System.out.println(ans[str.length() -1]);

        System.out.println(palindromePartitioning(str, dp , t , 0 ,str.length() -1 ));

    }

    static  int palindromePartitioning(String s , int[][] dp , boolean[][] t , int start , int end) {
        if(t[start][end]) {
            return  0;
        }
        if(dp[start][end] != -1 ) return dp[start][end];
        int res =Integer.MAX_VALUE;
        for( int k  =  start ; k  <=  end -1 ; k++ ) {

            int ans = 1 + palindromePartitioning(s, dp , t , start , k ) + palindromePartitioning(s, dp , t ,k+1 , end );
            res = Math.min(res , ans);
        }
        dp[start][end] = res;
        return dp[start][end];
    }

    static boolean isPalindrome(String s) {
        int  i = 0;
         int j = s.length() -1;
         while(i <= j) {
             if(s.charAt(i) != s.charAt(j)) {
                 return false;
             }
             i++;j--;
         }
         return true;
    }
}
