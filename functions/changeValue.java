package functions;

import java.util.Arrays;

public class changeValue {

    public static void main(String[] args) {
        int [] arr = {1 , 2 ,3};
        changearr(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void changearr(int [] arr) {
        arr[0] = 99;
        //here the original array is being changed because we are modifying the array
        //rather than creating a new object

    }


}
