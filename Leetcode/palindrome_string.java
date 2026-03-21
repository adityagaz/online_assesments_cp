package Leetcode;
import java.util.*;

public class palindrome_string {
    public static void main(String[] args) {
        String s = "1b1";

        System.out.println(isPalindromeString(s));
    }
    static boolean isPalindromeString(String s){
        if (s == " "){
            return true;
        }
        ArrayList<Character> charlist = new ArrayList<>();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)) {
                charlist.add(Character.toLowerCase(c));
            }
        }
        int size = charlist.size();

        for ( int i = 0 , j = size-1; i <= size/2 && j>=size/2 ; i++ , j-- ){
            int front = charlist.get(i);
            int rear = charlist.get(j);
            if (front!=rear){
                return false;
            }
        }
        return true;
    }
}
