package StacksAndQueues;

public class mystack {
    public int [] arr;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    //static because it will be the same for all objects of the class
    //private because i donot want people to access it from outside
    //final because i myself donot want to change it hereafter

    public mystack(int size) {
            this.arr = new int [size];
    }

    public mystack () {
        //if no size is passed then
//            this.arr = new int [DEFAULT_SIZE];
            //another way to do it
        this(DEFAULT_SIZE);
    }

    public void display() {

        System.out.print("[");
        for( int i =0 ; i <= ptr ; i++) {
            if(i != ptr){
                System.out.print(arr[i] + ", ");
            }
            else {
                System.out.print(arr[i] + "");
            }
        }
        System.out.print("]");
    }

    public boolean  push  ( int val) throws Exception {
        if(isFull()){
            throw new Exception ("Stack is full");
        }
        ptr++;
        arr[ptr] = val;
        return true;
    }
    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Cannot pop from an empty stack");
        }
        return arr[ptr--];
    }

    public int peek() throws Exception {
        //just check what is at the top and do not delete anything

        if(isEmpty()) {
            throw new Exception ("Cannot peek in an empty stack ");
        }
        return arr[ptr];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr == arr.length -1;
    }

}
