package sts;

public class nqueens {

    public static void main (String [] args ) {
        int [][] mat = new int[4][4];

        for(int i = 0 ; i < 4 ; i++  ) {
            for (int  j = 0 ; j  < 4 ; j++ ){
                if(i >= j) {
                    mat[i][j] =  i+j;
                }
                else {
                    mat[i][j] = i-j;
                }
            }
        }

        for( int [] arr : mat) {
            for( int i = 0 ; i < arr.length ; i++) {
                System.out.print(arr[i] +  " ");
            }
            System.out.println();
        }

    }
}
