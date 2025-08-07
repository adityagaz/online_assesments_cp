package counting;

import java.util.Scanner;

/*
  COMPANY - MICROSOFT
  TOPICS - DP | MATH

Problem - 
You are given an unlimited supply of coins of denominations 1, 2 and 6, and up to two coins of denomination 4.
Your task is to count the number of distinct combinations (order of coins does not matter) that sum up exactly to a target value y.
Input Format
The first line contains a single integer T —the number of test cases.
Each of the next T lines contains one integer y —the target sum for that test case.
Output Format
For each test case, output a single integer—the number of combinations that sum to y under the given constraints.
Constraints
1 ≤ T ≤ 100
0 ≤ y ≤ 1000000

TEST CASES -
6 <-- denotes no of test cases
0
3
4
5
6
10

OUTPUT -
1
3
6
10
19
191


Approach-
dp[i] -- represents no of ways to make number i from 1 , 2 , 4, 6 such that 4 is used atmost 2 times
dp[y] -- final answer

dp[0] = 1 -- we can make 0 by exactly one way
dp[i] = (no of ways to make i -1 , i -2 , i- 4 , i-6) 
dp[i] = 0;
if(i-1 >=0) dp[i] += dp[i-1]
if(i-2 >=0) dp[i] += dp[i-2]
if(i-6 >= 0) dp[i] += dp[i-6] 
if(i-4 >= 0 && used < 2) dp[i] += dp[i-4] used++;

for y =1 
dp[1] = 1 - 1 = 0 dp[1] = 0 + 1 = 1
for y = 2 
dp[2] = dp[1] = 1 + dp[2-2] = 1 + 1 = 2
for y = 3
dp[3] = dp[3 -1] + dp[3-2] = dp[2] + dp[1] = 2 + 1 = 3
for y = 4 
dp[4] = dp[3] + dp[2] + dp[0] = 3 + 2 + 1 = 6
used = 1
 for y = 5 
dp[5] = dp[4] + dp[3] + dp[1] = 6 + 3 + 1 = 10
used = 2
dp[6] = dp[5] + dp[4] + dp[0] = 10 + 6 + 1 = 17
dp[7] = dp[6] + dp[5] + dp[1] = 17 + 10 + 1 = 28
....and so on 
 */
public class count_no_ways_to_make_i_from_nums_condition {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int y = s.nextInt();

            int[] dp = new int[y + 1];
            dp[0] = 1;
            int used = 0;

            for (int i = 1; i <= y; i++) {
                if (i - 1 >= 0) {
                    dp[i] += dp[i - 1];
                }
                if (i - 2 >= 0)
                    dp[i] += dp[i - 2];
                if (i - 4 >= 0 && used < 2)
                    dp[i] += dp[i - 4];
                if (i - 6 >= 0)
                    dp[i] += dp[i - 6];
            }

            System.out.println(dp[y]);
        }
    }

}
