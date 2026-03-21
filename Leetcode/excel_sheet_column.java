package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class excel_sheet_column {/*
171. Excel Sheet Column Number
Easy
Topics
Companies
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...


Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701

*/
    public static void main(String[] args) {
        String s = "AAAB";
        char [] arr= s.toCharArray();
        System.out.println(column_number(s));


    }
    static  int column_number (String s) {
        HashMap<Character ,Integer> map = new HashMap<>();
        char c ='A';
        for (int i = 1; i <=26; i++) {
            map.put(c++ , i );
        }
        char [] arr= s.toCharArray();
        int index = arr.length-1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = map.get(arr[i]);
            sum += (int) Math.pow(26 , index) * value;
            index--;
        }
    return  sum;
    }

}
