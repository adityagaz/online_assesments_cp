package CODECHEF.THOU1000TO1200;
import java.util.*;
public class equalizeab {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s= new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            int x = s.nextInt();
            solve(a,b,x);

        }
    }

    static void solve(int a , int b , int x) {
        if( a == b ) {
            System.out.println("YES");
        }
        else if(Math.abs(a-b ) % (2 * x) == 0) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

        //below is the naive approach to this
//        else if(a > b) {
//            while ( a > b) {
//                a-=x;
//                b+=x;
//            }
//            if( a == b) {
//                System.out.println("YES");
//            }
//            else {
//                System.out.println("NO");
//            }
//        }
//        else {
//            while ( a < b) {
//                a+=x;
//                b-=x;
//            }
//            if( a == b) {
//                System.out.println("YES");
//            }
//            else {
//                System.out.println("NO");
//            }
//        }
    }
}


//6
//        5 7 1
//        3 4 2
//        4 4 6
//        2 5 3
//        1 4 1
//        1 5 1
