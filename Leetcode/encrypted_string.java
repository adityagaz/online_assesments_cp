package Leetcode;


public class encrypted_string {
    /*
    You are given a string s and an integer k. Encrypt the string using the following algorithm:

For each character c in s, replace c with the kth character after c in the string (in a cyclic manner).
Return the encrypted string.



Example 1:

Input: s = "dart", k = 3

Output: "tdar"

Explanation:

For i = 0, the 3rd character after 'd' is 't'.
For i = 1, the 3rd character after 'a' is 'd'.
For i = 2, the 3rd character after 'r' is 'a'.
For i = 3, the 3rd character after 't' is 'r'.
Example 2:

Input: s = "aaa", k = 1

Output: "aaa"

Explanation:

As all the characters are the same, the encrypted string will also be the same.


     */
    public static void main(String[] args) {
        String s = "aaa";
        int k = 1;
        String result = encrypted(s ,k);
        System.out.println(result);
    }

    static String encrypted (String s ,int k) {
        int rem = k % s.length();
        char arr [] = s.toCharArray();

        for(int i =0 ; i < s.length() ; i++) {
            int go_to_index = i+k;
            go_to_index %=s.length();
            arr[i] = s.charAt(go_to_index);
        }
        StringBuilder final_string = new StringBuilder();
        for (char c: arr ) {
            final_string.append(c);
        }
        return  final_string.toString();
    }
}
