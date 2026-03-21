package sts;

public class hyphenAtFront {

    public static void main (String [] args ) {
        String s= "Code-4-lyf";
        char [] str = s.toCharArray();
        hyphensToFront(str);
        System.out.println(String.valueOf(str));
     }
     static void hyphensToFront(char [] str) {
        int i = 0 ;
        for( int  j = i  ;  j <str.length ; j++ ){
            if(str[j] == '-') {
                char temp = str[i];
                str[i++] = '-';
                str[j] = temp;
            }
        }
     }
}
