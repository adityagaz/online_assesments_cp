
import java.util.*;
public class amazon_oa {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for( int i = 0 ; i < n ; i++ ) arr[i] = s.nextInt();
        solve(arr , n);

    }
    static void solve(int [] arr , int n) {
       int [] diff = new int[n];
        for( int i = 1 ; i<n;i++) {
            if(arr[i] < arr[i-1] ) {
                diff[i] = arr[i-1]-arr[i] ;
            }
        }
        int ans = 0;
        for( int i = 1 ; i < n ; i++ )  {
            ans +=diff[i];
        }
        System.out.println(ans);
    }    
}
