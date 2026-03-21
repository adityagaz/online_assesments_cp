package Leetcode;

import java.util.Arrays;
import java.util.Map;
public class plus_one {
    public static void main(String[] args) {
        int [] arr = {9};
        System.out.println(Arrays.toString(plus_one_array(arr)));
    }
    static int [] plus_one_array( int [] arr) {
        int num = 0;
        for (int i = arr.length - 1 ; i >=0 ; i-- ) {
            if(arr[i] <9) {
                arr[i]++;
                return arr;
            }
            arr[i] =0;
        }
        int [] plus_one  = new int[arr.length+1];
        plus_one[0] = 1;
    return  plus_one;
    }
}
