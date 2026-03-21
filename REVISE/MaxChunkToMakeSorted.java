package REVISE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxChunkToMakeSorted {

    public static void main (String [] args ){
        int [] arr = {2, 0 ,1};
        /*
        10
        2
        3
        4
         */

        maxChunks(arr);
    }

    static int maxChunks(int [] arr) {
        Stack<Integer> st = new Stack();
        for( int i =0 ; i < arr.length ; i++)
        {
            int a = arr[i];
            while(!st.isEmpty() && arr[i] < st.peek())
                {
                    a = Math.max(a , st.peek());
                    st.pop();
                }
            st.push(a);
        }
        return st.size();
    }
}
