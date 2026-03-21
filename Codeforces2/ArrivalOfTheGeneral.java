package Codeforces;
import java.util.*;
public class ArrivalOfTheGeneral {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int [] arr = new int[len];
        for( int i=0 ; i < arr.length ; i++ ){
            arr[i] = s.nextInt();
        }
        System.out.println(noOfSeconds(arr , len));

    }

    static int noOfSeconds(int [] arr , int len) {
        int min_index = 0;
        int max_index  = 0;
        int min = arr[0];
        int max = arr[0];
        for( int i  = 0 ; i < arr.length ; i++){
            if(arr[i] <= min) {
                min= arr[i];
                min_index = i;
            }
        }
        for(int i = min_index ; i < arr.length -1 ; i++) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        for( int i = 0 ; i < arr.length ; i++ ){
            if(arr[i] > max) {
                max = arr[i];
                max_index = i;
            }
        }
        return (arr.length - 1 -min_index ) + max_index;
    }
}
