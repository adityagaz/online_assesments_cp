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
        // System.out.println(rec(happiness, 0, n, 0));
        bottomUp(happiness);
    }

    static void bottomUp(int [][] happiness) {
        int n = happiness.length;
        long [] dp_a = new long[n+1];
        long [] dp_b = new long[n+1];
        long [] dp_c = new long[n+1];

        dp_a[1] = happiness[0][0];
        dp_b[1] = happiness[0][1];
        dp_c[1] = happiness[0][2];

        for(int i = 2 ; i <= n ;i++) {
            dp_a[i] = happiness[i-1][0] + Math.max(dp_b[i-1] , dp_c[i-1]);
            dp_b[i] = happiness[i-1][1] + Math.max(dp_a[i-1] , dp_c[i-1]);
            dp_c[i] = happiness[i-1][2] + Math.max(dp_b[i-1] , dp_a[i-1]);
        }

        System.out.println(Math.max(dp_a[n] , Math.max(dp_b[n], dp_c[n])));
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
