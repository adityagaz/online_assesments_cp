package Strings;

public class Stringbuilder {
    public static void main (String [] args) {
        StringBuilder s = new StringBuilder("1234");
        s.deleteCharAt(s.length() -1);
        s.append("4");
        System.out.println(s);
    }
}
