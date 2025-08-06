package counting;
import java.util.*;
public class google_sde_reduce_number_to_one {

    /*
      Given an integer “N” ; find the minimum cost to reduce it to 1
        The operations you can do are as follows.->

        i) Reduce the number by 1 in “y” dollars; 

        ii) Reduce the number by /7 in “x” dollars.(if number is divisible by 7)

        iii) Reduce the number by /3 in “z” dollars;(if number is divisible by 3)

        iv) Reduce the number by /5 in “b” dollars;(if number is divisible by 5) 

        (1<=n<=100000)


        // Approach -- let dp[i] represent min cost to reduce number i to 1 
        dp[1] = min cost to reduce 1 to 1 = 0
        dp[2] = min cost to reduce 2 to 1 = (either do operations) min(do op1 , do op2 , do op3 , do op4)
        dp[2] = y + dp[1] if op1 is chosen
        dp[2] = 2 % 7 == 0 ? x + dp[2 / 7] : (int)1e18
        dp[2] = 2 % 3 == 0 ? z + dp[3 / 7] : (int)1e18 
        dp[2] = 2/ 5 == 0 ? b + dp[2 / 5] : (int)1e18
        similarly for dp[3], dp[4] .... etc
        now,
        generally 
        dp[i] = Min(cost_op + op_if possible);

        return ans as dp[n] -- min cost to go from number n to 1.

        Test Case - 
        n , y ,x , z , b
        15
        100 
        1
        50
        100000

        Expected Output -
        201
 
     */

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        int y = s.nextInt();
        int x = s.nextInt();
        int z = s.nextInt();
        int b = s.nextInt();
        int [] dp = new int[n+1];
        dp[1] = 0;
        for(int i = 2; i <= n; i++ ) {
            int way1 = y + dp[i-1];
            int way2 = (i % 7 == 0 )? x + dp[i/7] : (int)1e8;
            int way3 = (i % 3 == 0) ? z + dp[i/3] : (int)1e8;
            int way4 = (i % 5 == 0) ? b + dp[i/5] : (int)1e8;
            dp[i] = Math.min(Math.min(way1, way2), Math.min(way3, way4)); 
        }

        System.out.println(dp[n]);
    }
}
