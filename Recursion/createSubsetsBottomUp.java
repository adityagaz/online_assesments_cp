package Recursion;
import java.util.*;
public class createSubsetsBottomUp {

    public static void main (String [] args) {
        int [] arr =  {1,2,3};
        //print all subsets [[1] , [2] , [3]  , [1,2]  , [2,3] , [1,3] , [1,2,3]]

         //just adds a empty list to the bigger list
        // output = [ [ ] ]
        List<List<Integer>> ans = genSubBottomUp(arr);


        System.out.println(ans);
    }

    static List<List<Integer>> genSubBottomUp (int [] arr) {
        List<List<Integer>> bahar= new ArrayList<>();
        bahar.add(new ArrayList<>()); //add an empty list

        for(int num : arr) {
            int size = bahar.size();
            for(int i = 0 ; i < size ; i++ ){
                List<Integer> andar = new ArrayList<>(bahar.get(i));
                andar.add(num);
                bahar.add(andar);
            }

        }
        bahar.remove(0); // remove the empty list

        return bahar;
    }
 }
