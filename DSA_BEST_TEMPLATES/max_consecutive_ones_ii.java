package DSA_BEST_TEMPLATES;

import java.util.*;

public class max_consecutive_ones_ii {
     public static void main(String[] args) {
        

        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int [] arr = new int[n];
        for ( int i  =0 ; i < n ; i++ ) arr[i] = s.nextInt();


        /*
        Given a binary array nums, return the maximum number of consecutive 1's 
        in the array if you can flip at most one 0.

        Example 1:

        Input: nums = [1,0,1,1,0]
        Output: 4
        Explanation: 
        - If we flip the first zero, nums becomes [1,1,1,1,0] and we have 4 consecutive ones.
        - If we flip the second zero, nums becomes [1,0,1,1,1] and we have 3 consecutive ones.
        The max number of consecutive ones is 4.
        Example 2:

        Input: nums = [1,0,1,1,0,1]
        Output: 4
        Explanation: 
        - If we flip the first zero, nums becomes [1,1,1,1,0,1] and we have 4 consecutive ones.
        - If we flip the second zero, nums becomes [1,0,1,1,1,1] and we have 4 consecutive ones.
        The max number of consecutive ones is 4.
        

        Constraints:

        1 <= nums.length <= 105
        nums[i] is either 0 or 1.
        As we did the last problem we will just change few things and the template will do the trick.
        This is very trivial to do by for loop and counting but...I want to teach you a template of two pointers that works always



        What is the condition ?? 
        we can flip one 0 -> 1 right...
        so we will keep atmost one 0 in our window...
        and whenever the count > 1 we stop eating from head and start shrinking....
        that's all

        Identify the data structure...
        --> count to store the number of zeros

        Condition...

            eat till (count < 1) 
        
        just replace these two and the algo would do the trick
         */

        //declaration and assignment
        int tail = 0 , head = -1 ;
        // datastructure
        int count = 0;
        // answer
        int ans = 0;

        // start the loop

        while(tail < n) {
            while(head + 1 < n && (/*write the condition till we can expand */ arr[head+1]==1 || count < 1)) {
                head++;
                if(arr[head]==0) {
                    count++;
                }
            }
            // update answer
            ans = Math.max(ans , head - tail + 1);
            //reset condition
            if(tail > head ) {
                tail++;
                head = tail - 1;
            }
            else {
                //shrink the window 
                if(arr[tail]==0) {
                    count--;
                }
                tail++;
            }
        }

        //answer will be ready always here to return that's the trick....
         
        System.out.println(ans);
    }
}
