package Arrays;

import java.util.Arrays;

public class arrayReverse {

    public static void main(String[] args) {
        int [] arr = {1, 2,3, 4, 23,444} ;
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    static int reverse(int [] arr)  {
        int i = 0;
        int j = arr.length -1 ;
        //edge cases
        if
        (arr == null ) {
            return -1;
        }
        if (arr.length == 0) {
            return -1;
        }

        //main logic

        while(i< j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp ;
        i++;
        j--;
        }
        return 0;
    }

}


