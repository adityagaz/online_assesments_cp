package CODECHEF.THOU1000TO1200;
import java.util.*;
public class convert_to_permutation {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();while(t-- > 0) {
        int l = s.nextInt();
        int [ ] a = new int[l];
        for( int i = 0 ; i < l ;i++ ) {
            a[i] = s.nextInt();
        }
        solve(a , l);
    }
    }
    static void solve( int [] a , int l ) {
        int sum = 0;
        int l_count = 0;
        for( int i=0 ; i< a.length ; i++)  {
            if(l_count > 1)  {
                System.out.println(-1);
                return;

            }
            if(a[i] == l) {
                l_count++;
            }
            sum+=a[i];
        }
        if(l_count > 1) {
            System.out.println(-1);
        }
        else {
            System.out.println((l*(l+1)/2) - sum);
        }

    }
}
