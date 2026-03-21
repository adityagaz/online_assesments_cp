package DP;
import  java.util.*;
public class CombinationSum {
    public static void main(String[] args) {
        int [] arr = {2,3,6,7};
        int target = 7;
        List<Integer> oneComb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(combinationSum(arr , target  , arr.length -1));
        combinationSumList(arr , target , arr.length-1,oneComb ,result);
        System.out.println(result);
    }

    static int combinationSum (int [] arr , int target , int index ){
        //base case --> if the target is zero return 1
        //else return 0;
        //if target < 0 then no answer from this call
        if(target == 0) {
            return 1;
        }
        if(target < 0 || index < 0) {
            return 0;
        }

        int stay = combinationSum(arr, target - arr[index] , index);
        int nppick = combinationSum(arr , target , index -1);
        return stay + nppick;
    }

    static void combinationSumList(int [] arr , int target , int index , List<Integer> oneComb , List<List<Integer>> result ){
        //base case --> if the target is zero return 1
        //else return 0;
        //if target < 0 then no answer from this call
        if(target < 0 || index < 0) {
            return;
        }
        if(target == 0) {
            result.add(oneComb);
            return ;
        }
        combinationSumList(arr , target , index -1 , new ArrayList<>(oneComb) , result);//nopick and move
        oneComb.add(arr[index]);
        combinationSumList(arr, target - arr[index] , index ,new ArrayList<>(oneComb) , result); // pick and stay
    }

}
