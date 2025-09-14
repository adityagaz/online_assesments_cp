package VISA;

import java.util.HashSet;
import java.util.*;

public class three {
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] mat = new int [n][n];
        for(int i = 0 ; i < n ; i++) {
            for( int j  = 0 ; j < n ; j++ ) mat[i][j] = s.nextInt();
        }

        solve(mat , n , mat[0].length);
    }

    static int solve(int [][] mat , int n, int m ) {
        int ans = 0;
        for( int i  = 0; i < n ; i++ ) {
            for( int j = 0 ; j < m ; j++ ) {

                Set<Integer> set = new HashSet<>();
                for(int k = 0 ; k < m ; k++ ) {
                    if(k==j)continue;
                    set.add(mat[i][k]);
                } 
                for(int k = 0 ; k < n ; k++ ) {
                    if(k==i)continue;
                    set.add(mat[k][j]);
                } 
                 if(( set.size()==1) || set.size()==0) ans++;
               
            }
        }
        System.out.println(ans);
        return ans;
    }
}
