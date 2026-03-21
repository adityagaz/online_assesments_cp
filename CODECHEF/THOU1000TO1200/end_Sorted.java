package CODECHEF.THOU1000TO1200;
import java.util.*;
import java.lang.*;
import java.io.*;

public class end_Sorted {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int len = s.nextInt();
            int [] arr = new int[len];
            for( int i = 0 ; i < len ; i++  ) {
                arr[i] = s.nextInt();
            }
            System.out.println(solve(arr , len ));
        }
    }

    static int solve(int [] arr , int len) {
        int min_moves = 0;

        if(arr[0] == 1 && arr[arr.length -1 ] == len) {
            return 0;
        }
        else if (arr[arr.length - 1] == len ) {
            //last term is at place
            int first_index = -1;
            for ( int i = 0 ; i < len ; i++ ) {
                if( arr[i] == 1) {
                    first_index = i;
                    break;
                }
            }
            min_moves += first_index;
            return min_moves;
        }
        else if (arr[0] == 1) {
            //last is not in place
            int last_index = -1;
            for( int i = 0 ;i < len ; i++ ) {
                if(arr[i] == len) {
                    last_index = i;
                    break;
                }
            }
            min_moves += len - last_index -1;
        }
        else {
            //both are not in place
            //find the first index
            int first_index = 0;
            int last_index = 0;
            for( int i = 0 ; i <len ; i++ ) {
                if(arr[i] == 1) {
                    first_index = i;
                    break;
                }

            }
            min_moves += first_index;

            for ( int i = first_index ; i >= 1 ; i-- ) {
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
            for( int i = 0 ; i <len ; i++ ) {
                if(arr[i] == len) {
                    last_index = i;
                    break;
                }
            }

            for( int i = last_index ; i < len-1; i++) {
                int temp = arr[i] ;
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            min_moves += len - last_index -1;
        }
        return min_moves;
    }
}



