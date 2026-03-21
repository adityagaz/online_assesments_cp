package Codeforces;
import java.util.*;
public class username {

    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int l = s.nextInt();
        int [] arr = new int [l];
        for( int i = 0 ; i < l ; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(bestCoder(arr));

    }
    static int bestCoder(int [] arr) {
        int best = arr[0] ; int worst = arr[0];
        int ans = 0;

        for( int i = 1 ; i < arr.length ; i++ ) {
            if(arr[i] > best) {
                ans++;
                best = arr[i];
            }
            else if (arr[i] < worst) {
                ans++;
                worst = arr[i];
            }
        }

        return ans;
    }
}
