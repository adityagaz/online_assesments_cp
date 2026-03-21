package Codeforces;
import java.util.*;
//https://codeforces.com/problemset/problem/248/A
public class CupBoards {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int l_z =0;
        int r_z = 0;
        int l_o =0;
        int r_o = 0;
        for( int i  = 0 ; i < 2*t ; i++) {
            int n = s.nextInt();
            if(i% 2 == 0) {
                if(n==1) l_o++;
                else {
                    l_z++;
                }
            }
            else {
                if(n==1)r_o++;
                else {
                    r_z++;
                }
            }
        }
        int ans = Math.min(l_o , l_z ) + Math.min(r_o , r_z);
        System.out.println(ans);
    }
}
