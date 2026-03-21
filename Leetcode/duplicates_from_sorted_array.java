package Leetcode;

import java.util.Arrays;

public class duplicates_from_sorted_array {
    public static void main(String[] args) {
        int arr [] = {1,2};
        remove_duplicates(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void remove_duplicates(int [] arr) {
        int start = arr[0];
        int end = start+1;
        int index =1 ;
        while (end < arr.length) {
             if(arr[end] !=arr[start]) {
                 arr[index] = arr[end];
                 index++;
                 start = end;
             }
            end++;

        }


    }

}
