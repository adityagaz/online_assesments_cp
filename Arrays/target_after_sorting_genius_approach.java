package Arrays;

import java.util.ArrayList;
import java.util.List;

public class target_after_sorting_genius_approach {

    public static void main(String[] args) {
            int [] arr = {1,2,5,2,3};
            int target = 2;
        System.out.println(targetIndices(arr, 2));
    }
    static List<Integer> targetIndices(int[] nums, int target ) {
        int smaller  = 0 ; //denotes no of smaller elements than target
        int larger = 0; // denotes no of larger elements than target
        //logic  ---> without sorting the array we can know that our target element appears at the index
        //which is equal to the no of smaller elements and ends at smaller + larger or total - larger -1;
        for( int i  = 0 ; i < nums.length ; i++ ){
            if (nums[i] < target ) {
                smaller++;
            }
            else if (nums[i] > target ) {
                larger++;
            }
        }

        List<Integer> list  = new ArrayList<>();
        for  ( int i  = smaller ; i <= nums.length - larger -1 ;i++ ){
            list.add(i);
        }
        return list;
    }
}
