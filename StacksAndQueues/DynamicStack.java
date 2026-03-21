package StacksAndQueues;

//since we have already got the methods in the mystack class we can just extend it
//also if we want to modify the method then we can use the override
//so in dynamic stack we can have all the existing methods and we can modify the push method
//whenever the array gets full
public class DynamicStack  extends mystack {

    public DynamicStack() {
        //we want to initialize the array like in the custom stack
        //so we have to use super() which calls the appropriate constructor of the class which this
        //class extends to (i.e now it extends to mystack so it will call mystack constructor)

        super();
    }

    public DynamicStack(int val) {
        super(val);
    }



    @Override
    public boolean push(int item) throws Exception {
        //so now if we have a item to push and we have the array full then we have to
        //1. create a new array of double the size and copy all the elements into that array
        if(this.isFull())
        {
            int [] temp = new int [arr.length *2];
            //copy all previous items
            for( int i = 0 ; i < arr.length ;i++ )
            {
                temp [i] = arr[i];
            }
            arr= temp; //now the arr pointer points to the temp array in the heap memory
        }
        //after that insert the item in the arr
        return super.push(item); //calls the push function in the extended class
    }
}
