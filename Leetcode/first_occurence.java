package Leetcode;

public class first_occurence {
    /*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

     */
    public static void main(String[] args) {

        String s1= "mississippi";
        String key = "issip";
        String key2 = "issip ";
        System.out.println(first_index_occur(s1,key));
        System.out.println();

    }
    static  int first_index_occur (String s1 , String key ) {
        int start = 0;
        int key_start =0;
        int end  = key.length() -1;
        while (end < s1.length()) {
            for (int i = start ; i <= end; i++) {
                if (s1.charAt(i) == key.charAt(key_start)) {
                    key_start ++;
                }
                else {
                    key_start = 0;
                    break;
                }
            }
            if(key_start == key.length()) {
                return start;
            }
            start++;
            end ++;
        }
        return -1;
    }
}
