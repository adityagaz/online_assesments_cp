package DSA_BEST_TEMPLATES;
import java.util.*;

public class max_consectutive_ones_i {
    public static void main(String[] args) {
        

        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int [] arr = new int[n];
        for ( int i  =0 ; i < n ; i++ ) arr[i] = s.nextInt();


        /*
        Problem -- 
        Given a binary array nums, return the maximum number of consecutive 1's in the array.
        Example 1:

        Input: nums = [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
        Example 2:

        Input: nums = [1,0,1,1,0,1]
        Output: 2

        This is very trivial to do by for loop and counting but...I want to teach you a template of two pointers that works always


         */

        //declaration and assignment
        int tail = 0 , head = -1 ;
        // datastructure
        int count = 0;
        // answer
        int ans = 0;

        // start the loop

        while(tail < n) {
            while(head + 1 < n && (/*write the condition till we can expand */ arr[head+1]==1)) {
                head++;
                count++;
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
                if(arr[tail]==1) {
                    count--;
                }
                tail++;
            }
        }

        //answer will be ready always here to return 
        System.out.println(ans);
    }
}
