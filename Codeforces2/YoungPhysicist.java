package Codeforces;
import java.util.*;
public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
            int [][] mat = new  int[n][3];
            for( int i  =  0 ; i < n ; i++) {
                for( int j = 0 ; j < 3 ; j++) {
                    mat[i][j] = s.nextInt();
                }
            }
            isEqui(mat ,n);
    }
    static  void  isEqui(int [][] matrix , int n) {
        int x=0 ; int y=0 ; int z=0;
            for( int r = 0 ; r < n ; r++) {
                x += matrix[r][0];
                y+=matrix[r][1];
                z+=matrix[r][2];
            }
            if( x== 0 && y== 0 && z ==0 ) System.out.println("YES");
            else System.out.println("N0");
    }
}
