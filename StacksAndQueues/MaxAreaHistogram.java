package StacksAndQueues;
import java.util.*;
public class MaxAreaHistogram {

    public static void main (String [] args) {

        int [] heights = {2,5,4,5,1};
        System.out.println(maxAreaInHistogram(heights));
    }

    static int maxAreaInHistogram(int [] heights) {
        int [] NSLi = nearestSmallerToLeft(heights);
        int [] NSRi = nearestSmallerToRight(heights);
        int max = Integer.MIN_VALUE;
        for( int i  = 0; i < heights.length  ; i++ ) {

            int max_at_each = Integer.MIN_VALUE;
            int left = 0;
            int right= heights.length-1;
            if(NSLi[i] != -1 ) {
                left = NSLi[i] +1;
            }
            if(NSRi[i] != -1 ){
                right = NSRi[i] -1;
            }
            max_at_each = heights[i] * (right - left+1);
            if( max_at_each  >  max ) {
                max = max_at_each;
            }
        }
        return max;
    }

    static int [] nearestSmallerToRight(int [] heights ){
        Stack<int []> st = new Stack<>();
        int []  NSRi = new int[heights.length];

        for( int i = heights.length -1 ; i >=0 ; i--) {

            if(st.isEmpty()) {
                NSRi[i] = -1;
            }
            else if(!st.isEmpty() && st.peek()[0] < heights[i]) {
                NSRi[i] = st.peek()[1];
            }
            else if(!st.isEmpty() && st.peek()[0] >= heights[i]) {
                while(!st.isEmpty() && st.peek()[0] >= heights[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    NSRi[i] = -1;
                    st.push(new int [] {heights[i] , i});
                }
                else {
                    NSRi[i]  = st.peek()[1];
                }
            }
            st.push(new int [] {heights[i] , i});
        }

        return NSRi;
    }


    static int [] nearestSmallerToLeft(int [] heights) {
        Stack<int [] > st = new Stack<>();
        int [] NSLi = new int[heights.length];

        for( int i  = 0 ; i < heights.length ; i++ ) {

            if(st.isEmpty()) {
                NSLi[i] = -1;
            }
            else if(!st.isEmpty() && st.peek()[0] < heights[i]) {
                NSLi[i] = st.peek()[1];
            }
            else if(!st.isEmpty() && st.peek()[0] >= heights[i]) {
                while(!st.isEmpty() && st.peek()[0] >= heights[i]) {
                    st.pop();
                }
                if(st.isEmpty()) {
                    NSLi[i] = -1;
                    st.push(new int [] {heights[i] , i});
                }
                else {
                    NSLi[i]  = st.peek()[1];
                }
            }
            st.push(new int [] {heights[i] , i});
        }

        return NSLi;
    }
}
