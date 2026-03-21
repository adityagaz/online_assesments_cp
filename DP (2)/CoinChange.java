package DP;

public class CoinChange {
    public static  void main (String [] args) {
        int [] coin = {2}; //infinite supply of coins
        int target = 0;
        int ans = minCoins(coin , target , coin.length -1 );
        if(ans == (int) 1e9) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }
    }

    static  int minCoins(int [] coin , int target , int index ) {
//        if(target == 0) {
//            return 1;
//        } //since we are sending the +1 with every pick we donot need to return 1 when the target is found.
        //it will automatically do that because we are adding that one with every call.
        if(index == 0) {
            if(target % coin[0] == 0) {
                return target / coin[0];
            }
            else {
                return (int) 1e9;
            }
        }
        if(index < 0 || target < 0 ) {
            return (int) 1e9;
        }
        //pick and stay && nopickandmove
        int pick_stay = 0;
        pick_stay = 1+ minCoins(coin , target - coin[index] , index );
        int nopick = minCoins(coin , target , index -1);
        return Math.min(pick_stay , nopick);
    }

    static int minCoinsMEMO(int [] coin , int target , int index , int [][]dp) {
        if( index == 0) {
            if(target % coin[0] == 0) {
                return target/ coin[0];
            }
            else {
                return (int) 1e9;
            }
        }
        if(index < 0 || target < 0) {
            return (int) 1e9;
        }
        if(dp[target][index] != -1) return dp[target][index];

        int pickAndStay = 1+ minCoinsMEMO(coin , target -  coin[index ] , index ,dp);
        int nopick = minCoinsMEMO(coin , target , index-1 ,dp);
        dp[target][index] = Math.min( pickAndStay , nopick);
        return dp[target][index];
    }

    static int minCoinsBU(int [] coin , int target) {
        int [][] dp = new int[target +1][coin.length];

        for( int t = 1 ; t < target +1 ; t++ ){
            if(t % coin[0] == 0) {
                dp[t][0] = t / coin[0];
            }
            else {
                dp[t][0] = (int) 1e9;
            }
        }
        for( int t = 1 ; t < target +1 ; t++  ) {
            for( int j =1 ; j < coin.length ; j++) {
                int pickAndStay = 0;
                if(t >= coin[j]) {
                    pickAndStay = 1+ dp[t - coin[j]][j];
                }
                else {
                    pickAndStay = (int) 1e9;
                }
                int nopick = dp[t][j-1];
                dp[t][j] = Math.min( pickAndStay , nopick);
            }
        }
        int ans = dp[target][coin.length -1];
        return ( ans == (int) 1e9) ? -1 : ans;
    }
}
