package Codeforces;
import java.util.*;
public class ANextPrime {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int i = n+1;
        while(true) {
            if(isPrime(i)) {
                if(i == m ) {
                    System.out.println("YES");
                    break;
                }
                else {
                    System.out.println("NO");
                    break;
                }
            }
            i++;
        }
    }
    static boolean isPrime(int n ) {
        for ( int i = 2 ; i * i <= n ; i++  ) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
