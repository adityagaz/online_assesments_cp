package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class asteriod_collision {
    public static void main(String[] args) {
        int input_arr[] = {10,2,-5};
        System.out.println(Arrays.toString(asteriodCollison(input_arr)));

    }

    static int[] asteriodCollison(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();
        //asteriod[i] != 0 <-- note these so we don't have to make an else if
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                stack.push(arr[i]);
            }
            else if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    if (Math.abs(arr[i]) > stack.peek()) {
                        stack.pop();
                    } else if (Math.abs(arr[i]) == stack.peek()) {
                        stack.pop();
                        break;
                    } else {
                        break;
                    }
                    if (stack.isEmpty()) list.add(arr[i]);
                }
            }
            else{
                list.add(arr[i]);
            }
        }

        int answer[] = new int[list.size() + stack.size()];
        for(int i = 0 ; i < stack.size() ; i++){
            list.add(stack.get(i));
        }
        for (int i  = 0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
        }
    }
