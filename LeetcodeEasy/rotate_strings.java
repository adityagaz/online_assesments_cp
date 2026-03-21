package LeetcodeEasy;
import com.sun.jdi.event.StepEvent;

import java.util.*;
public class rotate_strings {
    public static void main(String[] args) {

        String s = "abcde";
        String goal = "cdeab";
        System.out.println(can_become_goal(s , goal));
    }

    static boolean  can_become_goal (String s , String goal) {

        HashMap<Integer ,Integer> map = new HashMap<>();
        Deque<Character> check = new ArrayDeque<>();

        for(int j = 0 ; j < goal.length() ; j++ ) {
            check.add(goal.charAt(j));
        }
        int k =  goal.length() -1;

        while(k >= 0 ) {
            Character ch = check.pollFirst();
            check.addLast(ch);
            StringBuilder str = new StringBuilder();
            for(Character i : check) {
                str.append(i);
            }
            String temp = str.toString();

            if(temp.equals(s)) {
                return true;
            }
            k--;
        }
        return false;
    }
}
