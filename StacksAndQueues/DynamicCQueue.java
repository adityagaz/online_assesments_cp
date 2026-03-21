package StacksAndQueues;

public class DynamicCQueue extends CircularQueue  {

    public DynamicCQueue( ) {
        super();
    }

    public DynamicCQueue(int val) {
        super(val);
    }
    //override the push method

    @Override
    public void push(int val) throws Exception
    {

        if(isFull()) {
            int temp []  =new int[arr.length*2];
            //copy the elements to the new array
            for(int i = front ; i < size ; i++) {
                temp[i] = arr[i % arr.length];
            }

            front = 0;
            end = arr.length;
            arr = temp;
        }
        super.push(val);
    }
}
