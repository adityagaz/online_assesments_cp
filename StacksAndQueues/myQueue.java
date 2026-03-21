package StacksAndQueues;
import java.util.*;

public class myQueue {

    protected int [] arr;
    private static final int  DEFAULT_SIZE = 5;
    protected int ptr = 0;
    //we can use ptr = -1 and increment the ptr and add the data or add the data and then increment
    //the pointer

    public myQueue()
    {
        this(DEFAULT_SIZE);
    }

    public myQueue(int val)
    {
        this.arr = new int [val];
    }


    public void push(int val) throws Exception
    {
        if(isFull()) {
            throw new Exception ("Queue is full");
        }

        arr[ptr++] = val;
    }
     public boolean isFull()
     {
        return ptr == arr.length;
     }

     public boolean isEmpty()
     {
        return ptr == 0;
     }

     public int pop() throws Exception
     {
         //pops the element from the front of the queue;
            if(isEmpty()) {
                throw new Exception("Cannot pop from an empty queue");
            }
           int popped= arr[0];

            //shift the elements to the left
            for( int i = 1 ;i < ptr ;i++) {
                arr[i-1] = arr[i];
            }
            ptr--;
            return popped;
     }

     public int peek () throws Exception {

        //take a look at the queue
         if(isEmpty()) {
             throw new Exception ("Queue is empty ");
         }

         return arr[0];
     }

     public void display() throws Exception {
        if(isEmpty()) {
            throw new Exception ("Queue is empty ");
        }

        System.out.print("[");
        for(int i = 0 ;i < ptr ; i++) {
            if(i != ptr-1){
                System.out.print(arr[i] + ", ");
            }else {
                System.out.print(arr[i]);
            }
        }
         System.out.print("]");

     }
}
