package StacksAndQueues;

public class DynamicQueue extends myQueue{

    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int val) {
        super(val);
    }

    @Override
    public void push(int val ) throws Exception {

        if(isFull()) {
            //make temp array copy those elements

            int [] temp = new int[arr.length*2];
            for(int i = 0 ; i < arr.length ; i++) {
                temp[i] = arr[i];
            }
            ptr = arr.length;
            arr =temp;



        }
        super.push(val);
    }

}
