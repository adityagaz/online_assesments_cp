package Codeforces;
import java.util.*;
public class AStonesOnTable {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        s.nextLine();
        String ip = s.nextLine();
        System.out.println(minDel(ip , len));

    }
    static  int minDel(String s , int len   ) {
        int i = 0; int ans = 0;
        while(i < s.length() -1 ) {
            while(i <s.length()-1 && s.charAt(i) == s.charAt(i+1)) {
                s = s.substring(0 , i) + s.substring(i+1);
                ans++;
            }
            i++;
        }
        return ans;
    }
}
