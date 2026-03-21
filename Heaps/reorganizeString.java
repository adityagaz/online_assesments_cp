package Heaps;
import java.util.*;
public class reorganizeString {

    public static void main (String [] args) {
        String input = "aabccc";
        System.out.println(reorganize(input));
    }

    static String reorganize(String str ) {
       HashMap<Character , Integer> map = new HashMap<>();
       StringBuilder s = new StringBuilder();
       for( char i : str.toCharArray()) {
           map.put(i , map.getOrDefault(i ,0) +1);
       }
       PriorityQueue<Character> maxHeap = new PriorityQueue<>((a , b) -> {
           return Integer.compare(map.get(b) ,map.get(a));
       });

       maxHeap.addAll(map.keySet());
       while(!maxHeap.isEmpty()) {
           char ch = maxHeap.poll();
           if(s.length() >= 1 && s.charAt(s.length()-1 ) == ch) {
               //last wala match ho gaya and ab aur koi nhi hai to break kardo
               if(maxHeap.isEmpty()) {
                   break;
               }
               char nxt = maxHeap.poll();
               s.append(nxt);
               map.put(nxt , map.get(nxt) -1);
               if(map.get(nxt) > 0) {
                   maxHeap.add(nxt);
               }
           }
           else {
               s.append(ch);
               map.put(ch , map.get(ch)-1);
           }
           if(map.get(ch) > 0) {
               maxHeap.add(ch);
           }
       }
        return s.length() == str.length() ?  s.toString() : "";

    }

}
