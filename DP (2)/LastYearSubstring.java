package DP;
import java.util.*;
public class LastYearSubstring {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while(t-- > 0 ) {
            int len = s.nextInt();
            s.nextLine();
            String str = s.nextLine();
            solve(str);
        }
    }

    static void solve(String s ) {
        for(int i = 0; i < 5; i++) {
            String a = s.substring(0 , i);
            String b = s.substring(s.length() - 4 + i , s.length());
            if((a+b).equals("2020")) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
