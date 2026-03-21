
import java.util.*;

public class Book_Shop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] prices = new int[n];
        int[] pages = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }
        solve(n, x, prices, pages);
    }

    static void solve(int n, int x, int[] prices, int[] pages) {

        // int[][] dp = new int[2][x + 1];
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j <= x; j++) {
        //         int currentBook = i - 1;
        //         int curr = i & 1;
        //         if (j < prices[currentBook]) {
        //             dp[curr][j] = dp[curr ^ 1][j];
        //         } else {
        //             dp[curr][j] = Math.max(dp[curr ^ 1][j], pages[currentBook] + dp[curr ^1][j - prices[currentBook]]);
        //         }
        //     }
        // }

        // System.out.println(dp[n%2][x]);

        //easy way out
        int [] prev = new int[x+1];
        for(int i =1 ; i <= n ; i++ )  { 
            int [] curr = new int[x+1];
            for( int j = 0 ;  j <=x ;j++ ) {
                if( j  < prices[i-1] ){
                    curr[j] = prev[j];
                }
                else{
                    curr[j] = Math.max(prev[j] , pages[i-1] + prev[j - prices[i-1]]);
                }
            }
            prev = curr;
        }

        System.out.println(prev[x]);
    }
}
