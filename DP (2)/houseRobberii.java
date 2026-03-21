package DP;
import java.lang.reflect.Array;
import java.util.*;

public class houseRobberii {
    public static void main(String[] args) {
        int [] cost = {1,2,1,1};

        int [] dp = new int[cost.length];
        Arrays.fill(dp ,-1);
        int [] dp2 = new int[cost.length];
        Arrays.fill(dp2 ,-1);
            int [] newCost = Arrays.copyOfRange(cost , 0 , cost.length-1);
            int maxCost = maxRobb(newCost , newCost.length-1 , dp );

            int [] newCost2 = Arrays.copyOfRange(cost , 1 ,cost.length);
            int maxCost2 = maxRobb(newCost2 , newCost2.length-1 , dp2);

        // Arrays.copyOfRange() is inclusive of start index and exclusive of  end index
        System.out.println(maxRobbBU(cost));
    }

    static int maxRobbRecursive(int [] cost , int house ) {
        if( house < 0) {
            return 0;
        }
        int money = Math.max(maxRobbRecursive(cost , house -2  ) + cost[house] , maxRobbRecursive(cost , house -1  ));
        return money;
    }

    static int maxRobb(int [] cost , int house , int [] dp) {
        if( house < 0) {
            return 0;
        }
        if(dp[house] != -1) {
            return  dp[house];
        }
        dp[house] = Math.max(maxRobb(cost , house -2 , dp ) + cost[house] , maxRobb(cost , house -1 , dp ));
        return dp[house];
    }

    static  int maxRobbBU(int [] cost ){
        int [] cost1 = Arrays.copyOfRange(cost , 0 , cost.length-1);
        int [] cost2 = Arrays.copyOfRange(cost , 1 , cost.length);
        int [] dp1= new int[cost.length];Arrays.fill(dp1 ,-1);
        int [] dp2 = new int[cost.length];Arrays.fill(dp2 ,-1);
        dp1[0] = 0;
        dp1[1] = cost1[0];
        dp2[0] = 0;
        dp2[1] = cost2[0];
        for(int i =  2  ; i <= cost1.length ; i++) {
            dp1[i] = Math.max(cost1[i-1] + dp1[i-2] , dp1[i-1]);
        }
        for( int i = 2; i <= cost2.length ; i++ ){
            dp2[i] = Math.max(cost2[i-1] + dp2[i-2] , dp2[i-1]);
        }

        return Math.max(dp1[cost.length-1] , dp2[cost.length -1]);
    }

    //it can be further optimised to just two variables because the dp only depends on two
    //best solution is TC - O(n) and  SC - O(1)
}
