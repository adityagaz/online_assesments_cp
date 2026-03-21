package Leetcode;
import java.util.*;
import java.util.jar.JarOutputStream;

public class servers_that_communicate {
    public static void main(String[] args) {    
        int [][] mat =  {
//                {1,0} , {0,1}
                {1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}
        };
        System.out.println(noOfCommunicatingServers(mat));
    }
    static  int noOfCommunicatingServers(int [][] mat ) {
        int [] row_s = new int[mat.length];
        int [] col_s = new int[mat[0].length];

        for( int i = 0 ; i < mat.length ; i++) {
            for (int j = 0 ;  j< mat[0].length; j++ ) {
                if(mat[i][j] == 1 ) {
                    //it means we have a server
                    row_s[i]++;
                    col_s[j]++;
                }
            }
        }
        System.out.println(Arrays.toString(row_s));
        System.out.println(Arrays.toString(col_s));
        int ans = 0;
        for ( int i  = 0 ; i < mat.length ; i++) {
            for( int j = 0 ; j < mat[0].length ; j++ ){
                if (mat[i][j] == 1) {
                    if(row_s[i] > 1 || col_s[j] > 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
