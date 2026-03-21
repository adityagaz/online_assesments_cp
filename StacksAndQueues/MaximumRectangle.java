package StacksAndQueues;
import java.util.*;
public class MaximumRectangle {

    public static void main (String  [] args) {
        int [][] matrix = {
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,1,0},
                {1,1,1,1,1,0,0,0},
                {0,1,1,1,1,0,0,0},
        };
         int [][] grid = {
                 {0,1,1,0},
                 {1,1,1,1},
                 {1,1,1,1},
                 {1,1,0,0}
         };
        System.out.println(maxArea(grid));
    }

    static int maxArea(int [][] m) {
        int [] arr = Arrays.copyOf(m[0], m[0].length);
        int max =0;
        max = Math.max(max , maxAreaInHistogram(arr));

        for( int i = 1 ;i < m.length ; i++) {
            for( int j = 0; j < m[i].length ; j++) {
                if(m[i][j] != 0) {
                    arr[j] +=m[i][j];
                }
                else {
                    arr[j] = 0;
                }
            }
        max = Math.max(max , maxAreaInHistogram(arr));
        }
        return  max;
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
