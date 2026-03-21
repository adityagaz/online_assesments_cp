package Backtracking;
import java.lang.reflect.Array;
import java.util.*;
public class LexicographicallyLongestSequence {
    public static void main(String[] args) {
        int n = 5;
        int l =  2 * n -1;
        int [] ans  = new int[l];
        int [] vis = new int[n+1];
        //to keep track of visited numbers.
        canPlace(ans , vis , n , 0);
        System.out.println(Arrays.toString(ans));
    }

    static boolean canPlace(int [] ans , int [] vis , int n , int idx ) {
        if(idx >= ans.length) return true;

        if(ans[idx] != 0)  {
            return canPlace(ans , vis , n , idx+1);
        }


        for( int i = n ; i >= 1 ; i-- ) {
            if(vis[i] ==1 ) continue;
            int nextIdx = i+idx;

            if(i ==1 ){
                //if we have number as 1 then we only need that index
                if(ans[idx] == 0) {
                    vis[i] =1;
                    ans[idx] =i;
                    if(canPlace(ans , vis , n , idx +1) ) return true;
                    else {
                        vis[i]= 0;
                        ans[idx] =0;
                    }
                }
            }
            if(nextIdx < ans.length && ans[idx] == 0 && ans[nextIdx] == 0) {
                //place it and check forward
                ans[idx] = i;ans[nextIdx] =i;
                vis[i] = 1;
                if(canPlace(ans , vis , n , idx +1)) {
                    return true; //we have got the answer
                }
                else {
                    // we have put the wrong number -->back track
                    ans[idx] = 0;ans[nextIdx]=0;vis[i]=0;
                }
            }
        }
        return false;
    }
}
