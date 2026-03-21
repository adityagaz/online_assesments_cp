package Google;
// Write your code here
import java.util.*;
public class Main {
    public static void main (String [] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0 ) {
            int n = s.nextInt();
            int m = s.nextInt();
            int k = s.nextInt();
            int [] arr = new int[n];
            int [] arr2 = new int[m];
            int [] c  =  new int[n+m];
            int idx=0;
            for(int i=0;i<n;i++) {
                c[idx++] = s.nextInt();
            }
            for( int j=0;j<m;j++) {
                c[idx++] = s.nextInt();
            }
//            int idx = 0;
//            for( int i : arr) {
//                for (int j :  arr2) {
//                    c[idx++] = i+j;
//                }
//            }

            int ans = solve(c , k);
            System.out.println(ans);
        }
    }

            static int solve(int [] arr  , int k) {
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //min heap by default
                for( int i : arr) {
                    if( pq.isEmpty() || pq.size() < k ) {
                        pq.add(i);
                    }
                    else
                    {
                        if( i  < pq.peek()) {
                            if(pq.size() == k ) {
                                pq.poll();
                            }
                            pq.add(i);
                        }
                    }
                }
                return pq.peek();

            }
}

