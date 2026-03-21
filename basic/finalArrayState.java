package basic;
import java.util.*;
import java.lang.reflect.Array;

public class finalArrayState {

    public static void main(String[] args) {
        int [] nums = {2,1,3,5,6};
        int multiplier = 2;
        int k = 5;

//        System.out.println(Arrays.toString(getFinalState( nums, k,multiplier)));
        System.out.println( Arrays.toString(getFstate( nums , k ,multiplier)));
    }
    static public int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k > 0) {
            doOperation(nums , k , multiplier);
            k--;
        }
        return nums;
    }
    static void doOperation(int []  nums , int k , int multiplier) {
        int minIndex = 0;
        int min = nums[0];
        for( int i  = 0  ; i < nums.length ; i++ ){
            if(nums[i] < min ) {
                min = nums[i];
                minIndex = i;
            }
        }
        nums[minIndex] *= multiplier;
    }

    //the above solution is O(n^2)
    //we can use priority queue (min-heap)  and hashmap to do it in O(n)

    static int [] getFstate(int [] nums , int k , int multiplier) {
        int [] result = new int[nums.length];
        PriorityQueue<int []> q = new PriorityQueue<>((a , b) -> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            else {
                return a[0] -b[0];
            }
        });
        for( int i= 0 ; i < nums.length ;i++ ){
           int [] pair = new int[2];
            pair[0] = nums[i];
            pair[1] = i;
            q.add(pair);
        }
        while(k > 0) {
            int [] arr = q.poll();
            arr[0] *= multiplier;
            q.add(arr);
            k--;
        }
        while(!q.isEmpty()) {
            int idx = q.peek()[1];
            result[idx] = q.poll()[0];
        }
        return result;
     }

}
