package maximization;
import java.util.*;
public class at_coder_c {
    /*
    There are n days
       Summary at each day i you are given three happiness values 
       if one chooses A - ai happiness 
       if one chooses B - bi happiness
       if one chooses C - ci happiness

       if you choose A task you can't do A on the next day same for B and C.
       return the maximum happiness you can hain.


                

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] happiness = new int [n][3];
        for ( int i  = 0; i < n ; i++ ) {
            happiness[i][0] = s.nextInt();
            happiness[i][1] = s.nextInt();
            happiness[i][2] = s.nextInt();
        }
        dp = new long[n][4];
        for( long [] i : dp) Arrays.fill(i, -1);
        System.out.println(rec(happiness, 0, n, 0));
    }

    static long [][] dp;
    static long rec(int [][] happiness , int idx , int n , int prev ) {

        if(idx == n ) return 0;

        if(dp[idx][prev] != -1) return dp[idx][prev];

        long max_profit = 0;
        for( int i=1;i<=3;i++ ) {
            if(prev == i ) continue;
            else max_profit = Math.max(max_profit , happiness[idx][i-1] +  rec( happiness, idx+1, n , i));
        }
        dp[idx][prev] = max_profit;
        return dp[idx][prev];
    }
}
