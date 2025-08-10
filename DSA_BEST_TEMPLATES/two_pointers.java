package DSA_BEST_TEMPLATES;
import java.util.*;

// MAX CONSECUTIVE ONES III LEETCODE 


public class two_pointers {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int  [] arr = new int[n];
        for( int i = 0; i < n ; i++ ) arr[i] = s.nextInt();

        // 1 0 0 1 0 0 1 1 1 0 0 
        /* Given an array of 0s and 1s only find out what is the longest subarray of 1s if we can flip at most
          k elements in an array.
         */


         // TEMPLATE FOR TWO POINTERS
         // define tail and head
         int tail = 0 , head = -1; //always like this

         // IN MOST QUESTIONS WE NEED A DATA STRUCTURE FOR THE WINDOW.. IT CAN BE A MAP OR A SIMPLE COUNTER
          int cnt_zeros = 0;

          int ans = 0; // store the longest answer

          // template starts


          while(tail < n) {
            while(/*condition till which we can expand and element is present */head +1 < n && (arr[head+1] == 1 || cnt_zeros < k )) {
                head++; // eat the element
                //update the data structure
                if(arr[head] == 0) cnt_zeros++;
            }
            //update the answer
            ans = Math.max(ans, head - tail + 1);
            // we got the R for this index

            if(tail > head ) {
                tail++;
                head = tail -1; //resetting back to initial position
            }
            else {
                //update the data structure and then remove 
                if(arr[tail] == 0) {
                    cnt_zeros--;
                }
                tail++;
            }

            // Voila that's it!! just remember this template...
          }
          System.out.println(ans);
    }
    
}
