package Heaps;
import java.util.*;
//leetcode 621
//task scheduler

public class TaskScheduler {
    public static void main (String [] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 3;
        System.out.println(minTasks(tasks, n));
    }
    static int minTasks(char [] tasks , int n) {
        HashMap<Character ,Integer > map = new HashMap<>();
        for(char task : tasks) {
            map.put(task , map.getOrDefault(task , 0) +1);
        }
        //map updated
        //now make max heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a , b) -> {
            return Integer.compare(map.get(b) , map.get(a));
        });
        for(char task : map.keySet()) {
            maxHeap.add(task);
        }
        int ans = 0;
        //maxHeap updated
        while(!maxHeap.isEmpty()){
            ArrayList<Character> list = new ArrayList<>();
            for(int i = 1 ; i <= n+1; i++) {
                if(!maxHeap.isEmpty()) {
                    char ch = maxHeap.poll();
                    map.put(ch , map.get(ch) -1);
                    list.add(ch);
                }
            }
            for(char c : list) {
                if(map.get(c) > 0){
                    maxHeap.add(c);
                }
            }
            if(!maxHeap.isEmpty()) {
                ans += n+1;
            }
            else {
                ans += list.size();
            }

        }
        return ans;
    }
}
