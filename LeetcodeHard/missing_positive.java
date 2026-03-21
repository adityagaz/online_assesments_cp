package LeetcodeHard;
import java.util.*;
public class missing_positive {
    public static void main (String [] args ) {
        int [] arr = {1};
        int result = missing_positive(arr);
        System.out.println(result);
    }


    static int missing_positive (int [] arr) {
//
/*

 */
        int i = 0 ;
        while( i < arr.length ) {
            int correct = arr[i] -1;
            if(arr[i] < 0) {
                i++;
            }
            else if (arr[i] <= arr.length && arr[i] > 0 && arr[i] != arr[correct] ) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }

        //check which index has the incorrect input
        //the index which has the wrong value sitting on it is the answer index , i mean the expected answer is missing
        //for example smallest integer is 1 so if the integer at index 0 anything but 1 after sorting
        // then we are sure that it will not exist in the array any further because the array is sorted
        //also we ignored -ve values while sorting that so all we could find further is -ve or greater elements than one
        //so correct value at index 0 will be 1 and that is missing so 1 is the answer.
        //


        for (int j =0 ; j < arr.length ; j++) {
            if (arr[j] != j+1) {
                return j+1;
            }
        }
        return arr.length +1;
    }
}
