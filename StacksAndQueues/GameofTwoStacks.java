package StacksAndQueues;
import java.util.*;

public class GameofTwoStacks {

    public static void main (String [] args) {

        Scanner scanner = new Scanner(System.in);

        // Read the number of games
        int games = scanner.nextInt();

        for (int i = 0; i < games; i++) {
            // Read n, m, and maxSum
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int maxSum = scanner.nextInt();

            // Read the elements of stack 1
            List<Integer> st1 = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                st1.add(scanner.nextInt());
            }

            // Read the elements of stack 2
            List<Integer> st2 = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                st2.add(scanner.nextInt());
            }

            // Run the function and print the result
            int[][][] memo = new int[n + 1][m + 1][maxSum + 1];
            for (int[][] rows : memo) {
                for (int[] row : rows) {
                    Arrays.fill(row, -1); // Fill with -1 indicating uncomputed values
                }
            }

            // Run the function and print the result
            System.out.println(twoStacks(st1, st2, maxSum, 0, 0, 0, memo));
        }
    }
    static int twoStacks(List<Integer> s1 , List<Integer> s2 , int maxSum  , int count , int top1 , int top2 ,int[][][] memo){
        //base case

        if(maxSum < 0 ){
            return count -1;
        }
        if(top1 == s1.size() || top2 == s2.size()) {
            if(maxSum == 0) {
                return count;
            }
            else {
                return 0;
            }

        }
        if (memo[top1][top2][maxSum] != -1) {
            return memo[top1][top2][maxSum];
        }

        return memo[top1][top2][maxSum] = Math.max(twoStacks(s1 , s2, maxSum - s1.get(top1) ,count+1 ,  top1+1 , top2 , memo) ,
                twoStacks(s1 ,s2, maxSum - s2.get(top2) , count+1 , top1 , top2+1 , memo));
    }
}
