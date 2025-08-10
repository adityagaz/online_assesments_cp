package maximization.couldNotSolve;
import java.util.*;
public class phone_pe_house_robber_adv {
    public static void main(String[] args) {

        Scanner s= new  Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int [] arr = new int[n+1];
            for(int i = 1; i <= n; i++) {
                arr[i] = s.nextInt();
            }
            solve(arr , n);
        }
        
    }

    static void solve(int [] arr , int n) {
        long [][] dp = new long[n+1][4];

        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][2] = arr[1]+arr[2];
        dp[2][3] = 0;

        dp[3][2] = Math.max(arr[1] + arr[2] , arr[2] + arr[3]);
        dp[3][3] = arr[1] + arr[2] + arr[3];

        for( int i = 4; i<=n ; i++ ){
            dp[i][2]  =  arr[i] + arr[i-1] + dp[i-3][2];
            for(int j = i-4; j>= 1; j--) {
                dp[i][2] = Math.max(dp[i][2] , arr[i] + arr[i-1] + 
                Math.max(i-j >=1 ? dp[i-j][2] : 0, i-j >=1 ? dp[i-j][3] : 0));
            }

            for(int k =  i-5; k >= 1; k-- ) {

                    dp[i][3] = Math.max(dp[i][3], arr[i] + arr[i-1]  + arr[i-2] + 
                (i-k>=1 ? Math.max(dp[i-k][2], dp[i-k][3]) : 0));
                

            }

        }

        long max = -(int)1e9;
        //  At last we have to calculate max so go through the whole dp[1...n][2] and dp[1.....n][3]) and get the max
        for( int i = 1; i <=n ; i++  ) {
            max= Math.max(max ,Math.max( dp[i][2],dp[i][3]));
        }

        for( long [] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println(max);

    }
}


/*
 
package maximization.couldNotSolve;
import java.util.*;
public class phone_pe_house_robber_adv {
    public static void main(String[] args) {

        Scanner s= new  Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int [] arr = new int[n+1];
            for(int i = 1; i <= n; i++) {
                arr[i] = s.nextInt();
            }
            solve(arr , n);
        }
        
    }

    static void solve(int [] arr , int n) {
        long [][] dp = new long[n+1][4];

        dp[1][2] = 0;
        dp[1][3] = 0;
        dp[2][2] = arr[1]+arr[2];
        dp[2][3] = 0;

        dp[3][2] = Math.max(arr[1] + arr[2] , arr[2] + arr[3]);
        dp[3][3] = arr[1] + arr[2] + arr[3];

        for( int i = 4; i<=n ; i++ ){
            dp[i][2]  =  arr[i] + arr[i-1] + dp[i-3][2];
            if (i >= 5) dp[i][2] = Math.max(dp[i][2], Math.max(dp[i-4][2], dp[i-4][3]));
            if (i>= 6) dp[i][3] = arr[i] + arr[i-1] + arr[i-2] + Math.max(dp[i-5][3] ,dp[i-5][2] );

        }

        long max = -(int)1e9;
        //  At last we have to calculate max so go through the whole dp[1...n][2] and dp[1.....n][3]) and get the max
        for( int i = 1; i <=n ; i++  ) {
            max = Math.max(max, Math.max(dp[i][2], dp[i][3]));
        }

        for( long [] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println(max);

    }
}

 */