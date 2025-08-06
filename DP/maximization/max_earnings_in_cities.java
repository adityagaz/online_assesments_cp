package maximization;
import java.util.*;

 /*
Company: Google
You work as a consultant and have clients in cityA and cityB. On a given day,
say i, you can either work in cityA and make Ai dollars or you can work in cityB and make Bi dollars. You can also spend
the day traveling between cityA and cityB in which case your earnings that day are 0.
Given Al,A2, ....An and B1, B2,....., Bn, return a schedule S of N days which maximizes your earnings,
You can start either in cityA or cityB.
You need to print the final maximum earning
Example1:  A = [23, 4,5 ,101] B = [21,1,10, 100] The optimal schedule S here would be ->"ATBB"
Example 2: A[25,10,15,10,70]  B = [5,5,50,5,30] The optimal schedule S here would be-> "ATBTA"
Follow up :-> solve the problem for 3 cities A,B,C
All dollars are positive!
  */
public class max_earnings_in_cities {
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr  = new int[n+1];
        int [] brr = new  int[n+1];
        for( int i= 1 ; i <= n ; i++ ) {
            arr[i]=s.nextInt();
        }
        for( int i= 1 ; i <= n ; i++ ) {
            brr[i]=s.nextInt();
        }
        int [] dp_a = new int[n+1];
        int [] dp_b = new int[n+1];
        dp_a[1]= arr[1];
        dp_b[1]= brr[1];
        dp_a[2] = Math.max(arr[2] + dp_a[1],  arr[2]);
        dp_b[2] = Math.max(brr[2] + dp_b[1],  brr[2]);
        for( int i = 3 ; i <= n ; i++ ) {
            dp_a[i] = Math.max(dp_a[i-1] + arr[i], dp_b[i-2]+arr[i]);
            dp_b[i] = Math.max(dp_b[i-1] + brr[i], dp_a[i-2]+brr[i]);
        }
        System.out.println(Math.max(dp_a[n], dp_b[n]));
    }

    static int followUP(int [] a , int [] b , int [] c) {
        int n = a.length;
        int [] dp_a = new int[n+1];
        int [] dp_b = new int[n+1];
        int [] dp_c = new int[n+1];

        dp_a[1] = a[1];
        dp_b[1] = b[1];
        dp_c[1] = c[1];
        dp_a[2] = Math.max(a[2] + dp_a[1],  a[2]);
        dp_b[2] = Math.max(b[2] + dp_b[1],  b[2]);
        dp_c[2] = Math.max(c[2] + dp_c[1],  c[2]);

        for( int i=3 ;i<=n ;i++) {
            dp_a[i] = a[i] + Math.max(dp_a[i-1] , Math.max(dp_b[i-2] , dp_c[i-2]));
            dp_a[i] = c[i] + Math.max(dp_c[i-1] , Math.max(dp_a[i-2] , dp_b[i-2]));
            dp_b[i] = b[i] + Math.max(dp_b[i-1] , Math.max(dp_a[i-2] , dp_a[i-2]));
        }
        int ans = Math.max(dp_a[n], Math.max(dp_b[n], dp_c[n]));
        System.out.println(ans);    
        //T.C - O(N) , SC - O(3*N)
        return ans;
     }
}
