package LeetcodeHard;

import java.util.Arrays;

public class sliding_window_maximum {

    public static void main (String [] args ) {
        int [] arr = {-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7};
        int k = 7;
//        System.out.println(Arrays.toString(max_sliding_window(arr , k)));
    }

    //this solution is not bad bro!! it is good that you came up with it
    // but this is taking too much time
    //you solved it without watching any hint
//
//    static int [] max_sliding_window(int [] arr , int k ) {
//        int [] result = new int[arr.length - k +1];
//        if(k ==1  ) return arr;
//        int max = Integer.MIN_VALUE;
//        int max_index = -1;
//        for (int i =0 ; i < k ; i++ ){
//            //find the first maximum
//            if(arr[i] > max) {
//                max = arr[i];
//                max_index = i;
//            }
//        }
//        result[0] = max;
//        int j = k;
//        int i = 1;
//        while(j < arr.length) {
//            if(arr[j]> max) {
//                max = arr[j++];
//                result[i] = max;
//                max_index = j;
//                i++;
//            }
//            else {
//                if(!(max_index > i)) {
//                    int temp_m = arr[i];
//                    //then you need to find the max
//                    for(int l = i ; l <= j ;l++) {
//                        if(arr[l] >temp_m) temp_m =arr[l];
//                    }
//                    max = temp_m;
//                    result[i] = max;
//                    max_index = i;
//                }
//                else {
//                    result[i] = max;
//                }
//                i++;
//                j++;
//            }
//
//        }
//return result;
//    }
}
