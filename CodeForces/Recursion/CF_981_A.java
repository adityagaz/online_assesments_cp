package CodeForces.Recursion;
import java.util.*;
public class CF_981_A {
    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while( t >0 )
        {
            int n = s.nextInt();
            System.out.println(saruAndKosu(n));
            t--;
        }

    }
    static String saruAndKosu(int n) {
        int x = 0 ;
        for  ( int  i = 1; ; i++) {
            if(i % 2 !=0) {
                x -= 2*i -1;
            }else {
                x += 2 * i - 1;
            }
            if(x > n || x < -1*n ) {

                if(x > 0 ) {
                    return "Kosuke";
                }
                else {
                    return "Sakurako";
                }
            }
        }
    }
}
