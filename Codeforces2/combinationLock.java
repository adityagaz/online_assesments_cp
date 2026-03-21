package Codeforces;
import java.util.*;
public class combinationLock {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            long num = s.nextInt();
            solve(num);
        }
    }
    static void solve(long num ) {
        while (num  > 0 ) {
            if(num % 33 == 0) {
                System.out.println("YES");
                return;
            }
            else {
                String s = String.valueOf(num);
                if(s.contains("33")){
                    num = Integer.parseInt(s.replace("33" , ""));
                }
                else {
                    num -= 33;
                }
            }
        }
        System.out.println("NO");
    }
}
