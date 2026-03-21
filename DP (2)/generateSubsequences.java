package DP;
import java.util.*;
public class generateSubsequences {
    public static void main(String[] args) {
        int []  arr = {5,3,7,6};
        System.out.println(genSubSeq(arr , arr.length -1 , new ArrayList<>()));

    }


    static List<List<Integer>> genSubSeq(int [] arr , int index , List<Integer> ans){
        if(index <  0) {
            List<List<Integer>> oneSubSequence = new ArrayList<>();
            oneSubSequence.add(ans);
            return oneSubSequence;
        }
        List<List<Integer>> nottake = genSubSeq(arr, index -1 , new ArrayList<>(ans));
        ans.add(arr[index]);
        List<List<Integer>> take= genSubSeq(arr, index -1 , new ArrayList<>(ans));
        nottake.addAll(take);
        return nottake;
    }
}
