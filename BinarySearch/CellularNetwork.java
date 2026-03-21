package BinarySearch;
import java.util.*;

public class CellularNetwork {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        long[] cities = new long[n];
        long[] towers = new long[m];
        for (int i = 0; i < n; i++) {
            cities[i] = s.nextLong();
        }
        for (int i = 0; i < m; i++) {
            towers[i] = s.nextLong();
        }

        System.out.println(solve(cities , towers));
    }

    static  long solve ( long [] cities , long []  towers) {
        int t_l = towers.length , c_l = cities.length;
        long lo = 0 ;
            //we have to accomodate extras
        long hi = Long.MAX_VALUE;

        long ans = -1;
        while(lo <= hi ) {
            long mid = lo + (hi - lo  ) /2;
            if(checker(cities , towers , mid) ==1 ) {
                ans = mid;
                hi = mid -1;
            }
            else {
                lo = mid +1;
            }
        }
        return  ans;
    }

    static long checker(long [] cities , long [] towers , long mid) {
        //to check if we can cover all cities with range r
        int c =0;
        int t =0;
        while(c < cities.length && t < towers.length ) {
            long dist = Math.abs(cities[c] - towers[t]);
            if(dist <= mid) {
                c++;
            }
            else{
                t++;
            }
        }
        if(c == cities.length && t < towers.length ) return 1; else return 0;
    }
}