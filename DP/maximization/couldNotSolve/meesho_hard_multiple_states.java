package maximization.couldNotSolve;
import java.util.*;



/*
  PROBLEM :
    MEESHO : 33 LPA

    https://leetcode.com/discuss/post/6719472/meesho-oa-sde-1-by-anonymous_user-20ol/

    A supercomputer has several processors to deploy for execution. They are arranged sequentially in a row from 1 to n. The efficiency of each processor depends on the order of deployment of its adjacent processors.
For the ith processor, the efficiency of the ith processor is no_adjacent[i], one_adjacent[i], or both_adjacent[i], depending on whether neither, one, or both adjacent processors are deployed before it.
Find the maximum possible sum of efficiencies among all possible orders of deployment.
Note: The first and nth processors can only have one adjacent processor.
Example
n=4
no_adjacent = [1, 2, 3, 4]
one_adjacent = [4, 4, 2, 1]
both_adjacent = [1, 1, 1, 1]

Consider the following orders of deployment (1-based indexing):
If the deployment sequence is (1->3->4->2), the sum of efficiencies-no adjacent(1) + no adjacent[3] + one adjacent(4) + both adjacent(2) = 1+3+1+1 = 6
(4-2-1-3), no adjacent[4]+no adjacent[2]+one adjacent[1]+ both adjacent[3]-4+2+4+1=11.
Let the deployment sequence be (4->3->2->1), по adjacent[4] + one adjacent[3]+one_adjacent(2) one adjacent(1)-4+2+4+4=14.
Similarly, other deployment orders can be performed.

Amongst all possible deployments, the maximum possible sum of efficiencies is 14.

Function Description
Complete the function getMaximumSum in the editor with the following parameters:
int no adjacent[n]: an array of integers
int one adjacentin): an array of integers
int both adjacent(n): an array of integers

Returns
long int the maxximum possible sum of efficiencies
Constraints

Sample Case O
Sample Input For Custom Testing
STDIN
FUNCTION
no adjacent[] size n = 3
no adjacent [2, 1, 3]

one adjacent[] size n = 3
one adjacent [4, 2, 1]

both adjacent[] size n=3
both adjacent [1, 2, 3]

Sample Output
9

test cases -
4
1 2 3 4
4 4 2 1
1 1 1 1

Ans - 14

3
2 1 3
4 2 1
1 2 3

Ans - 9 


at every index i we can check that whether the prev element was taken or not
if prev element was taken then we can select the max from (one_adj or two_adj) + ans[prev_index]
if prev element was not taken then we can select the max from (no_elem , one_adj , two_adj) + ans[prev_index]

state -- dp[best_ans_at_i][prev_Selected_or_not][next_selected_or_not]
            dp[i][0][0] - best answer at i if prev and next both are not selected
            dp[i][0][1] - best answer at i if prev is not selected and next is selected
            dp[i][1][0] - best answer at i if prev is selected and next in not selected
            dp[i][1][1] - best answer at i if prev and next both are selected
for i = 1
dp[1][0][0] = next is not selected = dp[1][0][0] = no_adj[1]
dp[1][1][0] = next is not selected = no_adj[1]

dp[1][0][1] = next is selected = one_adj[1]
dp[1][1][1] = next is selected = one_adj[1]

for i=N
dp[4][0][0] = second last is not selected = no_adj[3]
dp[4][0][1] = second last is not selected = no_adj[3]

dp[4][1][0] = second last is selected = one_adj[3]
dp[4][1][1] = second last is selected = one_adj[3]


Now comes the part

dp[2][0][0] --> means neither 1 or 3 are selected so = no_adj[2]
dp[2][1][1] --> means both 1 and 3 are selected so = both_adj[2]
dp[2][0][1] --> means 3 is selected so one_adj[2]
dp[2][1][0] --> means 1 is selected so one_adj[2]

 
dp[i][0][0] == means node i is getting visited after both i+1 and i-1 are visited (i-1 --> i+1 --> i)
Now,  what it also means that i-1 is already visited so the connection from the prev state is 
dp[i-1][1][1] == i-1 is selected before i is visited and i-2 is visited (i-1 --> i-2 --> i)
Since what is visited in between does not matter we anyways have to select one_adj

so, we can say dp[i][0][0] = no_adj[i] + dp[i-1][1][1]

dp[i][0][1] = says  (i+1 -> i -> i-1)
dp[i-1][0][1] = says (i -> i-1 -> i-2)

therefore dp[i][0][1] = one_adj[i] +  dp[i-1][0][1] 

dp[i][1][0] = means node i is selected after i-1 is selected and i+1 is not selected i-1 -> i -> i-2
dp[i-1][1][0] = (i-2 --> i-1 --> i ) 

dp[i][1][0] = one_adj[i] + dp[i-1][1][0] 

dp[i][1][1] = means node i is selected after i-1 , i+1 are selected
i+1 -> i-1 -> i 
dp[i-1][0][0] = i-1 -> i -> i-2 or i-1 -> i-2 -> i
any ways i-1 is selected before i
dp[i-1][1][1] = both_adj[i] + dp[i-1][0][0] 


Now,
Final algo.....


dp[1][0][0] = no_adj[1];
dp[1][0][1] = one_adj[1];
dp[1][1][0] = one_adj[1];
dp[1][1][1] = both_adj[1];

[i][0][0]:
    i+1 -> i-1 -> i
    i-1 -> i+1 -> i

[i-1][1][1]:
    i-1 -> i -> i-2
    i-1 -> i-2 -> i

[i-1][0][1]:
    i -> i-1 -> i-2
    i -> i-2 -> i-1




for i = 2 to N:
(assume 1 based indexing) 
    dp[i][0][0] = no_adj[i] +  dp[i-1][1][1]; 
    dp[i][0][1] = one_adj[i] + dp[i-1][0][1];
    dp[i][1][0] = one_adj[i] + dp[i-1][1][0];
    dp[i][1][1] = both_adj[i] + dp[i-1][0][0];

return Max(dp[n][0][0] , dp[n][0][1] , dp[n][1][0] , dp[n][1][1]);



 */
public class meesho_hard_multiple_states {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] no = new int[n+1];
        int [] one = new int[n+1];
        int [] both = new int[n+1];

        for( int i= 1 ; i <= n; i++) no[i]=s.nextInt();
        for( int i= 1 ; i <= n; i++) one[i]=s.nextInt();
        for( int i= 1 ; i <= n; i++) both[i]=s.nextInt();

        int [][][] dp = new int [n+1][2][2];
        dp[1][0][0] = no[1]; 
        dp[1][0][1] = one[1]; 
        dp[1][1][0] = Integer.MIN_VALUE; 
        dp[1][1][1] = Integer.MIN_VALUE; 

        for( int i = 2; i<=n ; i++ ) {
            dp[i][0][0] = no[i] + Math.max(dp[i-1][1][1] , dp[i-1][0][1]);
            dp[i][0][1] = one[i] + Math.max(dp[i-1][1][1] , dp[i-1][0][1]);
            dp[i][1][0] = one[i] + Math.max(dp[i-1][0][0] , dp[i-1][1][0]);
            dp[i][1][1] = both[i] + Math.max(dp[i-1][0][0] , dp[i-1][1][0]);
        }

        dp[n][0][1] = Integer.MIN_VALUE;
        dp[n][1][1] = Integer.MIN_VALUE;
        System.out.println(Math.max(Math.max(dp[n][0][0], dp[n][1][0]) , Math.max(dp[n][0][1], dp[n][1][1])));
    }
    
}
