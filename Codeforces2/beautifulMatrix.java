package Codeforces;
import java.util.*;
public class beautifulMatrix {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int [][] arr=  new int[5][5];
        int ans = 0 ; int row = -1;int col= -1;
        for( int i  = 0 ; i < arr.length ; i++  ) {
            for (int j  = 0 ; j < arr.length ; j++ ) {
                int num = s.nextInt();
                if(num == 1) {
                    row = i; col=j;
                }
            }
        }
        ans = Math.abs(2 - row) + Math.abs(2 -col);
        System.out.println(ans);
    }
}
