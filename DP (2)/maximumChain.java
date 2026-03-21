package DP;
import java.util.*;
public class maximumChain {

    public static void main(String[] args) {
        int [][] pairs = {
                {1,2}, {7,8} , {4,5}
        };
        boolean [] visited = new boolean [pairs.length];
        System.out.println(1+ maxChain(pairs, visited , 0));

    }

    static  int maxChain(int [][] pairs , boolean [] visited , int idx) {

         visited[idx] = true;
         int ans = 0;
         for( int i  = 0 ; i < pairs.length ; i++) {
             int one = 0;
             if(!visited[i]) {
                 if(pairs[idx][1] < pairs[i][0]) {
                     visited[i] = true;
                     one = 1 + maxChain(pairs, visited, idx+ 1);
                     visited[i] = false;
                 }
             }
             ans = Math.max(ans, one);
         }
         return ans;
    }
}
