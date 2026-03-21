package StacksAndQueues;

public class QueueusingStackDemo {

    public static void main(String [] args  ) {

        QueueUsingStack queue = new QueueUsingStack();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(  queue.empty());



    }
 }
