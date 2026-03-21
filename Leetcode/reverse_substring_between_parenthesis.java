package Leetcode;

import java.util.*;

public class reverse_substring_between_parenthesis {
    /*
    1190. Reverse Substrings Between Each Pair of Parentheses
Medium
Topics
Companies
Hint
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.
Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.

     */
    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseString(s));
    }
    static String reverseString ( String s ) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                int open = stack.pop();
                reverse(arr, open + 1, i - 1);
            }
        }

        StringBuilder finalString = new StringBuilder();
        for (char c : arr) {
            if (c != '(' && c != ')') {
                finalString.append(c);
            }
        }
        return finalString.toString();
    }

    static void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
