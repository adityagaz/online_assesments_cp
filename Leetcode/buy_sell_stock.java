package Leetcode;

public class buy_sell_stock {
    /*
leetcode 121

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because
you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


*/
    public static void main(String[] args) {
        int [] arr = {7,1,5,3,6,4};
        int []  arr2 = {1,2};
        //logic
        System.out.println(max_profit(arr2));
        //start iterating from 1st element and then if the next element is greater than that then only calculate the
        //difference and store it in an variable similarly iterate through the whole array.
    }
    static int max_profit(int [] arr) {
//        int max_profit_value =Integer.MIN_VALUE;
//        for (int i = 0; i < arr.length-1; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i+1; j < arr.length ; j++) {
//                int value= 0;
//                if(arr[j] > arr[i]){
//                    value = arr[j] -arr[i];
//                }
//                if (value > max) {
//                    max =value;
//                }
//            }
//            if(max > max_profit_value) {
//                max_profit_value =max;
//            }
//        }
//        return max_profit_value == 0 ? 0 : max_profit_value;

                int max_profit_value =0;
                int min_value = arr[0];
                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] < min_value) {
                        min_value = arr[i];
                    }
                    else if (arr[i] - min_value  > max_profit_value ) {
                        max_profit_value = arr[i] - min_value;
                    }
                }
                return max_profit_value;
    }
}
