package Leetcode;

public class valid_parenthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(checker(s));;

    }

    static boolean checker (String s) {
        int top =-1;

        char arr [] = new char[s.length()];
        for (char i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if(character == '(' || character == '{' || character == '[') {
                arr[++top] = character;
            }
            else{
                if(top == -1) {
                    return false;
                }
                char top_character = arr[top--];
                if( (top_character == '(' && character == ')') ||
                        (top_character == '{' && character == '}')
                        || (top_character == '[' && character == ']') ){
                }
                else {
                    return false;
                }
            }
        }
        return top==-1;
    }
}
