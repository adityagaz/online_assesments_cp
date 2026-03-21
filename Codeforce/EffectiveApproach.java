package Codeforce;
import java.util.*;
public class EffectiveApproach {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for (int i  = 0 ; i < n ; i++) {
            arr[i] = s.nextInt();
        }
        int m = s.nextInt();
        int [] queries = new int[m];
        for( int i = 0 ; i < m ; i++ ) {
            queries[i] = s.nextInt();
        }
        effectiveApproach(arr , queries);
    }

    static  void effectiveApproach(int [] arr , int [] queries) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        long vasya_q = 0;
        long patya_q = 0;
        for( int i  = 0 ; i < arr.length ; i++ ){
            mp.put(arr[i] , i +1);
        }
        for (int i = 0; i < queries.length; i++) {
            vasya_q+=mp.get(queries[i]);
            patya_q+=arr.length - mp.get(queries[i]) + 1;
        }
        System.out.println(vasya_q + " " + patya_q);
    }
}

