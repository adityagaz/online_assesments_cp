package basic;

import java.util.*;
        import java.lang.*;
        import java.io.*;

public class bear_and_candies
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while ( t > 0)  {
            int a = s.nextInt();
            int b = s.nextInt();
            solve(a , b);
            t--;
        }
    }
    static void solve(int a , int b) {
        int odd= 1;
        int even = 2;
        boolean limak_turn = true;
        while(a>= 0 && b >=0) {
            if(limak_turn) {
                a-=odd;
                odd+=2;
                limak_turn = false;
            }else {
                b-=even;
                even+=2;
                limak_turn = true;
            }
        }
        if(a<0) {
            System.out.println("Bob");
        }
        else {
            System.out.println("Limak");
        }
    }
}

