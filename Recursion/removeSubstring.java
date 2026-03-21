package Recursion;

public class removeSubstring {

    public static void main (String [] args ) {

        String s = "abcdapplefghyappleaditya"; //output -- > abcdfghyaditya
        //remove apple from the string recursively
        //logic --> check whether the string starts with apple and if no check for the next string
        //if yes then jump the size of the characters and then check apple
        String res = removeWord(s);
        System.out.println(res);

    }

    static String removeWord(String s) {

        if(s.isEmpty()) {
            return  "";
        }

        if(s.startsWith("apple")) {
            //yes then jump the
            return removeWord(s.substring(5));
        }
        else {
                return  s.charAt(0) + removeWord(s.substring(1));
        }
    }


}
