package CODECHEF.THOU1000TO1200;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ups_and_downs {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while( t -- > 0 ) {
            int len = s.nextInt();
            int [] arr = new int[len];
            for( int i = 0 ; i < len ; i++) {
                arr[i] = s.nextInt();

            }
            solve(arr, len);
            System.out.println();
        }

    }
    static void solve( int [] a , int l) {

        for( int i = 1 ;i < a.length;   i+=2 ) {
            int m_index = -1;
            int max = a[i];
            for ( int j = i-1  ; j <= i+1  ; j++ ){
                if(j < a.length && (a[j] > max)) {
                    max = a[j];
                    m_index = j;
                }
            }
            if(m_index != -1){
                int temp = a[i];
                a[i] = a[m_index];
                a[m_index] = temp;
            }
        }
        for( int i : a) {
            System.out.print(i + " ");
        }
    }


}



