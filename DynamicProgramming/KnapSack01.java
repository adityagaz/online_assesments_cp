package DynamicProgramming;
import java.util.*;
public class KnapSack01 {

    public static void main (String [] args) {
        int [] weight = {4, 5, 1};
        int [] profit = {1, 2, 3};
        int n  = 3; //no of items
        //weight[i] denotes weight of each item and
        // profit[i] denotes profit of each item
        int total_weight= 4;

        //denotes the weight of your bag or a sack
        int [][] dp = new int[n+1][total_weight+1];
        for( int [] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(knapsackMaxProfit( weight , profit , n , total_weight , dp));

    }

    /*
    1. focus on return type
    2. focus on writing the base condition
    2a.donot bluntly make the whole tree (never draw the whole tree) and think of the base
    condition rather than
    try to think about the smallest valid input
    then try to think about the smallest valid output and return in the
    base conditions...trust me this will come with practice
    2b.  after writing the base case make the choice diagram on pen and paper initially
        and make it for one level and think of all cases
       donot again think of multiple levels as it overwhelms our mind and we get nervous in
       an interview
    2c. after you have written the choice diagram on paper think of how to reduce the input with
    every diagram (for example in array you can start from last index and reduce the array size
    2d. now that you have written all the conditions just ensure you are returning from every call
    3. memoization
    trust me this is one of the easiest step
    3a. just see in the recursion what all parameters are changing and then make a dp array of size
    of those variables +1 now and just check before you call the next recursion if it is present and
    store it in that index where you were having return from the function call.
    that's it
    All it takes is making the correct tree and base condition.
     */

    static int knapsackMaxProfit(int [] weight , int [] profit , int n , int total_weight , int [][] dp) {
        if(n == 0 || total_weight  == 0) {
            //either there are no items to put or the bag is full
            //this is the smallest valid input (either of them)
            //then if this occurs then we are gonna return what huh ?? we are gonna return
            //what will happen if this condition occurs
            //so think what is our main goal to return profit right so if we have
            //dont have any items to add or our bag is full then we donot have any profit right
            //so return zero
            return 0;
        }
        if(dp[n][total_weight] != -1) {
            return dp[n][total_weight];
        }

        /*
        now time to write the choice diagram as i said
        1. there is one possibility that the item we are considering has a weight greater than our
        bag so it is "aukaat ke bahar" so we will say that we will look for next item
        and remember we have to reduce the input anyhow so we will say a n-1.

        2. now the other option is that we have that the item is in our aukaad
        so our aukaad means "lena hai ya nahi lena" so we have max(lena wala call , nahi lena wala call)
        so lena wala call me we will add the profit by writing the profit[i] + next call
         */

        if(weight[n-1] <= total_weight) {
            return dp[n][total_weight] =  Math.max(profit[n-1] +
                knapsackMaxProfit(weight , profit  , n-1 , total_weight - weight[n-1] , dp),
                knapsackMaxProfit(weight , profit, n-1 , total_weight , dp));
        }
        else{
            return dp[n][total_weight] = knapsackMaxProfit(weight ,profit , n-1, total_weight , dp);
        }
    }
}
