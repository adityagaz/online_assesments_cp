package Leetcode;

import Arrays.Arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class even_and_odd {
    /*
    leetcode 2595
    You are given a positive integer n.

Let even denote the number of even indices in the binary representation of n with value 1.

Let odd denote the number of odd indices in the binary representation of n with value 1.

Note that bits are indexed from right to left in the binary representation of a number.

Return the array [even, odd].



Example 1:

Input: n = 50

Output: [1,2]

Explanation:

The binary representation of 50 is 110010.

It contains 1 on indices 1, 4, and 5.

Example 2:

Input: n = 2

Output: [0,1]

Explanation:

The binary representation of 2 is 10.

It contains 1 only on index 1.


     */

    public static void main(String[] args) {


//        System.out.println(1/2);
        Scanner in=  new Scanner(System.in);
        System.out.println("enter the number");
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while(n >0 ) {
            int remainder = n % 2 ;
            list.add(remainder);
            n /=2;
        }
        int start = 0 ;
        int end = list.size() -1 ;
        while (start  < end) {
             int temp = list.get(start);
             list.set(start , list.get(end));
             list.set(end , temp);
             start++;
             end -- ;
        }
        System.out.println(list);
        System.out.println(evenAndodd(list));
    }
    static ArrayList<Integer> evenAndodd (ArrayList<Integer> list){
        int even_count=0;
        int odd_count=0;
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = list.size()-1; i >=0 ; i -= 2) {
            if(list.get(i) == 1 ) {
                even_count++;
            }
            if(i > 0) {
                if(list.get(i-1) == 1) {
                    odd_count++ ;
                }
            }
        }
        count.add(even_count);
        count.add(odd_count);
        return count;
    }
 }
//this submission took me 3ms of time not an optimal approach


