package CODECHEF1800;
//https://www.codechef.com/problems/NORMALEZ
import java.util.*;
public class NormalIsGood {
    public static void main (String [] args) {

        //this is a O(n^3) approach
        Scanner  s = new Scanner(System.in);
        int n = s.nextInt();
        for( int i = 0 ; i < n  ; i++ ){
            int length = s.nextInt();
            int [] arr = new int[length];
            for( int j = 0; j < length ; j++ ){
                arr[j] = s.nextInt();
            }
            System.out.println(normalSubarrays(arr));
        }
    }
    static int normalSubarrays(int [] arr) {
        List<List<Integer>> total_subarrays =  genSubArrays(arr);
        int result =0;
        for( List<Integer> i : total_subarrays) {
            if(isNormal(i)) {
                result++;
            }
        }
         return result;
    }
    static boolean isNormal(List<Integer> array) {
        //mean check
        int sum =0;
        int one_count = 0;
        int two_count = 0;
        for( int i : array) {
            sum+=i;
            if( i ==1) one_count++;
            else two_count++;
        }
        float mean = (float) sum/array.size();
        int mid = array.size()/2;
        float median = 0;
        if(one_count >= mid+1) {
            median = 1;
        }
        else {
            median = 2;
        }
        return mean == median ? true : false;
    }

    static List<List<Integer>> genSubArrays(int [] arr ){
        List<List<Integer>> result = new ArrayList<>();
        for( int window_size = 1 ; window_size <= arr.length ; window_size++) {
            for(int i = 0 ; i <= arr.length - window_size ; i++) {
                List<Integer> temp = new ArrayList<>();
                for( int j = i ; j < i+window_size ; j++ ) {
                    temp.add(arr[j]);
                }
                result.add(temp);
            }
        }
        return result;
    }
}
