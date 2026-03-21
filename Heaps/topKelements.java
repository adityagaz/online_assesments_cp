package Heaps;
import java.util.*;

public class topKelements {
    public static class Pair  {
        int num;
        int freq;
        public Pair(int n , int f) {
            num = n;
            freq = f;
        }
    }
    public static void main (String [] args) {
        int [] nums  =  {1,1,1,2,2,3} ;int k =2;

        System.out.println(Arrays.toString(topKFrequent(nums , k)));
    }
    static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> freq = new HashMap<>();
        for( int i : nums ) {
            freq.put(i , freq.getOrDefault(i , 0) +1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1 , p2) -> {
            return Integer.compare(p1.freq , p2.freq);
        });
        for(int i: freq.keySet()) {
            Pair pair = new Pair(i ,freq.get(i));
            pq.add(pair);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int [] result = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            result[idx++] = pq.poll().num;
        }
        return result;
    }
}
