package VeryNew;
import java.util.*;
public class LexicographicallySmallestArray {

    public static void main(String[] args) {
        int [] arr=  {1,7,6,18,2,1};
        int limit = 1;
        solve(arr ,limit);
    }

    static  int [] solve(int [] arr, int limit ) {
        int [] original = Arrays.copyOf(arr , arr.length);
        Arrays.sort(arr);
        HashMap<Integer , Integer> map = new HashMap<>();
        //map of number to its group number

        List<Queue<Integer>> groups = new ArrayList<>();
        for( int i = 1 ; i <= arr.length ; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(arr[i-1]);
            map.put(arr[i-1] ,groups.size() -1 );
            while(i < arr.length && Math.abs(arr[i] - arr[i-1]) <= limit) {
                q.offer(arr[i]);
                map.put(arr[i] ,groups.size() -1);
                i++;
            }
            groups.add(q);
        }
        System.out.println(map);
        int []  result  = new int[original.length];
        for( int i = 0 ; i < original.length ; i++) {
            int grp_location = map.get(original[i]);
            int s_element = groups.get(grp_location+1).poll();
            result[i] = s_element;
        }
        return result;
    }
}
