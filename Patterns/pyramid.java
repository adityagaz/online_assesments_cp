package Patterns;
import java.util.*;
import java.util.Arrays;

public class pyramid {
    public static void main  (String [] args) {

        /*

         */

        int n   =5;
        for( int i = 0 ; i < n ; i++ ) {
            //three lines done
            for( int j = n-1 ; j > i ; j--  ) {
                System.out.print(" ");
            }

            for( int j = 0  ; j <= i ; j++ ) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }

}
