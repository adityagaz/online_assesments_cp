package StacksAndQueues;
import java.util.*;
public class QueueUsingStack{

    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);
    }

    public int pop() {
        while(!first.isEmpty())
        {
            second.push(first.pop());
        }
        int popped = second.pop();

        //revert the changes
        while(!second.isEmpty())
        {
            first.push(second.pop());

        }

        return popped;
    }

    public int peek() {
        while(!first.isEmpty())
        {
            second.push(first.pop());
        }
        int peak = second.peek();

        //revert the changes
        while(!second.isEmpty())
        {
            first.push(second.pop());

        }

        return peak;

    }

    public boolean empty() {
        return first.isEmpty();
    }
}
