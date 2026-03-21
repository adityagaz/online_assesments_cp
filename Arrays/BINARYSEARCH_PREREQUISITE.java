package Arrays;
import java.util.*;
public class BINARYSEARCH_PREREQUISITE {

    public static void main(String[] args) {
        //given an integer k  painters , we have to determine that if  we can paint the whole array in t seconds
        int [] arr = {1,3,8,7,2,5};
        int k = 3;
        int n = 12;
        System.out.println(canComplete(arr , k , n));
    }

    static  int canComplete(int  [] arr , int k , int n ){
        int sum = 0;
        int i = 0;
        while ( k >=1 && i < arr.length) {
            if(arr[i] + sum <= n) {
                sum += arr[i++];
            }
            else {
                k--;
                sum = 0;
            }
        }
        if(i >= arr.length) return 1 ; else return 0;
    }
}
