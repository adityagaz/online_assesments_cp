package StacksAndQueues;
import java.util.*;
public class minInsertionsToBalanceParenthesis {

    public static void main (String [] args) {
        String s = "())()";
        System.out.println(minInsertToMakeValid(s));

    }

    //below is wrong solution
//    static int minInsertToMakeValid(String s) {
//        Stack<Map<Character , Double>> st = new Stack<>();
//        for( int i =0 ; i < s.length() ; i++) {
//            Character ch = s.charAt(i);
//            if(st.isEmpty() ) {
//                if(ch == '(') {
//                    st.push(new HashMap<>() {{put('(' , 2.0) ;}});
//                }
//                else if(ch == ')') {
//                    st.push(new HashMap<>() {{put(')' , 0.5) ;}});
//                }
//            }
//            else if(!st.isEmpty()) {
//                if(ch == ')' && st.peek().containsKey('(')) {
//                    Double  no = st.peek().get('(');
//                    if( no > 1 ) {
//                        st.peek().put('(' , no -1 );
//                    }
//                    else {
//                        st.pop();
//                    }
//                }
//                else {
//                    if(ch == '(') {
//                        st.push(new HashMap<>() {{put('(' , 2.0) ;}});
//                    }
//                    else if(ch == ')') {
//                        st.push(new HashMap<>() {{put(')' , 0.5) ;}});
//                    }
//
//                }
//            }
//        }
//        if(!st.isEmpty()) {
//            Double answer = 0.0;
//            while(!st.isEmpty() ) {
//                answer += st.pop().values().iterator().next();
//            }
//            if(answer % 1 != 0) {
//                answer = Math.floor(answer) +2;
//            }
//            return (int) Math.floor(answer);
//        }
//        return 0;
//    }

    static int minInsertToMakeValid(String s) {
        s = s.replace("))" , "}");
        Stack<Character> st  = new Stack<>();
        int insertions = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(st.isEmpty()) {
                if(c == '(') {
                    st.push(c);
                }
                else {
                    if(c == '}') {
                        insertions++;
                    }
                    if(c == ')') {
                        insertions+=2;
                    }
                }
            }
            else {
                if(c == '(') {
                    st.push(c);
                }
                else if( c == '}') {
                    st.pop();
                }
                else if(c == ')') {
                    insertions++;
                    st.pop();
                }
            }
        }

        return insertions + st.size()*2;
    }

}
