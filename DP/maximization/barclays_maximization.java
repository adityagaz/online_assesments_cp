package maximization;

import java.util.*;

public class barclays_maximization {

    /*
     * Company: Barclays
     * Stephen is doing an internship in a company for N days. Each day, he may
     * choose to do an easy task, a difficult task, or no task at all. The payment
     * for an easy or difficult task varies from day to day, but on any given day
     * the difficult task always pays strictly more than the easy task. In order to
     * do a difficult task on day i, Stephen must not have done any task on day i−1.
     * 
     * Given the payments for the easy and difficult tasks on each of the N days,
     * compute the maximum total salary Stephen can earn.
     * 
     * Input
     * 
     * The first line contains two space-separated integers:
     * 
     * N — the number of days of the internship (1 ≤ N ≤ 10⁵)
     * 
     * M — the number of task types per day (always M = 2)
     * 
     * Each of the next N lines contains two space-separated integers easy and hard,
     * where:
     * 
     * easy is the payment for the easy task on that day (1 ≤ easy < hard)
     * 
     * hard is the payment for the difficult task on that day (2 ≤ hard ≤ 10⁴)
     * 
     * Output
     * Print a single integer — the maximum salary Stephen can earn.
     * 
     * 
     * 
     * Approach -- 
     * 
     * TEST CASES-
     * 
12
1 2
5 10

2 2
5  7
3  4

3 2
1  2
3  5
4  7

4 2
1  3
2  4
3  5
4  6

5 2
3  9
1  5
2  8
6 10
4  7

3 2
5  6
5  6
5  6

3 2
1 10
1 10
1 10

6 2
2 3
2 3
2 3
2 3
2 3
2 3

6 2
1 100
1 100
1 100
1 100
1 100
1 100

7 2
3  14
1   5
7  10
2   8
4  16
3   9
8  12

5 2
1  100
50  51
1  100
50  51
1  100

4 2
10 11
10 11
10 11
10 11

Expected Output -

10
10
9
12
27
16
20
13
301
52
300
41

     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[] easy = new int[n + 1];
            int[] hard = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                easy[i] = s.nextInt();
                hard[i] = s.nextInt();
            }

            solve(easy, hard, n);

        }
    }

    static int solve(int[] easy, int[] hard, int n) {

        int[] dp_easy = new int[n + 1];
        int[] dp_hard = new int[n + 1];

        dp_easy[1] = easy[1];
        dp_hard[1] = hard[1];

        // dp_easy[2] = easy[2] + Math.max(dp_easy[1], dp_hard[1]);
        // dp_hard[2] = hard[2];

        for (int i = 2; i <= n; i++) {
            dp_easy[i] = easy[i] + Math.max(dp_easy[i - 1], dp_hard[i - 1]);
            dp_hard[i] = hard[i] + Math.max(dp_hard[i - 2], dp_easy[i - 2]);
        }
        System.out.println(Math.max(dp_easy[n], dp_hard[n]));
        return 0;

    }

}
