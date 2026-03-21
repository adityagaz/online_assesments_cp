package Codeforces;
//https://codeforces.com/contest/59/problem/B

import java.util.*;
public class BFortuneTelling {
    public static int ans = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ip = new int[n];
        for ( int i = 0 ; i < n ; i++ ) {
            ip[i] = s.nextInt();
        }
        int [][] dp = new int[ip.length][100001];
        for (int [] i : dp ) {
            Arrays.fill(i , -1);
        }
            System.out.println(maxPetals(ip, ip.length -1, 0 , dp));
    }

    static int maxPetals(int [] arr , int index  , int sum , int [][] dp){
        //base case --> if the index becomes zero and we have current sum as the largest odd number
        //then we can say that we have our answer

        if( index <  0 ) {
            if(sum % 2 != 0 ) {
                return sum;
            }
            else {
                return 0;
            }
        }
        if(dp[index][sum] != -1) {
            return dp[index][sum];
        }
        int ans  = 0 ;
        int pick_no_pick = Math.max(maxPetals(arr, index -1 , sum + arr[index] , dp),
                maxPetals(arr , index -1 , sum , dp));
        ans = Math.max(ans , pick_no_pick);
        dp[index][sum] = ans;
        return  dp[index][sum];
    }
}
