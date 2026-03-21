package Codeforces;

import java.util.*;
public class AWord {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        word(str);
    }
    static void word(String word) {
        int uc =0;
        int lc =0;
        for( int i = 0 ; i < word.length() ; i++ )  {
            int ch =  (int) word.charAt(i);
            if(ch >= 'a' && ch <= 'z' ) lc++;
            else uc++;
        }
        if(uc < lc) {
            System.out.println(word.toLowerCase());
        }
        else if (uc > lc) {
            System.out.println(word.toUpperCase());
        }else {
            System.out.println(word.toLowerCase());
        }
    }
}
