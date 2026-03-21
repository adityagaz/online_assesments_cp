package prefixsums;
import java.util.*;
public class removeSmallestToMakeDivisible {

    public static void main (String [] args){

        int [] arr = {3,1,4,2};
        int  p = 6;

    }
    static int minSubarray(int[] nums, int p) {
//modulo the array sum by p
//now you get the culprit remainder value that is preventing the sum of
//whole array to be divisible by p
// we already know how to check if a subarray sum is equal to a particular value or not
//so now we will check every subarray sum and compare their lengths
//in O(n) time and check which is the smallest and return the length
        int arrayTotal = 0;
        for( int i : nums) {
            arrayTotal += i;
        }

        if(arrayTotal %p == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;
        int sum= 0 ;
        for( int i = 0 ; i < nums.length; i++) {
            sum+= nums[i];
            if(map.containsKey(sum -p)) {
                int length = i - map.get(sum - p);
                result = Math.min(result , length);
                System.out.println(length +" "+ result);
            }
            map.put(sum , i);
        }
        System.out.println(map);
        return result;
    }
}
