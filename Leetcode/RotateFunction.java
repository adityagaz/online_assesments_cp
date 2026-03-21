package Leetcode;
import java.util.*;
public class RotateFunction {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(maxRotate(arr));
    }
    static int maxRotate(int  [] arr) {
        int len = arr.length -1;
        int sum  = 0;
        for( int i : arr) sum += i;
        int rotated_f = 0;
        for( int  i = 0 ; i < arr.length ; i++) {
            rotated_f+= i* arr[i];
        }
        int max= rotated_f;
        int n_r_sum = rotated_f;
        for( int i = arr.length -1 ; i >=1 ; i-- ) {
            n_r_sum -= (arr[i] * len) ;
            n_r_sum += sum - arr[i];
            if(n_r_sum > max) {
                max = n_r_sum;
            }
        }
        return max;
    }
}
