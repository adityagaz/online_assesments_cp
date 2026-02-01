
import java.util.*;
public class create_a_team {

    /*
    Question -
    You are given two arrays speed , efficiency of n people who appeared for interviews.
    Now you have to select k people out of them such that the sum of efficiencies of k people in team and their speed is maximum 


    Observation 1 - 
    We can't apply greedy exchange arguments here
    because we donot know whether our swapped element is in the team of k or not.

    Observation 2 - The overall speed of the team will be decided by the person who is the slowest.
    because we can observe in daily life also

    Now we have to minimmize -- sigma (1 ... k (summation(efficiencies(i)) * min(speed(i)));

    Since we have a complex function to minimize we can just think about on which element we can iterate
    Since we can fix a speed and say we can want team to be atleast this speed (greedy observation)

    sort by speed 
    now we have to see that at each index i speed[i] will be the minimum speed for all the teams starting from 
    i .... N
    And for best people we can do a top k elements from n to i.
    Then we will multiply the speed[i] * (sum of top k elements at index i)

    For maintaining top k elements we have to use a variable that tracks the sum of top k elements at index i

    For top k elements we can maintain a priority queue.
    At last take the max of answers at each index and return that answer

    Conclusions -- It is not a local optimization problem so we cannot use exchange arguments here
    2. When we have to minimize or maximize a complex function on what we can iterate and then solve for other

    Bonus tip -- if two things are changing ... stop one completely and then check... works most of the time.



     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int k = s.nextInt();
            int [] speed = new int [n];
            int [] efficiency = new int [n];
            for ( int i = 0; i < n ; i++ ) speed[i] = s.nextInt();
            for ( int i = 0; i < n ; i++ ) efficiency[i] = s.nextInt();
            solve(n , speed , efficiency , k);            
        }
    }


    static void solve( int n ,  int [] speed , int [] efficiency , int k) {
        Pair [] pairs = new Pair[n];
        for( int i = 0 ; i < n ; i++ ) {
            Pair item = new Pair(speed[i],efficiency[i]);
            pairs[i] = item;
        }
        Arrays.sort(pairs , (a , b) -> {
            return b.x - a.x;
        });
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b) -> {
            return Integer.compare(b.y , a.y);
        });
        int best_team = 0;
        int top_k_sum = 0;
        for( int i = 0; i < n ; i++  ) {
            top_k_sum += pairs[i].y;
            pq.offer(pairs[i]);
            if(pq.size() > k) {
                int popped = pq.peek().y;
                pq.poll();
                top_k_sum -= popped;
            }
            if(pq.size() == k) {
                best_team = Math.max(best_team , top_k_sum * pairs[i].x);
            }
        }

        System.out.println(best_team);
    }

   
 public static class Pair {
        int x , y;
        public Pair( int x , int y ) {
            this.x = x;
            this.y = y;
        }
    }
    
}

