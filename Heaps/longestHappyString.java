package Heaps;
import java.util.*;
public class longestHappyString {
    public static void main (String [] args) {
        int a = 1;
        int b = 1;
        int c = 7;
        String ans = longestHappy( a, b, c);
        System.out.println(ans);

    }
    public static class pair {
        public  int x;
        public  char y;
        public pair(int x, char y) {
            this.x = x;
            this.y = y;
        }
    }
    public static String longestHappy(int a, int b, int c) {
        StringBuilder result = new StringBuilder();
        PriorityQueue<pair> maxHeap = new PriorityQueue<>((p1 , p2) ->{
            return Integer.compare(p2.x , p1.x);
        });
        if(a > 0 ) {
            maxHeap.add(new pair(a, 'a'));
        }
        if( b >0) {
            maxHeap.add(new pair(b , 'b'));
        }
        if( c > 0 ) {
            maxHeap.add(new pair(c , 'c'));
        }

        while(!maxHeap.isEmpty()){
            pair popped = maxHeap.poll();
            if(result.length() >=2 &&  popped.y == result.charAt(result.length()-1) && popped.y ==result.charAt(result.length()-2)){
                if(maxHeap.isEmpty()){
                    break;
                }
                pair secondPopped = maxHeap.poll();
                result.append(secondPopped.y);
                secondPopped.x--;
                if(secondPopped.x > 0 ) {
                    maxHeap.add(secondPopped);
                }
            }
            else {
                result.append(popped.y);
                popped.x--;
            }
            if(popped.x > 0) {
                maxHeap.add(popped);
            }
        }

        return result.toString();
    }
}
