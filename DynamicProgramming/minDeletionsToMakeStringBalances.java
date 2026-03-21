package DynamicProgramming;
import java.util.*;
public class minDeletionsToMakeStringBalances {
    public static void main (String [] args) {

        String s = "bbaaaaabb";
        int [][] dp = new int[s.length()+1][s.length()+1];
        for( int [] i : dp) {
            Arrays.fill(i ,-1);
        }
        System.out.println(minDelRecursive(s , 0 , 0 , dp));

        for( int [] i : dp) {
            System.out.println(Arrays.toString(i));
        }


    }

    static int minDelRecursive(String s , int index , int bCount , int [][]dp) {
        if(index == s.length()) {
            return 0;
        }

        if(dp[index][bCount] != -1) {
            return dp[index][bCount];
        }


        char c = s.charAt(index);

        if(c == 'b') {
            dp[index][bCount] = minDelRecursive(s , index +1 , bCount +1 ,dp );
        }
        else {
            //now we know that the curr is 'a' so we have two options that
            //check if we delete this a or we delete all the preceeding b's that come before this a
            //so we will explore both options and take minimum of that
            int deletionsB = 0 ;int deletionsA = 0;
            if(bCount  >0) {
                deletionsB = bCount + minDelRecursive(s , index +1, 0 , dp);
                deletionsA  = 1 + minDelRecursive(s , index+1 , bCount , dp);
                dp[index][bCount] = Math.min(deletionsA , deletionsB );
            }else {
                dp[index][bCount] =  minDelRecursive(s , index+1 , bCount ,dp);
            }

        }
        return dp[index][bCount];
    }

}
