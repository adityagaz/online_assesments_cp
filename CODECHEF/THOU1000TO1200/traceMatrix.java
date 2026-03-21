package CODECHEF.THOU1000TO1200;
import java.net.Inet4Address;
import java.util.*;


public class traceMatrix {

    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int t = s.nextInt();
        while( t-- > 0) {
            int size = s.nextInt();
            int[][] arr = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            System.out.println(solve(arr));
        }
    }
    //naive solution O(n^4)
//    static  int solve(int [][] arr) {
//        int max = Integer.MIN_VALUE;
//        for( int size = 0 ; size < arr.length -1 ; size++) {
//            for( int step = 0;  step < arr.length - size ; step++ ) {
//                for( int col = 0 ; col < arr.length  -size ; col++) {
//                    int sum = 0;
//                    for (int row = 0; row <= size; row++) {
//                        sum += arr[step + row][col + row];
//                    }
//                    max = Math.max(sum, max);
//                }
//            }
//
//        }
//        return max;
//
//    }

    static int solve(int [] [] arr) {
        int max = Integer.MIN_VALUE;
        for( int i =0 ; i < arr.length ; i++ ) {
            int lower_dia = 0;
            int upper_dia = 0;
            int col = 0;
            int row = i;
            while(row < arr.length  && col < arr.length) {
                lower_dia += arr[row][col];
                upper_dia += arr[col][row];
                row++;
                col++;

            }
            max = Math.max(max, Math.max(upper_dia, lower_dia));
        }
        return  max;
    }
}
