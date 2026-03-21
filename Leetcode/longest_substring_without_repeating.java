package Leetcode;

public class longest_substring_without_repeating {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    public static void main ( String [] args) {
        String s  = "pwwkew";
        System.out.println(longest_sub_s_no_repeat(s));
    }

    static int longest_sub_s_no_repeat(String s) {
        if(s.length() == 0) {
            return 0;
        }
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        int result_size = 1;
        int left =0;
        int i = 1;
        while ( i < s.length()) {
            if(str.toString().indexOf(s.charAt(i)) >= 0 ) {
                str.deleteCharAt(0);
                left++;
            }
            else  {
                str.append(s.charAt(i));
                if(str.length() > result_size) result_size = str.length();
                i++;
            }
        }
    return result_size;
    }
}
