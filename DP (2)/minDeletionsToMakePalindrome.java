package DP;
import java.util.*;
public class minDeletionsToMakePalindrome {
    public static void main(String[] args) {
        String s = "babbb";
        // length of string - longest palindromic subsequence length
        //or the below is the second option. not optimised though.

    }
    static  int minDeletions(String s , int i , int j  , HashMap<String , Integer> mp) {
        if(i > j) return 0;
        if(mp.containsKey(s)) return mp.get(s);
        int ans = 0;
        if(s.charAt(i) != s.charAt(j)) {
            String del_i = s.substring(0 ,i) + s.substring(i+1);
            String del_j = s.substring(0 ,j) + s.substring(j+1);
            String del_both = s.substring(0,i)+ s.substring(i+1 , j) + s.substring(j+1);
            int one_del = 1 + Math.min(minDeletions(del_i , i , j-1 , mp) , minDeletions(del_j , i, j-1 , mp));
            int two_del = 2 + minDeletions(del_both , i , j-2 , mp);
            ans = Math.min(one_del , two_del);
        }
        else {
            ans = minDeletions(s , i+1 , j-1 ,mp);
        }
        mp.put(s+i+j , ans);
        return mp.get(s+i+j);
    }
}
