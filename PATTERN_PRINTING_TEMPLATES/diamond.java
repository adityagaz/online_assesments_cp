package PATTERN_PRINTING_TEMPLATES;

import java.util.Scanner;

public class diamond {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        for( int i = 0; i < r ; i++ ) {
            for( int j = 0 ; j < c ; j++ ) {
                printa(r, c, i, j);
                
            }
            System.out.println();
        }

    }



    //  *********
    //   *******
    //    *****
    //     ***
    //      *
        // line1 - i==j+c  (I==J)
        // line2 - i+j==8
        /*
          imagine y = mx + c
          i = y , j = x 
          put a point on canvas and calculate c
         */

    static void print(int r, int c , int i , int j){
        if(i%7<=j%8 && i%7+(j%8)<=8) {
            System.out.print("*");
        }
        else {
            System.out.print(" ");
        }
    }
    static void printa(int r, int c , int i , int j){
        if(i%7==j%8 ||  i%7+(j%8)== 8) {
            System.out.print((char) (j + 'a'));
        }
        else {
            System.out.print(" ");
        }
    }
}
