package DP;
import javax.print.attribute.standard.JobHoldUntil;
import java.util.*;
public class CombinationSumII {
    public static void main(String[] args) {
        int [] arr = {10,1,2,7,6,1,5};
        int target = 8;
        List<Integer> oneComb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

//        System.out.println(combinationSum(arr , target ,arr.length-1));
        combinationSumList(arr , target , 0,oneComb ,result);
        System.out.println(result);


    }
    static int combinationSum (int [] arr , int target , int index ){
        //base case --> if the target is zero return 1
        //else return 0;
        //if target < 0 then no answer from this call
        if(target < 0 || index < 0) {
            return 0;
        }
        if(target == 0) {
            return 1;
        }
        int stay = combinationSum(arr, target - arr[index] , index-1);
        int nppick = combinationSum(arr , target , index -1);
        return stay + nppick;
    }

    static void combinationSumList(int [] arr , int target , int index , List<Integer> oneComb , List<List<Integer>> result ) {
        //base case --> if the target is zero return 1
        //else return 0;
        //if target < 0 then no answer from this call
        if (target == 0) {
            result.add(new ArrayList<>(oneComb));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if ((i == index || arr[i] != arr[i - 1]) && target >= arr[i]) {
                oneComb.add(arr[i]);
                combinationSumList(arr, target-arr[i], i + 1, oneComb, result);
                oneComb.remove(oneComb.size() - 1);
            }
        }
    }
}
