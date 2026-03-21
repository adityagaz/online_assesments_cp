package BinarySearch;
// Write your code here
import java.util.*;
public class minInRotatedSortedArray {

    public static void main(String[] args ) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int [] arr = new int[n];
            for( int i =0 ; i < n ; i++ ){
                arr[i] = s.nextInt();
            }
            System.out.println(solve(arr));
        }
    }
    static int solve(int [] arr) {
        int lo = 0;
        int hi = arr.length -1;
        int ans = 0;
        while(lo<=hi) {
            int mid = lo + (hi - lo) /2 ;
            if(checker(mid , arr) == 1) {
                ans = mid;
                hi = mid -1;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }
    static int checker(int mid , int [] arr) {
        if(arr[mid] < arr[0]) return 1;
        else {
            return 0;
        }
    }
}