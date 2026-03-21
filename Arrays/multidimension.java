package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class multidimension {
    int[][] arr = new int[2][];
    //creating multidimensional arrays
    /*
    1 2 3
    4 5
    7 8 9
     */
    static  int [][]  arr2  = {
            {
                1,2,3
            },
            {
                4,5
            },
            {
                7,8,9
            }
    };

    public static void main(String[] args) {

Scanner in = new Scanner(System.in);
        int[][] arr3 = new int[3][3];

        for (int i = 0; i <arr3.length; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                arr3[i][j] = in.nextInt();
            }
        }
//        System.out.println(arr3[0][0]);
        //printing the multi dimensional array
//        for (int i = 0; i < arr3.length; i++) {
//            for (int j = 0; j <arr3[i].length ; j++) {
//                System.out.println(arr3[i][j]);
//            }
//        }
//        for (int i = 0; i < arr3.length ; i++) {
//        System.out.println(Arrays.toString(arr3[i]));
//        }

        //method 2 for printing
//        for (int i = 0; i <arr3.length; i++) {
//            for (int j = 0; j < arr3[i].length; j++) {
//                System.out.print(arr3[i][j] + " ");
//            }
//            System.out.println();
//        }


        //using for each loop for printing the multidimesional array


        //for ( datatype : array )
        for (int[] a : arr3) {
            System.out.println(Arrays.toString(a));
        }

    }
}
