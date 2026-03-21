package basic;

import java.util.*;
import java.lang.*;
import java.io.*;

public class twoStrings
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        while ( t > 0 ) {
            String a = s.nextLine();
            String b = s.nextLine();

            solve(a,b);
            t--;
        }
    }

    static void solve(String a ,String b) {
        int max = a.length();
        int min = 0;
        for( int i = 0 ; i < a.length() ; i++ ){
            char a_ch = a.charAt(i);
            char b_ch = b.charAt(i);
            if(a_ch != '?' && b_ch != '?' && a_ch == b_ch) {
                max--;
            }
            else if(a_ch != '?' && b_ch != '?' && a_ch != b_ch)
                min++;
        }


        System.out.println(min + " " + max);


    }

}
