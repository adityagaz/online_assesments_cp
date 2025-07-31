package UNSEEN_QUESTIONS_WHICH_I_FUCKED_UP;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class summation_of_all_min_sums {
    public static void main(String[] args) {
        /*
          Q : given an array tell the sum of all minimum elements in all the subarrays
            [1 ,2,3] = min(1) + min(1,2) + min(1 , 2, 3 ) + min (2) + min (2 , 3)  +min (3) = 1+1+1+2+2+3 =10
            Test case - [3,2,1] --> ans = 9
            Constraints - 
            1<=n<=1e5
            Approach -
            Rather than taking all the subarrays and counting and then traversing them and adding the min elements 
            will take n^2 

            Contribution Technique -
            Rather than thinking the above way we can focus on if we are at index i then till what index 
            left of i and till what index of right of it this number can contribute as minimum.
            If we can find that valid window we can guarantee that this number will be the minimum in all 
            subarrays from left to right.

            so for each index find the next smaller element to the left and next smaller element to the right

            0  1  2 3 4 5 6 
              -1  2 3 4 5 1     for idx = 4 , num = 4
            
            smallest_to_left = 3 at index 3 and smallest to the right = 1 at idx = 6 
            now we have  to count how many subarrays come in this range
            4 comes as min in 
            {4 , 4}
            {4 ,5} 
            total = 2 pairs 4 will be  minimum  = 2 * 4 = 8
            so we have i - sL[i] * sR[i] - i * arr[i] = 4 - 3 * 6 - 4 * 4  = 1 * 2 * 4 = 8;


         */

         Scanner s = new Scanner(System.in);
         int  t= s.nextInt();
         while(t-- > 0) {
            int n = s.nextInt();
            int [] arr = new int[n];
            for (int i =0 ; i < n ; i++ ) arr[i] = s.nextInt();
            int [] sL = new int [n] , sR = new int[n];
            Stack<Integer> st = new Stack<>();
            for( int i = 0 ; i < n ; i++ ) {
                while(!st.isEmpty() && arr[i] < arr[st.peek()] ) {
                    st.pop();
                }
                if(st.isEmpty()) sL[i]=-1;
                else sL[i] = st.peek();
                st.push(i);
            }
            st = new Stack<>();
            for( int i= n-1 ; i >= 0; i--) {
                while(!st.isEmpty() && arr[i] < arr[st.peek()])  {
                    st.pop();
                }
                if(st.isEmpty() ) sR[i] = n;
                else sR[i] = st.peek();
                st.push(i);
            }
            long ans = 0L;
            for( int i = 0; i < n ; i++ ) {
                ans +=(i - sL[i]) *  (sR[i]-i) * arr[i];
            }
            System.out.println(ans);    
         }
    }
}
