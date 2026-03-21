package Codeforces;
import java.util.*;
public class Tram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int l = s.nextInt();
        int [] leaving = new int[l];
        int [] coming = new int[l];
        int idx_l = 0; int idx_r = 0;
        for( int i  = 0 ; i < 2*l ; i++ ) {
            if(i % 2== 0 ) {
                leaving[idx_l++] = s.nextInt();
            }
            else {
                coming[idx_r++] = s.nextInt();
            }
        }
        int ans = coming[0];
        int min_capacity = coming[0];
        for( int i = 1 ; i < l ; i++ ) {
            min_capacity-= leaving[i];
            min_capacity+= coming[i];
            ans = Math.max(ans , min_capacity);
        }
        System.out.println(ans);
    }
}
