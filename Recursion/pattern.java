package Recursion;

public class pattern {

    public static void main (String [] args) {

        /*
        1
        12
        123
        1234
        12345
         */

        pattern(5);
    }

    static int pattern ( int n ) {
        if( n == 0 ){
            return 1;
        }
        for(int i = 1 ; i  <= n ; i++  ) {
            System.out.print(i);
        }
        System.out.println();
        int num = pattern (n-1);
        for(int i = 1 ; i  <= n ; i++  ) {
            System.out.print(i);
        }
        System.out.println();
        return num;
    }
}
