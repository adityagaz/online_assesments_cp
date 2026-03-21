package DynamicProgramming;
import java.util.Arrays;
public class LCSIterative {

    public static void main (String [] args) {
        int [][]dp= new int [1001][1001];

        //first of all make all the values as -1;

        for (int [] i : dp)  {
            Arrays.fill(i, -1);
        }
        String x ="abcd";
        String y = "abcd";
        System.out.println(LCS(x,y,dp));

    }

    static int LCS(String x , String y , int [][] dp) {
        //make all the values of first row and column as 0 because of the base case.
        for( int i = 0 ; i <= x.length() ; i++ ){
            for( int j = 0 ; j <= y.length() ; j++) {
                if( i==0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        //start filling the dp table from 1 till length(including)

        for( int i = 1 ; i<= x.length() ; i++ ){
            for( int j = 1  ; j <= y.length() ; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[x.length()][y.length()];
    }
}
