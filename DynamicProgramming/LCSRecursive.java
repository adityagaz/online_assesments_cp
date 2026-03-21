package DynamicProgramming;


import java.util.*;
public class LCSRecursive {


    public static void main (String [] args) {

        String x ="abcdeasdfasdasdfasdfasdfasdfasdf";
        String y = "abcmeasdfasdfasdfasdfasdfasdfasdff";
        int [][] dp = new int [1001][1001];

        for(int [] i : dp )
        {
            Arrays.fill(i , -1);
        }


        System.out.println(LCS(x ,y ,x.length() , y.length() ,dp));

        //find the longest common subsequence
    }

    static int LCS(String x , String y , int xs , int ys ,int [][] dp) {
        //if any one of the strings is zero then return 0 because we cannot find a common substring
        //from a set of two in which any one is zero.
        if(xs == 0 || ys == 0) {
            return 0;
        }

        //check the dp table

        //how to decide what to store in dp table
        //: simple it is just check what is changing in function calls here it is m , n
        //so store answers for different values of m  , n

        if(dp[xs][ys] != -1) {
            return dp[xs][ys];
        }


        if(x.charAt(xs-1) == y.charAt(ys-1)) {

            //note there is a difference between passing xs-- , --xs , xs -1
            /*
            1. xs-- : means that pass the xs and then decrement in the current call
            this is of no use as we are not reducing the size in the further call we will end up in infinite recursion
            2. --xs : this is a subtle case where we decrement the xs value in the current call also and then pass it to
            the next call in this approach we can miss on few cases.
            3.xs -1 : this  one is the best as it doesnot change the value of the integer in the current call and also passes
            the decremented value to the next call.
             */
            dp[xs][ys] = 1 + LCS(x , y , xs-1, ys-1 ,dp);
            return dp[xs][ys];
        }
        else {

            dp[xs][ys] = Math.max(LCS(x,y,xs-1 , ys ,dp) , LCS(x,y ,xs,ys-1, dp) );
            return dp[xs][ys];
        }
    }
}
