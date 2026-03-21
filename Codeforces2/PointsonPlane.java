package Codeforces;
import java.math.BigInteger;
import java.util.*;

public class PointsonPlane {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- >0) {
            long n = s.nextLong();
            solve(n);
        }
    }
    static  void solve(long n)
    {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        long ans = 0;
        while(lo <= hi ) {
            long mid = lo + ( hi  - lo) /2;
            if(checker(mid , n )) {
                ans = mid;
                hi = mid -1;
            }
            else {
                lo = mid +1;
            }
        }
        System.out.println(ans);
    }
    static boolean checker(long mid, long n) {
        BigInteger midBI = BigInteger.valueOf(mid + 1);
        BigInteger square = midBI.multiply(midBI);
        return BigInteger.valueOf(n).compareTo(square) <= 0;
    }
}
