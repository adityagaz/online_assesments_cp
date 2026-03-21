package Sorting;
import java.util.*;
public class mergeSOrt {

    public static void main(String [] args) {
        int [] arr = {3,-1,0,-23,11,99,2};
        int start = 0; int end = arr.length -1;
        //apply merge sort
        //write it own your own
        mergesort(arr,start , end);


        System.out.println(Arrays.toString(arr));


    }

    static void mergesort(int [] arr , int start , int end ) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) /2;


            mergesort(arr , start , mid);
            mergesort(arr , mid+1 , end);
            merge(arr, start, mid , end);


    }

    static void merge (int [] arr ,int start , int mid , int end   ) {
        int left_array_size = mid - start +1;
        int right_array_size = end - mid;

        int [] temp_arr = new int[left_array_size + right_array_size];


        int i= start ; int j = mid+1;
        int index = 0; //to store elements in temp array

        while (i <=mid && j<=end) {
            if( arr[i] <= arr[j]) {
                temp_arr[index++] = arr[i++];
            }
            else {
                temp_arr[index++ ] = arr[j++];
            }
        }


        while (i <= mid)  {
            temp_arr[index++] = arr[i++];
        }
        while( j <= end) {
            temp_arr[index++ ] = arr[j++];
        }

        for( int l =0 ; l < temp_arr.length ; l++ ) {
            arr[start+l] = temp_arr[l];
        }
    }

    //the below approach was a little bit using extra unnecessary memory so i wrote the above approach

//    static void merge(int [] arr , int start , int mid ,int end) {
//        int l = mid- start +1; //length of the left array
//        int r = end - mid; //length of the right array
//        int [] left_arr  = new int[l];
//        int [] right_arr = new int[r];
//
//        int index_l =0; int index_r = 0;
//        for(int item =start ; item < l +start ; item++ ){
//            left_arr[index_l++] = arr[item];
//        }
//        for(int it = mid+1 ; it<=end ; it++ ){
//            right_arr[index_r++] = arr[it];
//        }
//        int [] temp_arr = new int[l+r];
//        int index = 0; //an index value to keep track where will i add the element in the temp array.
//
//
//        int i =0; //start pointer on left sub array
//        int j = 0  ; //start pointer on right sub array
//        while(i < l && j< r ){
//            if(left_arr[i] <= right_arr[j]) {
//                temp_arr[index++] = left_arr[i];
//                i++;
//            }
//            else {
//                //it means the element in the right array is greater.
//                temp_arr[index++] = right_arr[j];
//                j++;
//            }
//        }
//        //uptil this point i first thought we are done but there is a catch
//        //...what if the array sizes are unequal then we wound end up having elements
//        //that are still left in the bigger array (can be right or the left one whichever is longer)
//        //so we need to check both for remaining elements and then we can copy the temp to arr
//        while(i<l) {
//            temp_arr[index++] = left_arr[i];
//            i++;
//        }
//        while (j<r) {
//            temp_arr[index++] = right_arr[j];
//            j++;
//        }
//        int tem =0;
//        for( int k = start ; k < temp_arr.length + start ; k++ ){
//            arr[k] = temp_arr[tem++];
//        }
//
//    }

}
