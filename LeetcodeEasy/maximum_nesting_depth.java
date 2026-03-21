package LeetcodeEasy;

import java.util.Stack;

public class maximum_nesting_depth {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(max_nested_depth(s));
    }

    static int max_nested_depth ( String s  ) {
        int max = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length() ; i++ ){
            Character ch = s.charAt(i);
            if( ch == '(') {
                stack.push(ch);
            }
            else if(ch == ')'  ) {
                stack.pop();
            }
            if(stack.size() > max) {
                max = stack.size();
            }
        }

        return max;
    }
}
