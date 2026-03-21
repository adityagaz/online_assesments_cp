package Recursion;

import java.sql.SQLOutput;

public class bins_using_recursion {

    public static void main(String[] args) {
        int [] arr =   { 1,2,3,4,5,6,7,8,9,10};
        System.out.println(BinS(arr, 0 , arr.length -1 , 59));
    }

    static int BinS(int [] arr , int start , int end  , int target) {
        //the base case for both sides
        if(start > end) {
            return -1;
        }
        int mid = start +(end - start) /2;
        if( arr[mid] == target ) {
            return mid;
        }
        else if( arr[mid] > target  ) {
            end= mid -1;
        }
        else{
             start = mid +1;
        }

        return BinS(arr, start , end , target);
    }

}
