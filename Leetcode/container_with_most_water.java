package Leetcode;

import java.rmi.MarshalException;

public class container_with_most_water {
    /*
    leetcode
11. Container With Most Water
Medium
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

*/

    public static void main(String[] args) {

        int [] arr  = {1,8,6,2,5,4,8,3,7}; // 49
        int [] arr2 = {1,2,1} ; //2
        int [] arr3 = {1,2} ; //1
       int result =  max_water_trapped(arr3);
        System.out.println(result);
    }
    //this method doesnot pass all the test cases

//    static  int max_water_trapped ( int  []  arr  ){
//         int max_water = 0  ;
//         int max = Integer.MIN_VALUE ;
//         int max_index  = 0 ;
//         for ( int  i = 0  ; i < arr.length ; i++ ){
//             if(arr[i] > max) {
//                 max =arr[i];
//                 max_index = i;
//             }
//         }
//        for (int i = 0; i < arr.length; i++) {
//            int sum = 0 ;
//            sum += Math.min(max , arr[i])  * Math.abs(max_index - i);
//            if (sum > max_water) {
//                max_water = sum ;
//            }
//        }
//        return  max_water;
//    }

    static  int max_water_trapped( int [] arr ){
        int max_water = Integer.MIN_VALUE;
        int i = 0;
        int j = arr.length-1;
        while (i < j ) {
            int trapped_water = Math.min(arr[i],arr[j] ) * Math.abs(j-i);
            if( arr[i] < arr[j]) {
                i++;
            }
            else if( arr[i] > arr[j]) {
                j--;
            }
            else if( arr[i] == arr[j]) {
                i++;j--;
            }
            if( trapped_water >max_water ){
                max_water =trapped_water;
            }
    }
        return max_water;
    }

}
