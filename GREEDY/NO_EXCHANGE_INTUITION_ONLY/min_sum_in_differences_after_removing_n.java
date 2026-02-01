
import java.util.*;
public class min_sum_in_differences_after_removing_n {

    /*
    LEETCODE HARD | GREEDY | INTUITION 
    You are given a 0-indexed integer array nums consisting of 3 * n elements.
    You are allowed to remove any subsequence of elements of size exactly n from nums. 
    The remaining 2 * n elements will be divided into two equal parts:
    The first n elements belonging to the first part and their sum is sumfirst.
    The next n elements belonging to the second part and their sum is sumsecond.
    The difference in sums of the two parts is denoted as sumfirst - sumsecond.
    For example, if sumfirst = 3 and sumsecond = 2, their difference is 1.
    Similarly, if sumfirst = 2 and sumsecond = 3, their difference is -1.
    Return the 
    minimum difference possible between the sums of the two parts after the removal of n elements.


    APPROACH - 

    we have to remove n elements such that the first part sum - second part sum = minimised
    So, observe in any case we have to take the right part as n elements 
    so, we have to find the left part from index 1....2n
    and also we can imagine a partition at 2n 
    now we have to slide that partition from n....2n
    and left sum will store max from 1...i and right sum will store max from i+1....3N 
    where i goes from i = N to 2N
    make two arrays left and right and store the prefix mins and suffix maxes as running sum in priority 
    queues.
    Finally iterate in Left array and take ans =  min(ans, left[i] - right[i]);
    Voila!! that's it

    We were supposed to deviate by the question to remove n elements but we are smart and we 
    figured out that this is just to play games with us.
    Actual question is greedy minimization.
    There is no exchange arguments possible because this is not optimal ordering problem but 
    it is activity selection based problem.


    To boost confidence solve LC mediums and hards sorted by high acceptance rates first and continue doing cp.

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for( int i =0; i < n ; i++ ) {
            arr[i] = s.nextInt();
        }
        solve( arr ,n);
    }

    static public long solve(int[] nums , int l) {

        int n = l/3; 

        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> {
            return b - a;
        });
        long [] left = new long[n+1];
        long [] right = new long[n+1];
        long running_sum = 0L;
        int idx = 0;
        for(int i = 0; i < 2*n; i++ ) {
            pq.add(nums[i]);
            running_sum += nums[i];
            if(pq.size() > n) {
                long popped = pq.peek() ;pq.poll();
                running_sum -= popped;
            }
             if (i >= n-1) left[i - (n-1)] = running_sum;
        }
        pq = new PriorityQueue<>();
        idx = 0;
        running_sum = 0L;
        for( int i = l-1; i >= n; i--  ) {
            pq.add(nums[i]);
            running_sum += nums[i];
            if(pq.size() > n) {
                long popped = pq.peek() ;pq.poll();
                running_sum -= popped;
            }
           if (i <= 2*n) right[2*n - i] = running_sum;
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0 ; i <= n ; i++ ) {
            ans  = Math.min(ans, left[i] - right[n-i]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return ans;
        
    }
}
