package sliding_window;
import java.awt.*;
import java.util.*;
import java.util.List;

public class first_Negative_inWindowOfSizeK {
    public static void main (String [] args ){
            int [] arr = {-8, 2, 3, -6, 10};
        System.out.println(FirstNegativeInteger(arr , 2));

    }

    static List<Integer> FirstNegativeInteger(int [] arr , int k) {
        //we will use a sliding window approach for this
        int i = 0;
        int j =0;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q  = new LinkedList<>();
        while( j < arr.length) {
            if(arr[j] < 0) {
                q.offer(arr[j]);
            }
            if ( j -i +1 ==k) {
                if(!q.isEmpty()) {
                    result.add(q.peek());
                }
                else{
                    result.add(0);
                }
                if(!q.isEmpty() && arr[i] == q.peek()) {
                    q.poll();
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
