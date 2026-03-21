package Strings;

public class remove_a {

    public static void main (String [] args) {
        String a = "bacca";
        //output : bcca

    String result = removea(a);
    System.out.println(result);


    }

    static String removea(String a ) {
        StringBuilder str = new StringBuilder();
        for(int i  = 0 ; i < a.length() ; i++) {
            if(a.charAt(i) != 'a') {
                str.append(a.charAt(i));
            }
        }

        return str.toString();
    }

    //try recursive approach
}
