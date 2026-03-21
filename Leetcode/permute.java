package Leetcode;
import java.util.*;
public class permute {
    public static void main(String []  args) {

        int [] nums = {1,2,3};
        System.out.println(helper(nums));

    }


    static List<List<Integer>> helper(int [] arr) {
        List<List<Integer>> list = permutation(arr , new ArrayList<>() , 0);
        return list;
    }
   static  List<List<Integer>> permutation(int [] arr , List<Integer> temp , int i ) {

        if(i == arr.length ) {
            List<Integer> t = new ArrayList<>(temp);
            List<List<Integer>> l = new ArrayList<>();
            l.add(t);
            return l;
        }
        List<List<Integer>> ans = new ArrayList<>();

        for(int j  =0 ; j <=i  ; j++ )
        {
            temp.add(j , arr[i]);
            List<List<Integer>> one = permutation(arr ,temp , i+1);
            temp.remove(j);
            ans.addAll(one);

        }

        return ans;
   }
}
