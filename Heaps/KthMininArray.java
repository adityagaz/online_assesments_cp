package Heaps;
import java.util.*;
public class KthMininArray {
    public static void main (String [] args) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //methods -- peek() ,  poll () , add()
        minHeap.add(10);
        minHeap.add(2);
        minHeap.add(3);
        minHeap.add(4);
        System.out.println(minHeap);

        //can also make an iterator and get the elements out of the minHeap one by one in sorted order
        Iterator<Integer> it = minHeap.iterator();
        while(it.hasNext()) {
            System.out.print(minHeap.poll() + " ");
        }
    PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());

    maxHeap.add(10);
    maxHeap.add(2);
    maxHeap.add(3);
    maxHeap.add(4);
    System.out.println(maxHeap);






    }

}
