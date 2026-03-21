package LeetcodeEasy;

import java.util.HashMap;
import java.util.Map;

public class sort_array_by_increasing_frequency {

    public static void main (String [] args) {
        int  [] arr = {1,1,2,2,2,3};

        frequency_sort(arr);
    }
    static int [] frequency_sort(int [] arr ) {
        HashMap <Integer , Integer > map = new HashMap<>();
        for( int i = 0 ; i < arr.length ; i++ ) {
            if( map.containsKey(arr[i])) {
                map.put(arr[i] , map.get(arr[i]) +1) ;
            }
            else {
                map.put(arr[i] , 1);
            }
        }
        System.out.println(map);

        // we have to learn to sort using collections
        return new int [] {0,0};
    }

}
