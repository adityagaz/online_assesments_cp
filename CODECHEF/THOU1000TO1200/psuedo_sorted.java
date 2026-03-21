package CODECHEF.THOU1000TO1200;
import java.util.*;
public class psuedo_sorted {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int len = s.nextInt();
            int [] arr = new int[len];
            for( int i = 0 ; i < len ; i++  ) {
                arr[i] = s.nextInt();
            }
            solve(arr , len );
        }

    }
    static void solve( int [] arr , int len) {
    for( int i  =0 ; i < len -1 ; i++ ) {
        if (arr[i + 1] < arr[i]) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }
    }
    for( int i = 0 ; i < len ; i++ ) {
        if (arr[i + 1] < arr[i]) {
            System.out.println("NO");
            return;
        }
    }
    System.out.println("YES");
    }
}
