package minimization;
import java.util.*;

public class min_cost_to_reach_city {


    /*

AMAZON SUMMER SCHOOL OA
Problem Description
George is traveling through a sequence of N cities, numbered from 1 to N.
He starts at city 1 and wants to reach city N.
From any city i, he may take one of two flights (if it exists):
from city i to city i+1
from city i to city i+3
T: number of test cases

For each test case:

A line with integer N (3 ≤ N ≤ 10^5), the number of cities.

A line with N integers, the Cost array for that test case.


Explanation of Sample 1
Cities: 1 → 2 → 3 → 4
Costs: [5, 8, 10, 15]
Optimal path uses only i → i+1 flights:
Flight 1→2 costs |5–8| = 3
Flight 2→3 costs |8–10| = 2 (running total = 5)
Flight 3→4 costs |10–15| = 5 (running total = 10)
Total minimum cost is 10.

You are given an array Cost of length N, where Cost[i] is the ticket cost associated with city i. The cost of flying between city i and city j is the absolute difference of their costs:
     TEST CASES 
6
4
5 8 10 15
4
10 6 3 1
5
1 100 1 100 1
6
4 12 13 18 10 12
7
7 2 3 8 6 10 9
8
5 5 5 5 5 5 5 5

EXPECTED OUTPUT
10
9
198
10
2
0

     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int [] arr = new int[n+1];
            int [] dp = new int[n+1];
            for ( int i = 1 ; i <= n ; i++ ) {
                arr[i]= s.nextInt();
            }
            // dp[i] -- minimum cost to reach city at index i .... Ans = min cost to reach city N
            dp[1] = 0;
            for( int i = 2 ; i <= n ; i++ ) {
                int way1 = dp[i-1] + Math.abs(arr[i]-arr[i-1]);
                int way2 = i-3 < 1 ? Integer.MAX_VALUE : dp[i-3] + Math.abs(arr[i] - arr[i-3]);
                dp[i] = Math.min(way1, way2);
            }
            System.out.println(dp[n]);
        }
    }
}
