package StacksAndQueues;
import java.util.*;
public class Basic {

    public static void main (String [] args){
        //stack implements the stack class
        //queue is from LinkedList Class
        //dequeue is from ArrayDequeue class

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.pop();
        stack.peek(); //donot delete just look at the last element


        Queue<Integer>  queue = new LinkedList<>();

        queue.add(5); //adds to the last of the queue
        queue.remove(); //removes from the first place of the queue

        Deque<Integer> deque = new ArrayDeque<>();
        //insertions and deletions can happen from both the sides
        deque.addFirst(5);
        deque.removeFirst();
        deque.addLast(10);
        deque.removeLast();




    }
}
