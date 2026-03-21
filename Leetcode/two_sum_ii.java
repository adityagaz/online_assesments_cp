package Leetcode;

import java.util.Arrays;

public class two_sum_ii {

    public static void main(String[] args) {
        int [] arr= {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(find_target(arr, target)));
    }
    static int [] find_target(int [] numbers , int target) {
        //we can do is a two pointer approach
        //initialize the start as 0 and end as len -1
        //now add a[s] and a[e] if they match up you got the answer
        //if sum is larger you need to go left
        //if sum is smaller you need to go right
        int start = 0;
        int end = numbers.length -1;

        while( start < end ) {
            int sum = numbers[start] + numbers[end];
            if( sum < target) {
                start++;
            }
            else if(sum > target ) {
                end--;
            }
            else {
                return new int [] {start + 1 , end+1};
            }
        }
        return new int [] {-1,-1};
    }
}
