package Backtracking;
import java.util.*;
public class NQueens {

    public static void main (String[] args) {

        int n = 4;
        boolean [][] board = new boolean [n][n]; // false initially

        System.out.println(queens_arrayList(board , 0 ));
    }

    static int queens(boolean [][] board , int  row) {
        if(row == board.length) {
            display(board);
            System.out.println();
            return 1;
        }

        int count = 0 ;

        for( int col = 0 ; col < board.length ; col++) {
            if(isSafe(board , row, col)) {
                board[row][col] = true;
                count += queens(board , row+1);
                board[row][col] = false;
            }

        }

        return count;
    }

    static boolean isSafe(boolean [][] board , int row , int column ) {

        //check the top

        for(int i = 0 ; i < row ; i++  ) {
            if(board[i][column]) {
                return false;
            }
        }
        //check the left diagonal

        int maxLeft = Math.min(row , column );
        for(int i = 1; i <= maxLeft  ; i++ ){
            if(board[row-i][column -i ]) {
                return false;
            }
        }

        //check the right diagonal (distance of the column to the wall)
        int maxRight = Math.min(row , board.length - column - 1);
        for(int i = 1 ; i  <= maxRight ; i ++ ) {
            if(board[row-i][column + i]){
                return false;
            }
        }
    return true;

    }

    static void display(boolean [][] board){
        for(boolean [] arr : board) {
            for( boolean elem : arr) {
                if(elem) {
                    System.out.print("Q");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println(); //new line
        }
     }



     //array list return method

    static List<List<String>> queens_arrayList(boolean [][] board , int  row) {
        if(row == board.length) {
            List<List<String>> list = new ArrayList<>();
            List<String> temp = new ArrayList<>();

            for(boolean [] arr  : board) {
                StringBuilder str = new StringBuilder();
                for(boolean elem : arr){
                    if(elem) {
                        str.append("Q");
                    }
                    else {
                        str.append(".");
                    }
                }
                temp.add(str.toString());
            }
            list.add(temp);

            return list;
        }

        List<List<String>> list = new ArrayList<>();

        for( int col = 0 ; col < board.length ; col++) {
            if(isSafe(board , row, col)) {
                board[row][col] = true;
                list.addAll(queens_arrayList(board , row+1));
                board[row][col] = false;
            }

        }

        return list;
    }

}
