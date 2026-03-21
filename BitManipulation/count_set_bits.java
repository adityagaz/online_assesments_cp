package BitManipulation;
import java.util.*;
import java.lang.reflect.Array;

public class count_set_bits {
    public static void main(String[] args) {
        int b = 7;
        int length = (int) Math.floor(Math.log10(b) + 1);
//        char [] arr  = Integer.toBinaryString(a).toCharArray();
//        System.out.println(length);
        int a = 5;
        System.out.println(Arrays.toString(countingSetBits(a)));

    }

    static int[]  countingSetBits(int num) {
        int [] res = new int[num+1];
        for( int i = 0 ; i <= num ; i++ ){
            res[i] = countbits(i);
        }
        return res;
    }
    static  int countbits(int num ) {
        int i = 0;
        int n = (int) Math.pow(2 ,i);
        int counter = 0;

        while ( n <= num ){
            if((num & n) != 0)counter++;
            i++;
            n =(int ) Math.pow(2 , i );
        }
        return counter;
    }
}
