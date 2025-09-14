package VISA;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][] mat = new int [n][n];
        for(int i = 0 ; i < n ; i++) {
            for( int j  = 0 ; j < n ; j++ ) mat[i][j] = s.nextInt();
        }

        solve(mat , n);
    }

    static long solve( int [][] mat , int n ) {
        int [][] comb =  {{ 0 ,1 } , {0 , 2} , {1 , 0 } ,{1,2} , {2 , 0} , {2,1}}; //only these possible
        long min = Long.MAX_VALUE;
        for(int [] c : comb) {
            int y = c[0] , ny = c[1];
            long ans = check(mat , y , ny , n );
            min = Math.min(ans, min);
        } 
        System.out.println(min);
        return min;
    }

    static long check (int [][] mat, int y , int ny , int n ) {
        long cnt = 0;
        for( int i = 0 ; i < n ; i++ ) {
            for( int j = 0 ; j < n ; j++ )  {
                if((i<=n/2 && (i==j || i+j == n-1) || (i > n/2 && j==n/2)))  {
                    if(mat[i][j] != y) cnt++;
                }
                else{
                     if(mat[i][j] != ny ) cnt++;
                }
            }
        }

        return cnt;
    }
}
