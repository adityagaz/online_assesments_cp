package CODECHEF.THOU1000TO1200;

import java.util.*;
public class candies {

    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while( t > 0 ) {
            int len = s.nextInt();
            int [] result = new int[2*len];
            for( int i = 0 ; i < 2 * len  ;i++) result[i] = s.nextInt();
            solve(result);
            t--;
        }
    }
    static void solve(int [] arr)  {
        HashMap<Integer, Integer > map = new HashMap<>();
        for( int i : arr) {
            map.put( i , map.getOrDefault(i , 0) +1);
        }
        boolean flag = false;
        for( int i : map.keySet()) {
            if(map.get(i) >2 ) {
                flag = true;
            }
        }
        if(flag){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}




