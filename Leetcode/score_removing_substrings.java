package Leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class score_removing_substrings {
    /*
    You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.



Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
     */

    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x = 4; //remove ab
        int y = 5; //remove ba
        System.out.println(maximumGain(s , x, y));
    }

    static  int maximumGain (String s , int x , int y  ) {
        //removing the greater priority element
        int total_gain= 0;
        if (x >y ){
             total_gain = remove(s , 'a' , 'b',  x );
             total_gain += remove(s , 'b' , 'a',  y );
        }
        else {
            total_gain = remove(s , 'b' ,'a' , y );
            total_gain = remove(s , 'a' ,'b' , x );
        }
        return total_gain;
    }

    static  int remove(String s, char first , char second  ,int cost ) {
        int gain =0;
        Stack<Character> stack = new Stack<>();
        for( int i = 0 ; i < s.length() ; i++ ){
            char current = s.charAt(i);
            if(current != second) {
                stack.push(current);
            }
            else if(current == second) {
                char top = stack.peek();
                if(top == first && !stack.isEmpty()){
                    stack.pop();
                    gain +=cost;
                }
                else {
                    stack.push(current);
                }
            }
        }
        s = stack.toString();
        System.out.println(s);
        return gain ;

    }



}
