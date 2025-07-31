package GREEDY.NO_EXCHANGE_INTUITION_ONLY;
import java.util.*;
public class turn_on_all_bulbs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        
        while(t-- > 0) {
            int n = s.nextInt() , k = s.nextInt();
            int [] arr = new int[n];
            for( int i = 0; i < n  ; i++ ) arr[i] = s.nextInt();
            solve(n , k , arr);
        }
    }

    static void solve(int n , int k , int [] arr ) {
        int [] pref = new int[n+1];
        int start = 0 , end = n-k;
        long ans = 0;
        for( int i = start ; i <= end; i++ ) {
            pref[i] +=  i == 0 ? 0  : pref[i-1];
            int ops = pref[i];
            if((ops&1)==1) {
                //it will reverse
                if(arr[i] == 1) {
                    //we need to do ops
                    pref[i] +=1;
                    pref[i+k]-=1;
                    ans++;
                }
                
            }
            else {
                //it will remain same
                if(arr[i] == 0) {
                    pref[i] +=1;
                    pref[i+k] -=1;
                    ans++;
                }
            }

        }

        //Now check for end elements n-k .... n elements
        for( int i = n-k ; i < n; i++ ) {
            int ops = pref[i];
             pref[i] += pref[i-1];
              if((ops&1)==1) {
                //it will reverse
                if(arr[i] == 1) {
                   System.out.println(-1);
                   return;
                }
                
            }
            else {
                //it will remain same
                if(arr[i] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(ans);
    }
}
