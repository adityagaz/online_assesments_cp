package Recursion;

public class remove_a_recursion {

    public static void  main (String [] args) {

        String s = "baccad";
        StringBuilder str = new StringBuilder();
        String res = removesa(s, str , 0);
        System.out.println(res);

    }

    static String removesa(String s , StringBuilder str , int i ) {
        if( i == s.length() ) {
            return str.toString();
        }
        if(s.charAt(i) != 'a') {
            str.append(s.charAt(i));
            return removesa(s,str,i+1);
        }
        return removesa(s ,str, i+1);
    }

}
