package sliding_window;
import java.util.*;
public class max_sum_distinct_k {
    public static void main(String[] args) {
        int [] arr = {5,3,3,1,1};
        System.out.println(maximumSubarraySum(arr , 3));
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        if(nums.length  < k) {
            return 0;
        }
        int max_sum = 0;
        int i = 0 ; int j =0;
        int sum = 0;
        while( j < nums.length) {
            sum+=nums[j];
            mp.put(nums[j] , mp.getOrDefault(nums[j] , 0) +1 );
            if(j-i+1 < k) {
                //increase the window --aditya verma sliding window vid 3
                j++;
            }
            else if(j-i+1 == k) {
                if(mp.size() == k) {
                    max_sum = Math.max(max_sum ,  sum);
                }
                sum -= nums[i];
                   if(mp.get(nums[i]) == 1) {
                       mp.remove(nums[i]);
                   }
                   else {
                       mp.put(nums[i] , mp.get(nums[i]) -1);
                   }
                i++;
                j++;
            }
        }
        return max_sum;
    }
}
