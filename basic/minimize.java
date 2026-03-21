package basic;
import java.util.*;
public class minimize {
    public static void main (String [] args) {
    /*
    A. Minimize!
time limit per test1 second
memory limit per test256 megabytes
You are given two integers a
 and b
 (a≤b
). Over all possible integer values of c
 (a≤c≤b
), find the minimum value of (c−a)+(b−c)
.

Input
The first line contains t
 (1≤t≤55
) — the number of test cases.

Each test case contains two integers a
 and b
 (1≤a≤b≤10
).

Output
For each test case, output the minimum possible value of (c−a)+(b−c)
 on a new line.
     */
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    for(int i = 0 ; i < n ; i++) {
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.println(solve(a , b));
    }
    }

    static int solve(int a  , int b) {
        int min = Integer.MAX_VALUE;
        for( int i =  a ; i <=b ; i++ ){
            min = Math.min(min , (i-a)+ (b-i));
        }
        return min;
    }
}
