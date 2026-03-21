package Heaps;
import java.util.*;
//Given an array of strings words and an integer k, return the k most frequent strings.
//
//Return the answer sorted by the frequency from highest to lowest.
// Sort the words with the same frequency by their lexicographical order.
public class topKfrequentWords {
    public static class Pair {
        String s;
        int frequency;
        public Pair(String s , int f) {
            this.s = s;
            frequency = f;
        }
    }
    public static void main (String [] args) {
        String [] words = {"i","love","leetcode","i","love","coding" ,"a" , "a"};
        int k = 2;
        System.out.println(topKfrequentelem(words ,  k ));
    }

    static List<String> topKfrequentelem(String [] words , int k ) {
        HashMap<String , Integer> freq = new HashMap<>();
        for( String s : words) freq.put(s , freq.getOrDefault(s , 0 ) +1);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1 , p2) -> {
            if(p1.frequency != p2.frequency){
                //min heap for frequency
                return Integer.compare(p1.frequency , p2.frequency);
            }
            else {
                //reverse this in character sorting because when we poll from priority queue
                //if we place the lex smaller string first then it will be popped and we will loose it
                //so we will keep the lex larger string first
                return CharSequence.compare(p2.s , p1.s);
            }

        });
        for(String s : freq.keySet()){
            Pair pair = new Pair(s, freq.get(s));
            pq.add(pair);
            if(pq.size() > k) pq.poll();
        }
        List<String> result = new ArrayList<>();
        System.out.println(freq);
        while(!pq.isEmpty()){
            result.add(pq.poll().s);
        }
        Collections.reverse(result);
        return result;
    }
}
