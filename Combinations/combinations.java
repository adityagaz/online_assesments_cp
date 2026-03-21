package Combinations;
import java.util.*;
public class combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<Integer> oneComb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int [] arr = new int[n];
        for( int i = 0 ; i < n ; i++) {
            arr[i] = i+1;
        }
        combinations(arr, 0 , k , oneComb , result);
        System.out.println(result);
    }

    static void combinations(int [] arr ,int index , int k , List<Integer> oneComb ,List<List<Integer>> result) {
        //base case
        if(oneComb.size() == k) {
            result.add(oneComb);
            return;
        }
        if(index == arr.length) {
            return;
        }
        oneComb.add(arr[index]);
        combinations(arr ,index +1 , k ,new ArrayList<>(oneComb) ,result);
        oneComb.remove(oneComb.size() -1);
        combinations(arr, index+1 ,k,new ArrayList<>(oneComb) , result);
    }
}
