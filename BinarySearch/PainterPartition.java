package BinarySearch;
import java.util.*;
public class PainterPartition {
    public static void main(String[] args) {
        int [] arr = {5, 10, 30, 20, 15};
        int k = 3;
        //how much min time is required to paint all the windows with all the 3 painters
        //binary search on answer (Divide the array into k chunks) sum up all the chunks take the maximum of all chunks
        //minimize the maximum time
        System.out.println(BinSearchOnAnswer(arr , k));
    }

    static  int BinSearchOnAnswer(int [] arr , int k) {
        //make low and high pointers on the possible minimum and maximum value of answers
        //time can be zero seconds and max time can be sum of all the time required for the array
        int lo = 0;
        int hi = 0;
        for( int i : arr) {
            hi += i;
        }
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi-lo) /2;
            if(canComplete(arr , k , mid) == 1 ) {
                ans = mid;
                hi = mid -1;
            }
            else {
                lo = mid +1;
            }
        }
        return ans;
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
