package DSA_BEST_TEMPLATES;
import java.util.*;
public class no_of_subarrays_having_no_distinct_elements_less_k {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n= s.nextInt();
        int k= s.nextInt();
        int [] arr = new int[n];
        for ( int i  =0 ; i < n ; i++ ) arr[i] = s.nextInt();
        /*

        
          Now this is the fourth question we will try with the template...
          /*
            Given an integer array nums and an integer k, return the number of good subarrays of nums.
            A good array is an array where the number of different integers in that array is atmost k.

            For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
            A subarray is a contiguous part of an array.

            Example 1:

            Input: nums = [1,2,1,2,3], k = 2
            Output: 7
            Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
            Example 2:

            Input: nums = [1,2,1,3,4], k = 3
            Output: 3
            Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
            

            Constraints:

            1 <= nums.length <= 2 * 104
            1 <= nums[i], k <= nums.length
           */

           /*
             Identification of 2 ptrs -- ques taking about max/min/count of subarrays related...
             Now, for any L...R 
             let's say no of distinct elements is x
             then no of distinct elements from [L+1....R] will be <=x
             Now we are sure that this is a two pointers problem

            After identification
            1. Think of data structure --- umm distinct elements so map... 
            map<>

            here we didnot use set because the elements might be repeated

            2. Think about till when can we eat...
            -- we can eat till map.size() +1 < k
            now, why i added 1 because for last iteration of the while the element might contribute to one more
            distinct and we want that... if we do set.size() < k then set.size() after iteration could be ==k also
            and we donot wan't that...

            3.think about shrinking...
            -- when we shrink our array we decrement the frequency of the element in the map
            and if the frequency is 0 then we remove it from the map.

            // again the template is on fire....

            */
            solveExactlyEqualK(arr , k , n);
         
    }
    static int solve(int [] arr , int k , int n) {
    
            int tail = 0 , head = -1;

            //ds
            Map<Integer , Integer> mp = new HashMap<>();   
            //ans
            int ans =0;
            //algo start

            while(tail < n) {
                while(head + 1 < n  && (mp.size()<k || (mp.size() == k && mp.containsKey(arr[head+1])))) {
                    head++;
                    mp.put(arr[head] ,mp.getOrDefault(arr[head] ,0) +1);
                }
            
                ans += (head - tail+1);
                
                
                if(tail > head ) {
                    
                    tail++;
                    head = tail-1;
                }
                else {
                    mp.put(arr[tail] , mp.get(arr[tail])-1);
                   
                    if(mp.get(arr[tail]) == 0 ) {
                        mp.remove(arr[tail]);
                    }
                    tail++;
                }

             }

             System.out.println(ans);

             return ans;
    }

    // Follow up what about subarrays exactly equal to k 

        static void solveExactlyEqualK(int [] arr , int k , int n) {
    
            System.out.println(solve(arr, k, n)-solve(arr, k-1, n)); 
    }


}
