package REVISE;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterii {
    public static void main (String [] args ){

        long [] arr= {1,2,3,4,3};
        //get the next greater element
        System.out.println(Arrays.toString(nextGreater2(arr , arr.length)));
    }

    static long [] nextGreater2(long [] arr , int n) {
        //intution to use stack

        //this approach has a unique(O(2n)) complexity but it appears to have
        //O(n^2) complexity
        //observe closely the while loop doesnot run for n times for all cases
        //and so it sums up to like

        // 1.n + 2.n + 0.n + n.n ... like that so it is (O(n) + O(n)) that is O(2n)

        Stack<Long> stack = new Stack();
        long [] nge = new long[n];
        for(int i = 2*n-2; i >= 0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i%arr.length]) {
                stack.pop();
            }
            if(i  < n) {
                if(stack.isEmpty()){
                    nge[i] = -1;
                }
                else {
                    nge[i] = stack.peek();
                }
            }
            stack.push(arr[i%arr.length]);
        }
        return nge;
    }
}
