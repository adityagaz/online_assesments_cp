package LeetcodeEasy;
import java.util.*;
public class degree_of_an_array {
    //https://leetcode.com/problems/degree-of-an-array/description/
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(min_degree(arr));

    }


    //works but time limit exceeded here
//    //try to optimise the solution
//    static int helper( int [] arr ) {
//        if(arr.length == 1) return arr[0];
//        int start = 0;
//        int end = arr.length -1;
//
//        HashMap<Integer , Integer > map  = new HashMap<>();
//
//        for( int i  = start ; i <= end ; i++ ){
//            map.put(arr[i], map.getOrDefault(arr[i] , 0) +1);
//        }
//        int max = 0;
//        for( int i : map.values() ) {
//            if( max < i) {
//                max =  i;
//            }
//        }
//        while(start <= end ){
//            if(isStillMax(arr, max , start , end )) {
//                end--;
//            }
//            else {
//                end++;
//                break;
//            }
//        }
//        while(start <= end ) {
//            if(isStillMax(arr, max , start ,end )) {
//                start++;
//            }
//            else{
//                start--;
//                break;
//            }
//        }
//        return end-start+1;
//
//    }
//    static boolean isStillMax(int [] arr , int maxi  , int start , int end  ) {
//        HashMap<Integer , Integer > map  = new HashMap<>();
//
//        for( int i  = start ; i <= end ; i++ ){
//            map.put(arr[i], map.getOrDefault(arr[i] , 0) +1);
//        }
//        int max = 0;
//        for( int i : map.values() ) {
//            if( max < i) {
//                max =  i;
//            }
//        }
//        return max == maxi ? true : false;
//    }
//}


    static int min_degree(int[] arr) {
        if(arr.length == 1) return 1;
        // we will create three hashmaps one to store max count , to store first occurrence , to store last occurrence
        HashMap<Integer , Integer > freq = new HashMap<>();
        HashMap<Integer , Integer> first_occ = new HashMap<>();
        HashMap<Integer , Integer> last_occ = new HashMap<>();

        int freq_max = 0;
        for( int i = 0 ; i < arr.length  ; i++ ) {
            freq.put(arr[i] , freq.getOrDefault(arr[i] , 0) +1);
            freq_max = Math.max(freq_max , freq.get(arr[i])); // found the max frequency

            if(!first_occ.containsKey(arr[i])) {
                first_occ.put(arr[i] , i);
                //put the first occurence index as i if the elements is not encountered yet
            }
            last_occ.put(arr[i] , i);
        }

        //now we have the max frequency and the first occ and last occ of all the elements
        //we can run a loop to check if the frequency of that element is maximum and if the last_occ - first_occ +1 is minimum than other max freq elements
        //if yes then return the min of all those.
        int minimum_length = arr.length ;
        for( int i = 0 ; i < arr.length ; i++) {
            if(freq.get(arr[i]) == freq_max ) {
                minimum_length = Math.min(minimum_length , (last_occ.get(arr[i]) - first_occ.get(arr[i]) +1));
            }
        }
        return minimum_length;
    }

}
