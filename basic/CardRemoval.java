package basic;
import java.util.*;
import java.lang.*;


public class CardRemoval
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while( t  > 0 ) {
            int len = s.nextInt();
            int [] arr = new int[len];
            for (int i  = 0 ; i < len ; i++)  {
                arr[i] = s.nextInt();
            }
            System.out.println(solve(arr));
            t--;
        }

    }

    static int solve( int [] arr) {
        int [] freq = new int[101]; //codechef constaints
        for( int i : arr) {
            freq[i]++;
        }
        int max = 0;
        for( int i : freq) {
            max = Math.max(max , i);
        }
        return arr.length - max;
    }
}
