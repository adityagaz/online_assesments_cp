package maximization;

import java.util.*;

public class google_choose_from_two_arrays_at_max_2 {
    /*
     * Problem :-
     * 
     * A treasure hunter arrives at a long corridor with N locked chests in a row.
     * At the i-th position there are two chests:
     * 
     * Chest B contains B[i] gold coins
     * 
     * Chest C contains C[i] gold coins
     * 
     * Each day (from position 1 through N) our hunter must choose exactly one chest
     * to open and collect its coins. However, to keep things interesting, the
     * hunter has sworn never to open more than two chests of the same type in a
     * row.
     * 
     * Help the hunter plan which chest to open at each position so as to maximize
     * the total number of coins collected, subject to the “no three consecutive of
     * the same chest” rule.
     * 
     * Input Format
     * 
     * First line: a single integer N (the number of chests; 1 ≤ N ≤ 100 000)
     * 
     * Next N lines: two space-separated integers B[i] and C[i] —the coin counts in
     * chest B and chest C at position i (1 ≤ B[i], C[i] ≤ 10 000 000 000)
     * 
     * Output Format
     * 
     * A single integer: the maximum total coins the hunter can collect.
     * 
     * Example
     * 
     * makefile
     * Copy
     * Edit
     * Input:
     * 3
     * 5 10
     * 3 10
     * 4 10
     * 
     * Output:
     * 25
     * Explanation of the example:
     * 
     * Day 1: open chest C (10 coins)
     * 
     * Day 2: open chest C (10 coins)
     * 
     * Day 3: now you cannot open C again (would be three in a row), so open B (4
     * coins)
     * Total = 10 + 10 + 4 = 25.
     */

    /*
     * ANALYSIS --
     * It is evident that it is a dynamic programming problem because we have
     * choices to pick and we never
     * know that if we pick two elements the same array might have a more valuable
     * coin in the next index
     * to pick and we can't do
     * So, the crux is we are unaware of the future states so a greedy solution
     * won't work here.
     * Now think of DP
     * Always form the state as what is required in the question
     * since we have two arrays we can create two arrays for each and take the
     * maximum of both of them.
     * dp_1[i] -- means that take the element at i in the first array.
     * now we have two options
     * 1. take the previous element from the same array and then take the best
     * answer from the other array
     * because we can't take more than two elements from a same array.
     * 2. take the best answer from the other array at index i-1
     * same we will do for the other array we take the element at b[i] and then look
     * back to join...
     * Final answer = max of(dp_1[n] , dp_2[n])
     * 
     * dp_1[n] - represents the max sum could be obtained if we take a[n]
     * dp_2[n] - represents the max sum that could be obtained if we take b[n]
     * 
     * 
     * //TEST CASES --
     * First line
     * T: the number of test cases.
     * 
     * For each test case (repeated T times):
     * 
     * Line 1 of the test case:
     * 
     * N — the number of positions (or “days”/“chests”), 1 ≤ N ≤ 100 000.
     * 
     * Next N lines:
     * 
     * Each line has two space-separated integers B[i] and C[i], the coin counts in
     * chest B and chest C at position i (1 ≤ B[i], C[i] ≤ 10 000 000 000).
     * 
     * Output
     * 
     * You should print T lines.
     * 
     * On the k-th line, print a single integer: the maximum total coins collectible
     * for the k-th test case, under the rule that you may never open more than two
     * B-chests in a row or more than two C-chests in a row.
     * 
     * 12
     * 1
     * 7 3
     * 2
     * 5 10
     * 20 1
     * 3
     * 5 10
     * 3 10
     * 4 10
     * 3
     * 10 5
     * 10 3
     * 10 4
     * 4
     * 1 4
     * 2 3
     * 3 2
     * 4 1
     * 5
     * 10 1
     * 1 10
     * 10 1
     * 1 10
     * 10 1
     * 6
     * 13 13
     * 14 10
     * 2 16
     * 9 12
     * 17 19
     * 16 7
     * 7
     * 33 17
     * 9 35
     * 19 46
     * 9 39
     * 49 10
     * 7 20
     * 40 7
     * 10
     * 1 10
     * 2 9
     * 3 8
     * 4 7
     * 5 6
     * 6 5
     * 7 4
     * 8 3
     * 9 2
     * 10 1
     * 5
     * 5 5
     * 5 5
     * 5 5
     * 5 5
     * 5 5
     * 5
     * 100 1
     * 100 1
     * 100 1
     * 100 1
     * 100 1
     * 5
     * 1 100
     * 1 100
     * 1 100
     * 1 100
     * 1 100
     * 
     * 
     * ANSWERS -
     * 7
     * 30
     * 25
     * 25
     * 14
     * 50
     * 88
     * 236
     * 70
     * 25
     * 401
     * 401
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] b = new int[n + 1];
            int[] c = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                b[i] = s.nextInt();
                c[i] = s.nextInt();
            }
            int[] dp_b = new int[n + 1];
            int[] dp_c = new int[n + 1];
            
            dp_b[1] = b[1];
            dp_c[1] = c[1];
            for (int i = 2; i <= n; i++) {
                dp_b[i] = b[i] + Math.max(dp_c[i - 1], dp_c[i - 2] + b[i - 1]);
                dp_c[i] = c[i] + Math.max(dp_b[i - 1], dp_b[i - 2] + c[i - 1]);
            }
            System.out.println(Math.max(dp_b[n], dp_c[n]));
        }
    }
}
