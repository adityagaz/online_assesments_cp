package PriorityQueues;
import java.util.*;

public class BasicPriorityQueue {
    public static void main (String []args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();// generates a min-heap by default
        PriorityQueue<Integer> pq_rev = new PriorityQueue<>(3 ,(a , b) ->  b-a); //max- heap for integers
        pq_rev.add(5);
        pq_rev.add(2);
        pq_rev.add(3);
        pq_rev.add(4);
        System.out.println(pq_rev.poll());
        System.out.println(pq_rev.poll());
        System.out.println(pq_rev.poll());

    }
}
