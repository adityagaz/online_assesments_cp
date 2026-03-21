package Leetcode;
import java.lang.reflect.Array;
import java.util.*;
public class GridGame {
    public static void main(String[] args) {

        int[][] mat = {
                {3,3,1}, {8,5,2}
        };
        System.out.println(minGrid(mat));
    }

    static long minGrid(int [][] grid )  {
        int b_sum= 0;
        int t_sum = 0;
        int [] t_sum_prefix = new int[grid[0].length];
        int [] b_sum_prefix = new int[grid[0].length];
        for( int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                if(i==0) {
                    t_sum+=grid[i][j];
                    t_sum_prefix[j] = t_sum;
                }
                else {
                    b_sum +=grid[i][j];
                    b_sum_prefix[j] = b_sum;
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for( int i = 0 ; i < grid[0].length ; i++ ) {
            int player_2_sum = 0;
            if(i ==0 ) {
                player_2_sum = Math.max(t_sum - t_sum_prefix[i] , 0);
            }
            else {
                player_2_sum = Math.max(b_sum_prefix[i-1] ,t_sum - t_sum_prefix[i]);
            }
            ans = Math.min(ans , player_2_sum);
        }
        return ans;
    }
}

