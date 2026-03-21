package Heaps;
import java.util.*;

public class SenderWithLargestWordCount {
    public static class Pair{
        String sender;
        int words;
        public Pair(String sender , int words) {
            this.sender = sender;
            this.words = words;
        }
    }
    public static void main (String [] args) {
        String [] messages = {"tP x M VC h lmD","D X XF w V","sh m Pgl","pN pa","C SL m G Pn v","K z UL B W ee","Yf yo n V U Za f np","j J sk f qr e v t","L Q cJ c J Z jp E","Be a aO","nI c Gb k Y C QS N",
                "Yi Bts","gp No g s VR","py A S sNf",
                "ZS H Bi De dj dsh","ep MA KI Q Ou"};
        String [] senders = {"OXlq","IFGaW","XQPeWJRszU","Gb","HArIr",
                "Gb","FnZd","FnZd","HArIr","OXlq","IFGaW","XQPeWJRszU",
                "EMoUs","Gb","EMoUs","EMoUs"};
        System.out.println(largestWordCount(messages, senders));

    }
    public static String largestWordCount(String[] messages, String[] senders) {
        ///make hashmap  --> maxheap -->in comparator define that lex smaller string comes after the smaller (sort in decreasing lex order)
        HashMap<String , Integer> freq = new HashMap<>();
        for(int i = 0 ; i < senders.length ; i++ ) {
            int count = messages[i].split(" ").length;
            freq.put(senders[i] , freq.getOrDefault(senders[i] ,0) + count);
        }
        System.out.println(freq);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1 , p2) -> {
            if(p1.words == p2.words) {
                return CharSequence.compare(p2.sender , p1.sender);
            }
            else {
                return  Integer.compare(p2.words , p1.words);
            }
        });
        for( String i : freq.keySet()) {
            Pair pair = new Pair(i , freq.get(i));
            pq.add(pair);
        }
        String result = pq.poll().sender;
        return result;
    }
}
