package Codeforces;
import java.util.*;
public class AddingDigits {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long a = s.nextInt();
        long b = s.nextInt();
        long n = s.nextInt();
        addingDigits(a,b,n);
    }

    static void addingDigits(long a , long b , long n) {

        boolean didBroke = false;
        for ( int i = 1 ; i <= n ; i++) {
            boolean  isFound = false;
            for( int j = 0 ; j <= 9 ; j++) {
                if( (a* 10+ j)  % b == 0 ) {
                    a = a* 10+ j;
                    isFound = true;
                    break;
                }
            }
            if(!isFound) {
                didBroke = true;
                break;
            };
        }
        if(didBroke) {
            System.out.println("-1");
        }
        else {
            System.out.println(a);
        }
    }
}
