package Arrays;

import java.util.ArrayList;
import java.util.List;

public class kth_rotation {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(rotated_by_kth_places(list));
    }

    static int rotated_by_kth_places(List<Integer> arr) {
        int start  = 0 ;
        int end = arr.size() -1;
        while  ( start < end ) {
            int mid = start + ( end - start ) /2;
            if (arr.get(mid)> arr.get(end) ) {
                start = mid +1;
            }
            else {
                end = mid;
            }


        }

        //at final point start wiil be equal to mid and equal to the index of lowest element
        // in the array

        return start;
    }

}


