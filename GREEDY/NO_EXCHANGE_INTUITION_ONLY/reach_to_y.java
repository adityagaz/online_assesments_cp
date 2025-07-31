package GREEDY.NO_EXCHANGE_INTUITION_ONLY;

import java.util.Scanner;

public class reach_to_y {

    /*
      you have two integers x and y
      in one move you can do x = x-1 or x = 2x 
      Find the minimum number of moves to reach y
      //Approach
      In these kind of problems we can think of flipping the order and looking at the problem from reverse

      so at y we can come to y by either y-1 or y/2
      so we will go from y to x rather than going x to y 
      we have x= y-1 and x = 2y therefore y operations are y = y/2 or y = y +1
      now we have two cases from here

      1. y can be before x 
      case 1 y < x 
        then if y is even then doing y = y/2 is stupid because we have to reach to x which is bigger than y
        if y is odd then we can't really use the operation because if we use then the result won't remain integer anymore.
        so in any case our only option is y = y +1 if y < x

      case 2 y > x 
        we can use both options 
        if y is even then we will do y/2 and if y is odd then we have only one option y = y +1 
        it is always optimal to half the number whenever possible because it reduces it drastically 
        do it with recursion
        since we half the number in every alternating step we will reduce the number quickly in almost log time
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long x = s.nextLong() , y = s.nextLong();
        long res = solve(x , y );

        System.out.println(res);
    }

    static long solve(long x ,  long y  ) {
        if(x==y) return 0;
        long ans = Long.MAX_VALUE;
        if(y < x ) {
            ans = Math.min(ans , 1 + solve(x, y+1));
        }
        else {
            if((y&1)==1) {
                ans = Math.min(ans, 1 + solve(x, y+1));
            }
            else {
                ans = Math.min(ans, 1 + solve(x, y/2));
            }
        }
        return ans;
    }
}
