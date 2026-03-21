package basic;
import java.util.*;
public class zeroString {
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        while(t > 0) {
            int len = s.nextInt();
            s.nextLine();
            String [] arr = s.nextLine().split("");
            System.out.println(solve(arr,len));
            t--;
        }
    }
    static int solve(String [] arr , int len) {
        int minOps = 0;
        int ones = 0 ;
        int zeros =0;
        for( int i = 0 ; i < len ; i++  ) {
            if(arr[i].equals("1")) {
                ones++;
            }
            else {
                zeros++;
            }
        }
        if(ones > zeros) {
            minOps = 1 + zeros;
            return minOps;
        }
        else {
            return ones;
        }
    }
}
