package Strings;

public class basic {
    public static void main(String[] args) {
        String s  = "HELLO";
        System.out.println(encoded(s));
    }
    

    static String encoded(String s ){
        String result = "";
        StringBuilder str =  new StringBuilder();
        for (int i = 1 ; i <= s.length() ; i++){
            if(i%2==0) {
                str.append((char)(s.charAt(i-1) -1));
            }
            else{
                str.append((char)(s.charAt(i-1) +1));
            }
        }
        return str.toString();
    }
}
