package Leetcode;
import java.util.ArrayList;
import java.util.List;
/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space.
 */
public class lexicograhicNumbers {
    public static void main (String [] args) {
        int n = 13;
//        Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
        System.out.println(lexicalOrder(13));
        System.out.println(kthSmallestLexicographicalOrder(13, 2 ));

    }
    static List<Integer> lexicalOrder(int n  ) {
        List<Integer> ans = new ArrayList<>();

        int curr =1;
        for( int i =0 ; i < n ; i++) {
            ans.add(curr);
            if(curr *10 <= n)
            {
                curr*=10;
            }
            else {
                while(curr %10 == 9 || curr >= n){
                    curr /=10;
                }
                curr +=1;
            }
        }
        return ans;
    }

    static int kthSmallestLexicographicalOrder(int n , int k ) {
        List<Integer> nums = lexicalOrder(n);
        return nums.get(k-1);
    }
}
