package StacksAndQueues;

public class CircularQueue {

    //insertion and deletion O(1) both

    protected int[] arr;
    private static final int DEFAULT_SIZE = 5;
    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    public CircularQueue()
    {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int val)
    {
        this.arr = new int[val];
    }

    public void display() throws Exception {
        if(isEmpty()) {
            throw new Exception ("Cannot print an empty queue");
        }
        int i = front;
        System.out.print("[");
        //print from the front to the end

        //we are using a do while loop because if front and end are at the same position
        int count = 0;
        do {
            count++;
            if(count != size) {
                System.out.print(arr[i] + ", ");
            }
            else{
                System.out.print(arr[i]);
            }

            i++;
            i = i % arr.length;
        } while(i !=end);


        System.out.print("]");
    }

    public void push(int val) throws Exception {
        if (isFull()) {
            throw new Exception("Queue is Full");
        }
        arr[end++] = val;
        end = end % arr.length;
        size++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty");
        }

        int popped = arr[front++];
        front = front % arr.length;
        size--;


        return popped;

    }

    public boolean  isEmpty()
    {
        return size==0;
    }

    public boolean isFull()
    {
        return size == arr.length;
    }

}
