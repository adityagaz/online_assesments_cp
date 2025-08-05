package SORTING_DP;
import java.util.*;
public class intervals_max_profit_or_meetings_max_profit {

    //Leetcode 1235 
    /*
      Problem - 
      Intervals will be given and you have to tell that what meetings or jobs should we do optimally 
      such that jo jobs overlap and also we have the maximum profit.
      Sort the jobs (start time or end time your wish)
      Then apply dp
        in dp we can take or not take but if we take we have to check which start time can we take next
            so we search for the start which is >= current end time (lower bound on currentendTime)
            pass starttime array in and key as current_end_time in lower_bound
        finally return the max of the dp array.
        dp[i] -- means the profit that ends at index i

    These kinds of problems are mixed with interval scheduling, sorting .... etc
    OAs are getting so hard these days.

     */
       public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [][]  jobs  = new int[n][3];
        // each job has s_time , e_time , profit
        for( int i = 0 ;  i < n ; i++ ) {
            int s_time = s.nextInt();
            int e_time = s.nextInt();
            int profit = s.nextInt();
            jobs[i][0] = s_time;
            jobs[i][1] = e_time;
            jobs[i][2] = profit;
        }


        Arrays.sort(jobs , (a , b) -> {
            return a[0] - b[0];
        });

        // e_time (i+1) >= s_time(i)

        int  [] start = new int[n];
        for( int i = 0 ; i < n ; i++ ) {
            start[i] = jobs[i][0];
        }

        dp = new int[n];
        Arrays.fill(dp , -1);

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
    static int [] dp;
    static int profitMaker( int [][] jobs, int [] start , int idx , int n ) {
        if(idx == n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int nextIndex = lb(start, jobs[idx][1]);

        int max_profit = Math.max(profitMaker(jobs, start, idx+1,n) ,
         jobs[idx][2] +  profitMaker(jobs, start, nextIndex, n));
        return dp[idx] = max_profit;

    }


    static int lb(int [] arr , int key) {
        int l = 0 , r = arr.length -1;
        while(l<=r){
            int mid = (l+r) >>>1;
            if(arr[mid] >= key) {
                r = mid -1;
            }
            else {
                l = mid +1;
            }
        }
        return l;
    }
        static int ub(int [] arr , int key) { // equivalent to c++ upper_bound

        int l = 0 , r = arr.length -1;
        while(l<=r){
            int mid = (l+r) >>>1;
            if(arr[mid] <= key) {
                l = mid + 1;
            }
            else {
                r = mid  -1; 
            }
        }
        return l;
    }
}
