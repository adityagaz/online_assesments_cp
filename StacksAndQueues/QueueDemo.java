package StacksAndQueues;
import java.util.*;
public interface QueueDemo {
    public static void main (String [] args) throws Exception {

        myQueue queue = new DynamicQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        queue.display();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        queue.display();






//        CircularQueue cqueue = new CircularQueue();
//        cqueue.push(1);
//        cqueue.push(2);
//        cqueue.push(3);
//        cqueue.push(4);
//        cqueue.push(5);
////        cqueue.push(6); //queue is full initial size is 5
//        cqueue.display();
//        cqueue.pop();
//        cqueue.push(11);
//
//        cqueue.pop();
//        cqueue.push(12);
//
//        cqueue.display();



//        CircularQueue queue = new DynamicCQueue();
//
//        queue.push(1);
//        queue.push(2);
//        queue.push(3);
//        queue.push(4);
//        queue.push(5);
//
//
//        queue.display();
//
//        queue.push(23);
//        queue.display();
//        queue.pop();
//        queue.display();
//        queue.push(30);
//        queue.display();



    }
}
