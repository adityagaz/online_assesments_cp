package StacksAndQueues;
import java.util.*;
public class DiscountedShop {
    /*
    You are given an integer array prices where prices[i] is the price of the ith item in a shop.

There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.

Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.


     */

    public static void main(String [] args) {

        int [] prices = {8,4,6,2,3};
        System.out.println(Arrays.toString(discounted_nearest_to_right(prices)));
    }

    static int [] discounted_nearest_to_right(int [] arr) {
        Stack<Integer> st = new Stack<>();
        int [] ans = new  int[arr.length];
        for( int i = arr.length -1 ; i >=0 ; i--)
        {
            if(st.isEmpty())
            {
                //initially put
                ans[i] = arr[i];
            }
            else if(!st.isEmpty() && st.peek() <= arr[i])
            {
                ans[i] = arr[i] - st.peek();
            }
            else if(!st.isEmpty() && st.peek() > arr[i])
            {
                while(!st.isEmpty() && st.peek() > arr[i])
                {
                    st.pop();
                }
                if(st.empty()) {
                    ans[i] = arr[i];
                }
                else {
                    ans[i] = arr[i] -st.peek();
                }
            }
            st.push(arr[i]);
        }

        return ans;
    }
}
