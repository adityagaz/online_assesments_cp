package Leetcode;

import java.util.*;

public class target_after_sorting {

    public static void main ( String [] args) {
        HashSet<Integer> set = new HashSet<>();
        int [] arr = {75,99,19,93,87,68,12,18,48,83,24,50,16,53,36,16,80,68,46,13,53,100,50,49,77,52,34,42,38,98,73,11,13,61,72,8,11,67,98,24,23,71,47,6,5,7,97,86,25,82,11,15,26,97,69,6,30,77,98,44,32,39,71,47,64,78,6,61,72,75};
        boolean leftBias = false;
        System.out.println(BinSearch(arr, 98 , leftBias , set));
        System.out.println(BinSearch(arr, 98 , true , set));
        HashSet<Integer> temp = BinSearch(arr, 98, true , set);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
//in the leetcode problem it is given that there are not more than 100 elements in the array and also this binary search approach
        //doesnot guarantee if

    }

    static HashSet<Integer> BinSearch(int []  arr , int target  , boolean bias , HashSet<Integer> set) {
        Arrays.sort(arr);
        int start = 0 ;
        int end = arr.length -1;
        while ( start  <= end ) {
            int mid = start + (end - start) /2;

            if(target < arr[mid] ) {
                end  = mid -1;
            }
            else if(target > arr[mid]) start = mid +1;
            else {
                set.add(mid);
                if(arr[start] == target ) set.add(start);
                if(arr[end] == target) set.add(end);
                if(!bias) {
                    start = mid + 1;
                }
                else {
                    end = mid-1;
                }
            }
        }
        return set;
    }
}
