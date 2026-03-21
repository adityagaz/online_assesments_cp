package DP;
import java.util.*;

public class PartitionString {

    public static void main(String[] args) {
        int n = 37;
        int ans = 0;
        for( int i = 1 ; i <= n ;i++) {
            int sq = i*i;
            String s = String.valueOf(sq);
            if(isSumSameAsNum(s,i))  {
                ans+=sq;
            }
        }
        System.out.println(ans);
    }

    static boolean isSumSameAsNum(String  s , int num ) {
        if(s.length() == 1) {
            return (Integer.parseInt(s) == num);
        }
        boolean ans = false;
        for( int i = 1;i<s.length();i++) {
            int left = Integer.parseInt(s.substring(0,i));
            int right =  Integer.parseInt(s.substring(i));
            if( left+right == num) {
                return true;
            }
            ans = ans || isSumSameAsNum(s.substring(i) , num - Integer.parseInt(s.substring(0,i)));
        }
        return ans;
    }
}
