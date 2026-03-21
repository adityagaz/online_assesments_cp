package REVISE;
import java.util.*;
public class nextGreaterElement {

    public static void main (String [] args) {

        long [] arr= {1 ,3, 2, 4};
        //get the next greater element

        System.out.println(Arrays.toString(nextGreater(arr , arr.length)));
    }
    static long [] nextGreater(long [] arr , int n) {
        //intution to use stack

        //this approach has a unique(O(2n)) complexity but it appears to have
        //O(n^2) complexity
        //observe closely the while loop doesnot run for n times for all cases
        //and so it sums up to like

        // 1.n + 2.n + 0.n + n.n ... like that so it is (O(n) + O(n)) that is O(2n)

        Stack<Long> stack = new Stack();
        long [] nge = new long[n];
        for(int i = n-1; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i] = -1;
            }
            else {
                nge[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nge;
    }
}
