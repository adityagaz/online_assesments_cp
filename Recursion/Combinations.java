package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main (String [] args) {
        int [] arr = {2,2,2};
        List<Integer> list = new ArrayList<>();

//        System.out.println(subarrays(arr , 0 , list));


        //remove the null array
        List<List<Integer>> result = subarrays(arr , 0 , list);
        result.remove(result.size() -1);
        System.out.println(result);
    }

    static List<List<Integer>> subarrays(int [] arr , int index , List<Integer> curr) {
        if(index == arr.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(curr);
            return list;
        }
        List<Integer> copy_curr = new ArrayList<>(curr);
        curr.add(arr[index]);
        List<List<Integer>> take = subarrays(arr, index +1 , curr);
        List<List<Integer>> not_take = subarrays(arr , index +1 , copy_curr);
        take.addAll(not_take);
        return take;
    }
}
