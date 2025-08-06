package counting;
import java.util.*;
public class goldman_sachs_min_steps_if_can_go_back {


    /*
      Problem:
You are given an array of positive integer costs, indexed from 1 to n. You start at index 1, and your goal is to either move beyond the end of the array 
(i.e. to index n+1) or reach index n itself. From any current position i, you may:
Jump two indices forward (i → i+2), or
Jump one index backward (i → i−1).
Each time you land on an index j (including the starting index 1), you incur the cost b[j].
 You may visit each index at most once. 
 Compute the minimum total cost required to reach the end of the array (index n or beyond).

Example:
For the array b = [2, 5, 8], what is the minimum cost to reach index 3 or beyond?

     */


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n+2];
        for( int i =1 ; i <= n ;i++ ){
            arr[i] = s.nextInt();
        }
        int [][] dp = new int[n+1][3];

        dp[1][1]= arr[1];
        dp[1][2]= (int)1e8;
        
        dp[2][1] = (int)1e8;
        dp[2][2]= arr[1] + arr[3] + arr[2];
        /*
          dp[3] = arr[1] + arr[3] or arr[4] + arr[3] --> arr[3] + math.min(dp[i-2] , dp[i+1]);

          so now we can see that our dp states depend on forward as well as backward indices
          Now, 
          whenever these situations arise we can make a new state
          dp[i][forward] -- min cost to reach i with forward move from i-2...
          dp[i][forward] -- a[i] + min(however you reached i-2 ) = a[i] + min(dp[i-2][fwd] , dp[i-1][bwd])

          dp[i][backward] -- dp[i-1][fwd] + a[i] + a[i+1]

          here is the twist we can't go two times back becuase 
          1     2       3       4       5       6       7       8       n-2     n-1     n
           \___________/\______________/
           suppose we jumped from 1 -> 3 -> 5 then we come from 5->4 but we can't go from 4 -> 3 again 
           because it is already visited.

           so our moves can look like fffffbffff...fbf....f
           no consecutive backward moves

           so for dp[i][backward] we take best answer till dp[i-1][fwd] + a[i+1] + back to a[i]

           here we can't consider dp[i-1][bwd] becuase it will guarantee that a[i] is visited already by there 
           we came at i-1... formally dp[i-1][bwd] already includes dp[i-2][fwd] + a[i-1] + a[i] ... so a[i] is already
           visited and we can't visit it more than once so we can't include dp[i-1][bwd] in calculating dp[i][bwd]

           hence, 
           dp[i][bwd] = dp[i-1][fwd] + a[i] + a[i+1]
           dp[i][fwd] = a[i] + min(dp[i-2][fwd] , dp[i-2][bwd])

           dp[1][fwd] = a[1] -- imagine you have only one number
           dp[1][bwd] = 1e8 -- there is no number before 1 so that we jump to 2 and then come to 1 again
           
           dp[2][fwd] = 1e8  -- there is nothing before 1 such that we can jump from 0 to 2 directly
           dp[2][bwd] = dp[1][2] + a[3]  +a[2]

           now we are sure that i-2 will not go out of bounds... no confirm for i+1

           dp[n][fwd] = a[n] + min(dp[i-2][fwd] , dp[i-2][bwd])
           dp[n][bwd] = 1e8

           for i = 3 to n-1:
                dp[i][fwd] = a[i] + min(dp[i-2][fwd] , dp[i-2][bwd])
                dp[i][bwd] = dp[i-1][fwd] + a[i+1] + a[i]
            
            
            Final Answer -- 
            we can jump directly from n-1 also. so best answer to come at n-1 only from fwd. Why not bwd because 
            bwd will assume that we went to n and then came back and it is very trivial to notice that if we 
            already go to n then we reached our goal and suffices for the problem no need to come back to n-1 and again 
            go to n.

            But wait this is wrong.... what if we reach n-1 from the path n-2 -> n -> n-1 -> free 
            may be could contain -1000 and would decrease out sum. So it can be an option to go to n-2 -> n -> n-1

            so  Ans = min (dp[n-1][fwd] ,dp[n-1][bwd] ,  dp[n][fwd] )


            this is brainrot problem....

            TL;DR - we can do this by graph modelling.....
            will try sometime later

         */

        dp[1][1]= arr[1];
        dp[1][2]= (int)1e8;
        
        dp[2][1] = (int)1e8;
        dp[2][2]= arr[1] + arr[3] + arr[2];

        for( int i = 3 ; i <= n-1 ; i++ ){
            dp[i][1] = arr[i] + Math.min(dp[i-2][1] , dp[i-2][2]);
            dp[i][2] = dp[i-1][1] + arr[i+1] + arr[i];
        }

        dp[n][1] = arr[n] + Math.min(dp[n-2][1] , dp[n-2][2]);
        dp[n][2] = (int)1e8;

        System.out.println(Math.min(Math.min(dp[n-1][1] , dp[n-1][2]) , dp[n][1]));


        
    }
}
