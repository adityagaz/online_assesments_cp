package CODECHEF1800;
import java.util.*;
public class NormalIsGoodOptimized {
    public static void main(String [] args ){
        Scanner  s = new Scanner(System.in);
        int n = s.nextInt();
        for( int i = 0 ; i < n  ; i++ ){
            int length = s.nextInt();
            int [] arr = new int[length];
            for( int j = 0; j < length ; j++ ){
                arr[j] = s.nextInt();
            }
            System.out.println(normalCount(arr));

        }

    }
    static long normalCount(int [] arr) {
        int count = 1;
       long result = 0;
        for( int i = 0 ; i < arr.length ; i++) {
            int j = i;
            while(j < arr.length && arr[j] == arr[i] ) {
                j++;
            }
            int len = j -i;
            result+=len * (len +1)/2;
            i = j -1; //for loop will increment i
        }
        //above is two pointer technique to count the subarrays with all equal elements
        return result;
    }
}
