package SubArrays;
import java.util.*;
public class GenerateSubarrays {

    public static void main (String [] args) {
        int [] arr = {1,2,1,2};

        System.out.println(genSubArrays(arr));
    }
    static List<List<Integer>> genSubArrays(int [] arr ){
        List<List<Integer>> result = new ArrayList<>();
        for( int window_size = 1 ; window_size <= arr.length ; window_size++) {
            for(int i = 0 ; i <= arr.length - window_size ; i++) {
                List<Integer> temp = new ArrayList<>();
                for( int j = i ; j < i+window_size ; j++ ) {
                    temp.add(arr[j]);
                }
                result.add(temp);
            }
        }
        return result;
    }
}
