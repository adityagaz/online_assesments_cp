package LeetcodeEasy;
import java.util.*;
public class dissapearedNumbers {

    public static void main (String [] args ) {
        int [] arr ={4,3,2,7,8,2,3,1};
        /*
        bruteforce logic -->
        1. start a counter from 1 .
        whenever you see the count value in the array you increment the count
        3. to handle count variable increasing by duplicate values we can have a check index_count if it is
        already one then we will ignore that count similarly if the loop is traversed  fully and the element
        is not found than we will add to the answer array.
         */
        System.out.println(dissapeared_numbers(arr));
    }

    static List<Integer> dissapeared_numbers ( int  [] arr ) {
        //logic --> we can use cycle sort to do this
        /*
        1. we will replace each element from 1 to n at index 0 to n-1
       2.  if there is a duplicate then we the algorithm will handle it.
        3. finally we will run a for loop that runs through the entire array and checks if the index == the
        element placed at that index . if yes continue else add that index value to the array .
         */

        List<Integer> list = new ArrayList<>();
        int i = 0 ;
        while ( i < arr.length ) {
            int correct = arr[i] -1;
            if( arr[i] != arr[correct] ) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }
        //till here the count sort is implemented
//        System.out.println(Arrays.toString(arr));
        //to check disappeared elements we have the  loop which checks if the index is not same as the
        //element stored upon it
        for( int j =0; j < arr.length ; j++ ){
            if(arr[j] != j+1 ) {
                list.add(j+1);
            }
        }
        return list;
    }
}
