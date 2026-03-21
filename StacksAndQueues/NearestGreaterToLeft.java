package StacksAndQueues;
import java.util.*;
public class NearestGreaterToLeft {


    public static void main (String [] args) {
        int [] ip = {10 , 4,2,20,40,12,30};
        //output the nearest greater to left or else return -1 if not found
        // [3,4,4,-1]

        System.out.println(Arrays.toString(nearestGreaterToLeft(ip)));
    }


    static int [] nearestGreaterToLeft(int [] arr) {
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[arr.length];
        for( int i = 0 ; i < arr.length ; i++) {
            //if the stack is empty that is initial condition
            if (st.isEmpty()) {
                ans[i] = -1;
            } else if (!st.isEmpty() && st.peek() > arr[i]) {
                ans[i] = st.peek();
            } else if (!st.isEmpty() && st.peek() <= arr[i]) {
                while (!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = st.peek();
                }
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
