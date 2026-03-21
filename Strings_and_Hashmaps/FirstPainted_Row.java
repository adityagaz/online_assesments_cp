package Strings_and_Hashmaps;
import java.lang.reflect.Array;
import java.util.*;

public class FirstPainted_Row {

    public static void main(String[] args) {
        int [] arr =  {6,2,3,1,4,5};
        int [][] mat = {
                {5,1},{2,4},{6,3}
        };

        System.out.println(firstCompleteIndex(arr , mat));
    }

    static  int firstCompleteIndex(int [] arr , int [][] mat) {

        HashMap<Integer , int [] > map = new HashMap<>();
        //fill all the values
        for( int i  = 0 ; i < mat.length ; i++ ){
            for( int j  =0 ; j < mat[i].length ; j++ ){
                map.put(mat[i][j] , new int [] { i , j});
            }
        }
        int  [] row_Index = new int[mat.length];
        int  [] col_Index = new int[mat[0].length];

        for( int i =0; i <row_Index.length ; i++) {
            row_Index[i] = mat[0].length;
        }
        for( int i = 0 ; i < col_Index.length ; i++ ){
            col_Index[i] = mat.length;
        }
        for( int i  = 0  ; i < arr.length ; i++ ){
            //get the coordinates from the map
             int [] coord = map.get(arr[i]);
             int row = coord[0];
             int col = coord[1];
             row_Index[row]--;
             col_Index[col]--;
            if(row_Index[row] == 0 || col_Index[col] == 0) {
                return i;
            }
        }
        return -1;
    }

}
