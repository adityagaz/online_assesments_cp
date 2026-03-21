package Codeforces;
import java.util.*;

public class SwapAndDelete1000 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        while (t-- > 0 ) {
            String str = s.nextLine();
            System.out.println(solve(str));
        }
    }
    static int solve(String s) {
        //the main intuition is that count no of ones and no of zeros
        //start iterating the string from left to right if you get 1 the decrement the count of 0
        //else decrement count of 1.
        //if the character is zero and we have no 1 counts left then we need to delete , same if char is one and we have no counts for 0 then we
        //need to delete
        int zero_c = 0;
        int one_c = 0;

        for ( int i = 0 ; i < s.length() ; i++ ) {
            if(s.charAt(i) == '1' ) {
                one_c++;
            }else  {
                zero_c++;
            }
        }

        for( int i = 0 ; i < s.length() ; i++ ) {
            if(s.charAt(i) == '1') {
                if(zero_c == 0) {
                    return (s.length() - i);
                }else {
                    zero_c--;
                }
            }
            else {
                if(one_c == 0) {
                    return (s.length() - i);
                }
                else {
                    one_c--;
                }
            }
        }
        return 0;

    }
}
