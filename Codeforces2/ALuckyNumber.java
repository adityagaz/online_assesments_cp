package Codeforces;

import java.util.Scanner;

public class ALuckyNumber {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lucky_count = 0;
        long n = s.nextLong();
        while ( n > 0) {
            long rem = n % 10;
            if(rem == 7 ||  rem == 4){
                lucky_count++;
            }
            n/=10;
        }
        isNearlyLucky(lucky_count);
    }

    static void isNearlyLucky(long num ) {
        if(num == 0) {
            System.out.println("NO");
            return;
        }
        while ( num >  0) {
            long rem = num  % 10 ;
            if( rem != 4 && rem != 7) {
                System.out.println("NO");
                return;
            }
            num /=10;
        }
        System.out.println("YES");
    }
}
