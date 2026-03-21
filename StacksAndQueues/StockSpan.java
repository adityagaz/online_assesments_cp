package StacksAndQueues;
import java.util.*;
public class StockSpan {

    public static void main (String [] args) {
        int [] arr = {100, 80, 60 ,70, 60, 75, 85};
        //Output:
        //1 1 1 2 1 4 6
        System.out.println(Arrays.toString(calculateSpan(arr,arr.length)));

    }
    public static int[] calculateSpan(int arr[], int n) {
        // Your code here
        Stack<Integer []> st = new Stack<>();
        st.push(new Integer [] {arr[0] , 1});
//        System.out.println(st);
        int [] ans = new int[n];
        ans[0] = 1;

        for(int i = 1 ; i  < n ; i++ ){
            int count =1;
            //agar bada hoga to peeche chale jao
            //aur agar nhi hua to add kardo 1 aur aage walo ke liye kaam aao
            if (arr[i] >= st.peek()[0]) {
                while (!st.isEmpty() && st.peek()[0] <= arr[i]) {
                    count += st.pop()[1];
                }
            }
            ans[i] =count;
            st.push(new Integer [] {arr[i] , count});
        }
    return ans;
    }
}
