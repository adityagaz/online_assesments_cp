package Codeforces;

import java.util.*;
public class BeautifulYear {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        System.out.println(findNextDistinct(num));
    }

    static  int findNextDistinct(int num ) {
        num++;
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int n = num;
            while (n > 0) {
                int digit = n % 10;
                n /= 10;
                set.add(digit);
            }
            if (set.size() == 4) {
                return num;
            } else {
                set.clear();
                num++;
            }
        }
    }
}
