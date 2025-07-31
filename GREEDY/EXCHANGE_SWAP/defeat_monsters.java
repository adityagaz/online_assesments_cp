package GREEDY.EXCHANGE_SWAP;
import java.util.*;;
public class defeat_monsters {

    /*
        There are N monsters in front of you. To defeat the i-th of them you need an army of Ai soldiers, Bi of which will be killed during the battle.
Now you want to know the minimal number of soldiers you need to recruit in order to kill all the monsters.
You don't care about the order of battles: the only thing that matters is that none of the monsters will be left alive.

Input Format
The first line contains a number 

1≤T≤1e5

the number of test cases. Then 
T lines follow.

The first line of each test case contains a single integer 
1≤N≤1e5
5 the number of monsters.
the number of soldiers you need to defeat the 
i-th monster, and the number of soldiers that will be killed in the battle against him.
It is guaranteed that the sum of 
N over all test cases doesn't exceed
5 x 1e5
Output Format
For each test case, output a single integer on a new line — the minimal number of soldiers that is sufficient to kill all the monsters.

Constraints
Sample Input 1
2
2
7 4
5 1
3
4 1
6 4
5 3
Sample Output 1
8
10
Note
Explanation 1:
You need a minimum of 8 soldiers. First, you send 5 soldiers to defeat 2nd monster, after this battle you now have 7 soldiers.
Send them to battle with 1st monster.
Note that if you try to defeat monsters in order 1 - 2, then you will require 9 soldiers.

Explanation 2:
There are 3! = 6 order (of monsters) in which you can battle with monsters.
1. 1 - 2 - 3 : In this order, you will require, minimum of 10 soldiers.
2. 1 - 3 - 2 : In this order, you will require, minimum of 10 soldiers.
3. 2 - 1 - 3 : In this order, you will require, minimum of 10 soldiers.
4. 2 - 3 - 1 : In this order, you will require, minimum of 11 soldiers.
5. 3 - 1 - 2 : In this order, you will require, minimum of 10 soldiers.
6. 3 - 2 - 1 : In this order, you will require, minimum of 11 soldiers.
The minimum number of soldiers require is 10.


APPROACH --
WE HAVE A GREEDY ORDER OF OPTIMAL ORDERING --
FIRST THING THAT SHOULD STRIKE YOUR MIND IS EXCHANGE ARGUMENTS
so let's take 
    Case 1 : Kill monster 1 then monster 2
    Case 2 : Kill monster 2 then monster 1

    we need to hire minimum monsters 

     case 1 -- A1 + (A2 - (A1-B1))
    case 2  -- A2 + (A1 - (A2 - B2))

    assume case1 is optimal 
    A1 + A2 - A1 + B1 = A2 + B1 for case 1
    and similarly A1 + B2 for case 2

    a2 + b1 < a1  + b2 
    a1 - a2 > b1 - b2

    a1 - b1  > a2 - b2

    Now, we see the optimal sorting order
    sort the difference array in decreasing order
    

     */
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        
        while(t-- > 0) {
            int n = s.nextInt() ;
            int [][] arr = new int[n][2];
            for( int i = 0; i < n  ; i++ ) {
                arr[i][0] = s.nextInt();
                arr[i][1] = s.nextInt();
            }
            solve(n , arr);
        }
    }


    static void solve( int n  , int [][] arr  ) {



        Arrays.sort(arr , (a, b) -> {
            int diff1 = a[0] - a[1];
            int diff2 = b[0] - b[1];
             return diff2 - diff1;
        });

        for( int [] i : arr) {
            System.out.println(Arrays.toString(i));
        }

        long army = arr[0][0];
        long extra = arr[0][0];
        for( int i = 0 ; i < n ; i++ )  {
            if(army >=  arr[i][0]) {
                //you are good to go
                army -= arr[i][1];

            }
            else {
                //you need extra soldiers
                extra += arr[i][0] - army;
                army += arr[i][0] - army;
                army -= arr[i][1];
            }
        }

        System.out.println(extra);
    }

}
