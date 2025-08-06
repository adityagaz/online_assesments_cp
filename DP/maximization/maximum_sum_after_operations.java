package maximization;
import java.util.*;

import TREES.max_alternating_sum_at_each_node_from_root;
public class maximum_sum_after_operations {
    public static void main(String[] args) {
        // ctrl D -- select the word being clicked at --> to select all instances ctrl + F2
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int q  =s.nextInt();
            int []  nums = new int[q];
            char [] ops = new char[q];
            for( int i = 0 ; i < q  ; i++  ){
                char op = s.next().charAt(0);
                if(op == 'N') {
                    nums[i] = 0;
                }
                else {
                    int num = s.nextInt();
                    nums[i]=num;
                }
                ops[i] = op;
                
            }
            solve(nums , ops);
        }
    }

    static long solve(int [] nums ,  char [] ops ) {
        long ans =1;
        int n = nums.length;
        long [] dp_min = new long[n+1];
        long [] dp_max = new long[n+1];

        dp_max[0] =1;
        dp_min[0] =1;
        for( int i = 1 ; i <= n ; i++) {
            char op = ops[i-1];
            int num = nums[i-1];
            if(op == '+') {
                dp_max[i] = Math.max( dp_max[i-1] , num + dp_max[i-1]);
                dp_min[i] = Math.min( dp_min[i-1] , num + dp_min[i-1]);
            }
            else if (op == '-') {
                dp_max[i] = Math.max( dp_max[i-1] , dp_max[i-1] -num);
                dp_min[i] = Math.min( dp_min[i-1] ,  dp_min[i-1] - num);    
            }
            else if (op == '*') {
                dp_max[i] = Math.max( dp_max[i-1] , num  * dp_max[i-1]);
                dp_min[i] = Math.min( dp_min[i-1] , num *  dp_min[i-1]);
            }
            else if (op == '/') {
                dp_max[i] = Math.max( dp_max[i-1] ,  dp_max[i-1] / num);
                dp_min[i] = Math.min( dp_min[i-1] , dp_min[i-1] / num);

            }
            else if (op == 'N') {
                dp_max[i] = Math.max(dp_max[i-1] , -1*dp_min[i-1]);
                dp_min[i] = Math.min(dp_min[i-1] , -1*dp_max[i-1]);

            }
        }
        System.out.println(dp_max[n-1]);
        return dp_max[n-1];
    }
}   
