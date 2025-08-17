package DSA_BEST_TEMPLATES.TWO_POINTERS;
import java.util.*;

import TREES.re_arrange_tree;
public class shortest_subarray_sum_atleast_k {

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [] arr = new int[n];
        for( int i = 0 ; i < n ; i++ ) arr[i] = s.nextInt();

        System.out.println(solve(arr , k , n));
    }

    static int solve( int []arr , int k , int n) {
        int ans = (int)1e6;

        int tail = 0 , head = -1;

        // ds 
        long sum = 0L;

        while(tail < n) {
            while(head +1  < n  && (sum +  arr[head+1]  <  k) ) {
                    head++;
                    sum += arr[head];
                }
            ans = Math.min(ans , head - tail +1 );
            if(tail > head ){ 
                tail++;
                head = tail-1;
            }
            else {
                sum -= arr[tail];
                tail++;
            }
            
        }

        if(ans == (int)1e6) {
            return -1;
        }
        else {
            return ans;
        }
    }
    
}