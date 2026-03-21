package DP;
//codeforces 1932A
import  java.util.*;
public class thornsAndCoins {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int l= s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            int [] dp = new int[str.length()+1];
            Arrays.fill(dp ,-1);
            System.out.println(solve(str ,l , 0 , dp));
        }
    }
    static  int solve(String s , int l ,int idx , int [] dp) {
        if(idx >= l) {
            return  0;
        }
        if(dp[idx] !=-1) {
            return dp[idx];
        }
        int one_step=0 ;
        int two_step =0;
        char ch = s.charAt(idx);
        if(ch != '*') {
            if(ch == '@') {
                one_step = 1 + solve(s , l , idx+1 ,dp);
                two_step = 1+solve(s ,l ,idx+2 , dp);
            }
            else {
                one_step = solve(s , l , idx+1 ,dp);
                two_step = solve(s ,l ,idx+2 ,dp);
            }
        }
        dp[idx] = Math.max(one_step , two_step);
        return  dp[idx] ;
    }
}
