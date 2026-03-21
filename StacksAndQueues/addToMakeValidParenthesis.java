package StacksAndQueues;
import java.util.*;
public class addToMakeValidParenthesis {

    public static void main (String [] args) {
        String s = "()))";
        System.out.println(minAddToMakeValid(s));

    }

    static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char curr = s.charAt(i);
            if(st.isEmpty()) {
                st.push(curr);
            }
            else if(curr == '(') {
                st.push(curr);
            }
            else if(curr == ')') {
                //check the previous
                if(st.peek() == '('){
                    st.pop();
                }
                else {
                    st.push(curr);
                }
            }
        }
        return st.size();

    }
}
