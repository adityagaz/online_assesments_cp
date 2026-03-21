package CODECHEF.THOU1000TO1200;
import java.util.*;
public class prime {
    public static void main(String[] args) {

            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            while(t-- > 0 ) {
                long m = s.nextInt();
                long n = s.nextInt();
                prime(n , m );
                System.out.println();
            }
    }
//    static void solve( long n , long m) {
//        for( long i = m ; i <= n ; i++ ){
//            if(isPrime(i)) {
//                System.out.println(i);
//            }
//        }
//    }
//
//    static boolean isPrime(long n ) {
//        for( int i = 2 ; i*i <= n ; i++ ){
//            if(n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    static void prime(long n, long m) {
        boolean [] isNotPrime = new boolean[(int) (n+2)];
        for( long i = 1 ; i<=n ; i++ ) {
            if( i == 1) {
                isNotPrime[(int) (i)] = true;
            }
            if(!isNotPrime[(int) (i)] && i !=1) {
                //explore whether it is a prime or not
                //mark all the multiples as true in the visited
                for(int j = 2; j<= n/i ; j++) {
                    isNotPrime[(int)((i*j))] = true;
                }
            }
        }
        for( long i = m ; i<=n ; i++ ) {
            if(!isNotPrime[(int) (i)]) {
                System.out.println(i);
            }
        }
    }

}
