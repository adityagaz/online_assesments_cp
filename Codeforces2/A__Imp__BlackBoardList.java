package Codeforces;
import java.util.*;
public class A__Imp__BlackBoardList {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t --  > 0)
        {
            int n = s.nextInt();
            int [] arr = new int[n];
            for ( int i = 0 ; i < n ; i++)
            {
                arr[i] = s.nextInt();
            }
            System.out.println(solve(arr));
        }
    }

    static int solve(int [] arr) {
        for( int i : arr) {
            if ( i < 0) {
                return i;
            }
        }
        int max = arr[0];
        for( int i : arr) {
            if( i > max) {
                max = i;
            }
        }
        return max;
    }
}
