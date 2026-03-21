package Codeforces;
import java.util.*;
public class InsomniaCure {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int l = s.nextInt();
        int m = s.nextInt();
        int n = s.nextInt();
        int d = s.nextInt();
        System.out.println(undamaged_dragons(k,l,m,n,d));
    }

    static  int undamaged_dragons(int k , int l , int  m , int n , int d) {
        int ans = 0;
        HashSet<Integer> set  = new HashSet<>();
        int [] arr = {k , l , m ,n };
        for( int  j : arr) {
            for( int i = j ; i <=d ; i+=j) {
                if(i % j  == 0) {
                    if(!set.contains(i)) {
                        ans++;
                        set.add(i);
                    }
                }
            }
        }
        return  ans;
    }
}
