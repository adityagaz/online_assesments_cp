package CODECHEF.THOU1000TO1200;
import java.util.*;
public class adjacent_sum_parity {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while( t > 0 ) {
            int len = s.nextInt();
            int [] arr = new int[len];
            for( int i = 0 ; i < len ; i++ ) {
                arr[i] = s.nextInt();
            }
            solve(arr);
            t--;
        }

        HashMap<Integer , Integer> mp = new HashMap<>();

    }

    static void solve(int [] arr) {
        int final_bit = arr[arr.length -1];
        int [] result = new int[arr.length];
        for( int i = 0 ; i < arr.length -1 ; i++ ) {
            if(arr[i] == 1) {
                if(i == 0) {
                    result[i] = 1;
                    result[i+1] = 2;
                }
                if(result[i] % 2 == 0) {
                    result[i+1] = 1;
                }
                else {
                    result[i+1] = 2;
                }
            }
            else {
                if(i == 0 ) {
                    result[i] = 1;result[i+1] =1;

                }
                if(result[i] % 2 == 0) {
                    result[i+1] = 2;
                }
                else {
                    result[i+1] = 1;
                }
            }
        }
        if((result[0] + result[result.length -1 ] ) %2  == final_bit) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }




}
