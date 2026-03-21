package Leetcode;

public class longest__plaindrome_checking {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(max_string(s));
    }
//bro your came up with this solution by your own that is nicee!!
    //you are progressing
    static String max_string(String s) {
        int max = 0 ;
        StringBuilder str = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for( int window_size = s.length() ; window_size >=1  ; window_size--){
            str.replace(0 , str.length() , "");
            //calculate for window size 1
            for( int i = 0 ; i <window_size ; i++ ){
                str.append(s.charAt(i));
            }
            if(palindrome_checker(str.toString())){
                if(str.length() > max) {
                    result.replace(0, result.length() , str.toString());
                    max = str.length();
                    return result.toString();
                }
            }
            for( int i  = window_size ; i < s.length() ; i++ ){
                str.replace(0 , 1 , "");
                str.append(s.charAt(i));
                if(palindrome_checker(str.toString())){
                    if(str.length() > max) {
                        result.replace(0, result.length() , str.toString());
                        max = str.length();
                        return result.toString();
                    }
                }
            }
        }
        return result.toString();
    }

    static boolean palindrome_checker (String s ) {

        if(s.isEmpty()) return false;
        int i = 0 ;
         int  j =s.length() -1;
         while(i < j ) {
             if(s.charAt(i) != s.charAt(j)) {
                 return false;
             }
             i++;
             j--;
         }
         return true;
    }
}
