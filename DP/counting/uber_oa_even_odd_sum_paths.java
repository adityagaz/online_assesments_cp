package counting;
import java.util.*;
public class uber_oa_even_odd_sum_paths {

    /*
Problem 
Given two arrays; a and b -> you can start at index 1 from any array and end your journey at index n on an array 
-> If you are at i you can can jump to i+1 on same array or different array 
-> -1000000000 <= a[i],b[i]<= 10000000000 
-> Please output total number of journeys which have even sum and total number of journeys which have odd sum; 

     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] a = new int[n+1];
        int [] b  = new int[n+1];
        for( int i = 1 ; i <= n ; i++ ) {
            a[i] = s.nextInt();
            b[i] = s.nextInt();
        }

        int [][] dp_a =  new int[n+1][2];
        int [][] dp_b = new int[n+1][2];
        // dp_a[i][0] - means no of even paths till index i in array a
        // dp_a[i][1] - means no of odd paths till index i in array a
        // dp_b[i][0] - means no of even paths till index i in array b
        // dp_b[i][1] - means no of odd paths till index i in array b

        /*
          if a[i] is even :
            dp_a[i][0] -- to keep it even should connect with even previously
            dp_a[i][0]  = dp_a[i-1][0] + dp_b[i-1][0]
            dp_a[i][1] -- to keep it odd we need to connect with odd previously
            dp_a[i][1] -- dp_a[i-1][1] + dp_b[i-1][1]

        else  a[i] is odd:
            dp_a[i][0] - connect with odd to make even
            dp_a[i][0] = dp_a[i-1][1] + dp_b[i-1][1]
            dp_a[i][1] - connect with even to keep it odd
            dp_a[i][1] = dp_a[i-1][0] + dp_b[i-1][0]


        if b[i] is even:
            dp_b[i][0] -- connect to even before to keep it even
            dp_b[i][0] = dp_b[i-1][0] + dp_a[i-1][0]; = dp_a[i][0]
            dp_b[i][1] = dp_b[i-1][1] + dp_a[i-1][1]; = dp_a[i][1]

        else :
            dp_b[i][0] = dp_b[i-1][1] + dp_a[i-1][1]; = dp_a[i][0]
            dp_b[i][1] = dp_b[i-1][0] + dp_a[i-1][0]; = dp_a[i][1]

        
        final answer would be what ?? for  even journeys - dp_a[n][0] + dp_b[n][0] 
        for odd dp_a[n][1] + dp_b[n][1];

        at i == 1
        if a[i] is even:
            dp_a[i][0] =1; d
            dp_a[i][1] =0;
        else:
            dp_a[i][0] = 0;
            dp_a[i][1] =1
        
        if b[i] is even:

            dp_b[i][0] = 1;
            dp_b[i][1] = 0;
        else:
            dp_b[i][0] = 0;
            dp_b[i][1] = 1;

         */
        if(a[1] % 2 == 0) {
            dp_a[1][0] = 1;
        }
        else {
            dp_a[1][1] =1;
        }
        if(b[1] % 2 == 0) {
            dp_b[1][0] = 1;
        }
        else {
            dp_b[1][1] =1;
        }
        for( int i = 2; i <= n ; i++ ) {
            if(a[i]%2==0){
                dp_a[i][0]  = dp_a[i-1][0] + dp_b[i-1][0];
                dp_a[i][1] = dp_a[i-1][1] + dp_b[i-1][1];
            }
            else {
                dp_a[i][0] = dp_a[i-1][1] + dp_b[i-1][1];
                dp_a[i][1] = dp_a[i-1][0] + dp_b[i-1][0];
            }
            if(b[i]%2 ==0) {
                dp_b[i][0]  = dp_a[i-1][0] + dp_b[i-1][0];
                dp_b[i][1] = dp_a[i-1][1] + dp_b[i-1][1];
            }
            else {
                dp_b[i][0] = dp_a[i-1][1] + dp_b[i-1][1];
                dp_b[i][1] = dp_a[i-1][0] + dp_b[i-1][0];
            }

        }
        System.out.println("Even Paths --> " + (dp_a[n][0] + dp_b[n][0]));
        System.out.println("Odd Paths --> " + (dp_a[n][1] + dp_b[n][1]));
    }
}
