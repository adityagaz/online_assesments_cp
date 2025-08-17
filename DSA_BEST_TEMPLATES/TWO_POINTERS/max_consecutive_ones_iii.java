package DSA_BEST_TEMPLATES.TWO_POINTERS;

import java.util.Scanner;

public class max_consecutive_ones_iii {
     public static void main(String[] args) {
        

        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int k= s.nextInt();
        int [] arr = new int[n];
        for ( int i  =0 ; i < n ; i++ ) arr[i] = s.nextInt();


        /*
        Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

        

        Example 1:

        Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        Output: 6
        Explanation: [1,1,1,0,0,1,1,1,1,1,1]
        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
        Example 2:

        Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
        Output: 10
        Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
        Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
        

        Constraints:

        1 <= nums.length <= 105
        nums[i] is either 0 or 1.
        0 <= k <= nums.length
        This is very trivial to do by for loop and counting but...
        I want to teach you a template of two pointers that works always

        This is the third problem now you see the magic...



        What is the condition ?? 
        we can flip atmost k 0s -> 1 right...
        so we will keep track of 0s in our window...
        and whenever the count > k we stop eating from head and start shrinking....
        that's all

        Identify the data structure...
        --> count to store the number of zeros 

        Condition...

            eat till (count < k) 
        
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
            while(head + 1 < n && (/*write the condition till we can expand */ arr[head+1]==1 || count < k)) {
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
        //that's all we changed in the code...
         
        System.out.println(ans);
}
}