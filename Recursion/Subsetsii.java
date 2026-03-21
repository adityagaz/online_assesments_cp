package Recursion;

import java.util.*;

public class Subsetsii {

    public static void main (String [] args) {
        int [] arr =  {1,2,1};
        //print all subsets [[1] , [2] , [3]  , [1,2]  , [2,3] , [1,3] , [1,2,3]]

        //just adds a empty list to the bigger list
        // output = [ [ ] ]
        List<List<Integer>> ans = genSubBottomUp_no_dup(arr);
        System.out.println(ans);
    }

    static List<List<Integer>> genSubBottomUp_no_dup(int [] arr) {
        Arrays.sort(arr);
        List<List<Integer>> bahar= new ArrayList<>();
        bahar.add(new ArrayList<>()); //add an empty list

        int start = 0;
        int end  =0 ;

        for(int i  =0 ; i < arr.length ; i++ ) {
            start = 0;
            int size = bahar.size();
            if(i > 0 && arr[i] == arr[i-1]) {
                start = end +1;
            }
            end = bahar.size() -1;
            for(int j = start ; j < size ; j++ ){
                List<Integer> andar = new ArrayList<>(bahar.get(j));
                andar.add(arr[i]);
                bahar.add(andar);
            }
        }
        bahar.remove(0); // remove the empty list

        return bahar;
    }


}
