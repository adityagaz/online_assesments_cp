package Arrays;
import java.util.Arrays;
public class swap {
    //swap two elements of an array
    //swap index 0 with index 3.
    // ans = 4 2 3 1 5
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        swap_array(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap_array(int [] arr) {
        int temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;
    }
}
