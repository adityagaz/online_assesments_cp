package Heaps;
import java.util.*;

public class KclosestPointsToOrigin {

    public static void main(String [] args) {
            int [][] results = {
                    {1,2},{3,4},{2,3},{-3,0}
            };
            int k = 2;
            System.out.println(Arrays.toString(closestPoints(results , k )));
    }

    static int  [] closestPoints(int [][] queries , int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> {
            return Integer.compare(b , a);
        });
        int [] result  = new int[queries.length];
        for ( int i = 0 ;i < queries.length ; i++) {
            int dist  = Math.abs(queries[i][0] ) + Math.abs(queries[i][1] );
            pq.add(dist);
            if(pq.size() < k ) {
                result[i] = -1;
            }
            else if(pq.size() > k) {
                pq.poll();
                result[i] = pq.peek();
            }
            else {
                result[i] = pq.peek();
            }
        }
        return result;
    }
}
