package StacksAndQueues;
import java.util.*;
public class ValidParenthesis {

    public static void main (String [] args){
        String s = "{([])}";
        System.out.println(ispar(s));
    }

    static boolean ispar(String x)

    {
        // add your code here
        Stack<Character> stack = new Stack<>();
        for( int i = 0 ; i < x.length() ; i++) {

            char ch = x.charAt(i);
            if( ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                int peek = stack.peek();
                if(ch ==')' && peek =='(' || ch =='}' && peek == '{' || ch ==']' && peek =='[') {
                    stack.pop();
                }
                else{
                    return false;
                }
            }

        }
        if(stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }
}
