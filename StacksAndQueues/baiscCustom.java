package StacksAndQueues;
import java.util.*;
public class baiscCustom {

    public static void main (String [] args) throws Exception {
        mystack stack = new mystack(5);

        //a stack is created in the memory
//        stack.push(10);
//        stack.push(10);
//        stack.push(10);
//        stack.push(10);
//        stack.push(10);
//        stack.push(10); // push expection because the stack is fixed and it is not dynamic
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        //now we import a dynamic stack

        DynamicStack stack2 = new DynamicStack(5);
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);
        stack2.push(40);
        stack2.push(50);
        stack2.push(60);
        stack2.push(70);

        stack2.display();

        //we can also initialize the Dynamic stack using child or the class that extends the parent class
        //parent name can be used in the left side to call the
        mystack stack3 = new DynamicStack(5);

    }
}
