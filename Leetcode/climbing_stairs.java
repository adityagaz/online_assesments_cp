package Leetcode;

public class climbing_stairs {
    /*
    You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

     */

    public static void main(String[] args) {

        int num = 3;
        int memory[]  = new int[num+1];
        for( int i  = 0 ; i < memory.length ; i++ ){memory[i] =-1;
        }
        System.out.println(possible_combinations(num , memory));



    }
    static int possible_combinations (int num , int [] memory ) {
        if (memory[num] != -1 ){
            return memory[num];
        }
        //memoization part
        if(num  < 0 ) {
            return  0;
        }
        if(num == 0) {
            return 1;
        }

        memory[num] = possible_combinations(num -1 , memory) + possible_combinations(num-2 , memory);
        return memory[num];
    }

}
