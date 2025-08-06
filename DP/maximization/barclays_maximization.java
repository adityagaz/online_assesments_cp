package maximization;
import java.util.*;
public class barclays_maximization  {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int [] easy = new int[n+1];
            int [] hard = new int[n+1];
            for( int i= 1 ; i <= n; i++)  {
                easy[i] = s.nextInt();
                hard[i] = s.nextInt();
            }

            solve(easy , hard , n);
            
        }
    }
    static int solve( int [] easy  , int [] hard , int n) {

        int [] dp_easy = new int[n+1];
        int [] dp_hard = new int[n+1];

        dp_easy[1] = easy[1];
        dp_hard[1] = hard[1];

        // dp_easy[2] = easy[2] + Math.max(dp_easy[1], dp_hard[1]);
        // dp_hard[2] = hard[2];

        for( int i = 2 ; i<= n ; i++) {
            dp_easy[i] = easy[i] + Math.max(dp_easy[i-1], dp_hard[i-1]);
            dp_hard[i] = hard[i]  + Math.max(dp_hard[i-2], dp_easy[i-2]);
        }

        System.out.println(Math.max(dp_easy[n], dp_hard[n]));
        return 0;

    }
    
}
