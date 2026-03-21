package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class excel_sheet_title {
    /*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28
...
     */

    public static void main(String[] args) {

        System.out.println(convertToTitle(52));
//        System.out.println(700%26);

    }

    static String convertToTitle(int number){
        ArrayList<Character> list = new ArrayList<>();
        while ( number  >0 ) {
            number--; //this is the trick
            int remainder = number % 26;
            number = number /26;
            list.add((char)( remainder + 'A'));
        }
        StringBuilder output_string  = new StringBuilder();
        for (int i = list.size() -1 ; i >= 0 ; i--) {
            output_string.append(list.get(i));
        }
        return output_string.toString();
    }
}
