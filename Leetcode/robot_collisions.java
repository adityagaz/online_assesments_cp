package Leetcode;

import javax.print.DocFlavor;
import java.util.*;

public class robot_collisions {
    public  static void main(String[] args) {
        int positions []  = {11,44,16};
        int healths []  = {1,20,17};
        String directions = "RLR";
        System.out.println(survivedBotsHealths(positions , healths , directions));
    }

    static List<Integer> survivedBotsHealths(int [] positions  , int healths [] , String directions) {
        List<Integer> answer = new ArrayList<>();


        //revisit this bruhh~~

        //watch this ->> https://www.youtube.com/watch?v=fGVIHtJ2DS8 and improve
        //btw my algo and thinking is correct

        if(positions.length == 1) {
            int value = (Integer) healths[0];
            answer.add(value);
            return answer;
        }
        HashMap<Integer ,Integer> position = new HashMap<>();
        HashMap<Integer ,Integer> health = new HashMap<>();
        HashMap<Integer ,Character> direction = new HashMap<>();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> robot_no = new Stack<>();

//        int []  arr = new  int[positions.length];
        ArrayList<Integer> arr = new ArrayList<>();
        for( int i =0 ; i < arr.size() ; i++ ){
            arr.add(positions[i]);
        }
        Collections.sort(arr);

        while (directions.contains("RL")){
            for(int i = 0; i < positions.length ; i++) {
                position.put(positions[i], i+1);
                health.put(i+1 , healths[i]);
                Character c = directions.charAt(i);
                direction.put(i+1 , c);
            }
            for(int i = 0 ;i < arr.size() ; i++) {
                int key_value = position.get(arr.get(i));
                char direc = direction.get(key_value);
                if(direc == 'L' && stack.peek() == 'R' && !stack.isEmpty()){

                    if(health.get(key_value) > health.get(robot_no.peek())){
                        health.put(key_value , health.get(key_value) -1);
                        health.remove(robot_no.peek());
                    }
                    else if( health.get(key_value) == health.get(robot_no.peek())){
                        health.remove(robot_no.peek());
                        health.remove(key_value);
                    }
                    else{
                        health.put(robot_no.peek() , health.get(robot_no.peek()) -1);
                        health.remove(key_value);
                    }
                    stack.pop();
                    robot_no.pop();
                    arr.remove(key_value-1);
                    directions = directions.substring(0 ,key_value-1) + directions.substring(key_value);

                }
                else {
                    stack.push(direc);
                    robot_no.push(key_value);
                }
            }
        }


        for (int i : health.values()){
            answer.add(i);
        }
        return answer;
    }
}
