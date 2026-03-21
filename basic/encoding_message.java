package basic;

import java.util.*;
import java.lang.*;
import java.io.*;

public class encoding_message
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while( t > 0) {
            int len = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(solve(s , len));
            t--;
        }
    }
    static String solve(String s ,int len ) {
        List<Character> l = new ArrayList<>();
        HashMap<Character , Integer > mp = new HashMap<>();
        for( int i =0 ; i < 26 ; i++ ) {
            char al = (char) ('a' + i);
            l.add(al);
            mp.put(al , i);
        }
        //swap for even
        StringBuilder str = new StringBuilder(s);
        if(len % 2 == 0) {
            for( int  i = 0 ; i < s.length() ; i+= 2 ){
                char temp = str.charAt(i+1);
                str.setCharAt(i+1 , s.charAt(i));
                str.setCharAt(i , temp);
            }
        }
        //swap for odd
        else {
            for( int  i = 0 ; i < s.length()-1 ; i+= 2 ){
                char temp = str.charAt(i+1);
                str.setCharAt(i+1 , s.charAt(i));
                str.setCharAt(i , temp);
            }
        }
        //
        for(int i = 0 ; i < s.length() ; i++ ) {
            int replaceindex = 25 - mp.get(str.charAt(i));
            str.setCharAt(i , l.get(replaceindex) );

        }

        return str.toString();
    }
}
