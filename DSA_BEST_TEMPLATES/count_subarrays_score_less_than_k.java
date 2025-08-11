package DSA_BEST_TEMPLATES;
import java.util.*;
public class count_subarrays_score_less_than_k {

    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int [] arr = new int[n];
        for( int i= 0 ; i < n ; i++ ){
            arr[i] = s.nextInt();
        }
        solve( arr , n , k );

    }
    
    static long solve( int [] arr , int n , int k) {
        long[] pref = new long[n];
        for (int i = 0; i < n; i++) {
            pref[i] = i == 0 ? arr[i] : arr[i] + pref[i - 1];
        }
        int tail = 0, head = -1;
        long ans = 0;
        long sum = 0; 
        while (tail < n) {
            while (head + 1 < n && ((pref[head+1] - (tail>0 ? pref[tail-1] : 0)) * ((head+1) - tail + 1) < k) ) {
                    head++;
                    sum = (long)(pref[head] - (tail>0 ? pref[tail-1] : 0)) * ((head) - tail + 1);
            }
            ans += (head - tail + 1L);
            if (tail > head) {
                tail++;
                head = tail - 1;
            } else {
                tail++;
                sum = (long) pref[head] - (tail > 0 ? pref[tail - 1] : 0) * (head - tail + 1L);
            }
        }
        System.out.println(ans);

        return ans; 
    }
}