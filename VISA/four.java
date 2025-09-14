package VISA;


import java.util.*;

public class four {

    // segments[i] = {L, R} (inclusive). Return cumulative painted length after each segment.
    public static long[] solution(int[][] segments) {

        int n = segments.length;
        long [] ans = new long[n];
        List<long [] > intervals = new ArrayList<>();
        for( int i  = 0 ; i < n ; i++ ) {
            long l = segments[i][0];
            long r = segments[i][1];
            if (l > r) { long t = l; l = r; r = t; }

            merge(intervals , l , r);

            int total = 0;
            for( long [] v: intervals) {
                total += (v[1] - v[0] +1);
            }

            ans[i] = total;
        } 
        System.out.println(Arrays.toString(ans));
        return ans;
           
    }

    static void merge(List< long[] > intervals , long l , long r ) {
        long nL = l , nR = r;
        int i = 0;
        int n = intervals.size();
        while(i < intervals.size() ) {
            if(intervals.get(i)[1] < nL) {
                i++;
            }
            else if( intervals.get(i)[0] > nR) {
                break;
            }
            else {
                nL = Math.min(nL , intervals.get(i)[0]);
                nR = Math.max(nR , intervals.get(i)[1]);
                intervals.remove(i);
            }
        }

        intervals.add(i , new long [] {nL , nR });
    }
    //   private static void merge(List<long[]> intervals, long L, long R) {
    //     long newL = L, newR = R;
    //     int i = 0;

    //     // Remove and absorb any overlapping intervals.
    //     // Because 'intervals' is sorted by start, we can stop once we pass newR.
    //     while (i < intervals.size()) {
    //         long a = intervals.get(i)[0], b = intervals.get(i)[1];
    //         if (b < newL) {
    //             // current ends before new interval starts → move on
    //             i++;
    //         } else if (a > newR) {
    //             // current starts after new interval ends → no more overlaps
    //             break;
    //         } else {
    //             // overlap -> expand [newL,newR] and remove this interval
    //             newL = Math.min(newL, a);
    //             newR = Math.max(newR, b);
    //             intervals.remove(i); // do not increment i; we just shifted the list
    //         }
    //     }

    //     // Find insert position to keep sorted by start (i is first with start > newR or end)
    //     intervals.add(i, new long[]{newL, newR});
    // }


    // quick demo
    public static void main(String[] args) {
        int[][] a = { {1,1}, {2,2}, {3,5} };
        System.out.println(Arrays.toString(solution(a))); // [1, 2, 3]

        int[][] b = { {1,1}, {2,2}, {3,5} };
        System.out.println(Arrays.toString(solution(b))); // [1, 2, 5]

        int[][] c = { {1,9}, {1,3}, {8,15}, {6,9}, {2,5} };
        System.out.println(Arrays.toString(solution(c))); // [9, 9, 15, 15, 15]

        int[][] d = { {7,9}, {1,3}, {8,15}, {6,9}, {2,4} };
        System.out.println(Arrays.toString(solution(d))); // [3, 6, 12, 13, 14]
    }
}
