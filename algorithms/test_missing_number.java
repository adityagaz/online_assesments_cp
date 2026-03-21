package algorithms;
import java.util.*;
public class test_missing_number {
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
    public static void main (String [] args  ) {
        int [] arr = {4,3,2,7,8,2,3,1};
        dissapear(arr);
    }
    static  List<Integer> dissapear ( int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[Math.abs(arr[i]) - 1] > 0) {
                arr[Math.abs(arr[i])-1] *= -1;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                list.add(i + 1);
            }
        }
        System.out.println(list);
        return list;
    }
}


