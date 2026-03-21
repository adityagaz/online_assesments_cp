package Recursion;
import java.util.*;
public class goAtoB_in_a2D_MATRIX {
    public static void main (String [] args) {
        /*

        [

        [1,2,3]
        [4,5,6]
        [7,8,9]

        i want to explore all paths
        so basically a path could be 1-> 2-> 3-> 6-> 9
        or a path could be 1-> 2-> 5 ->8 ->9
        so .. similarly i want to print all the paths
        and so my approach is you have two choices at each step
        1. either to go right or down so we will have two recursive calls at each step and
        we will print the visited node and if we reached the final node we add a new line and return.

        ]
         */
        int [][] matrix = new int[3][3];
        int count = 1 ;
       for( int i = 0 ; i < matrix.length ; i++ ){
           for(int j =0 ; j < matrix[i].length ; j++){
               matrix[i][j] = count++;
           }
       }
        ArrayList<Integer> list = new ArrayList<>();

       //choose any starting position

       printPaths(matrix  , 0 , 0 , list);

    }

    static void printPaths(int [][] matrix , int i , int j , ArrayList<Integer> list) {
        list.add(matrix[i][j]);
//        System.out.print(" " + matrix[i][j]);
        if(i == matrix.length-1 && j == matrix[0].length -1 ) {
            //add the ending position
            System.out.println(list);
            //print a new line
            System.out.println();

            return;

        }

        if(i == matrix.length -1) {

            list.remove(list.size()-1);
            list.add(matrix[i][j]);
            printPaths(matrix , i , j+1 , list);
            list.remove(list.size()-1);

            return;

        }
        else if( j == matrix[0].length -1) {

            list.remove(list.size()-1);
            list.add(matrix[i][j]);
            printPaths(matrix , i+1 , j , list);
            list.remove(list.size()-1);

            return;

        }

        printPaths(matrix , i+1, j, list);
        list.remove(list.size()-1);
        printPaths(matrix , i , j+1 , list);
        list.remove(list.size()-1);
    }
}
//bro believe me you are getting good at recursion.. you came up with this solution by your own
