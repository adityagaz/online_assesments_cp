package GREEDY.EXCHANGE_SWAP;
import java.util.*;
public class contest_decay {

    /*
      There are n problems in an contest where score[i] denotes score awarded if problem is solved , 
      there is also a decay[i] which denotes the amount of decay of score if problem is solved after time t
      also there is an array time[i] which denotes the time you will  require to solve the problem[i]
      
      Formally we have to maximise the no of points we can gain from solving all problems.
      however you can change the order of solving problems so that the score is maximized.

      CONSTRAINTS :
      n<=1e5
      
      Observation -- 
      We can change the order of elements so we can apply greedy exchange arguments here and we have to include the 
      whole array for answer.

      let's say there are two problems 
      [p1 , p2] 
        if we choose to solve the problem 1 followed by problem 2
      score1 = s1 - d1*t1 
      score2 = s2 - d2(t1+t2)
      //note - here we have done t1+t2 because we have already exhausted t1 units of time in solving problem p1
      //decay is multiplied by total time from the start of contest till the problem is solved.

      total(1->2 ) = s1 - d1t1 + s2 - d2t1 -d2t2 

      Now ,consider the other possibility 
      p2 is solved first then followed by p1
      p2 -> p1
      score1 = s2 - d2*t2 
      score1 = s1 - d1*(t1+t2) 
      total2 = s2 - d2t2 + s1 - d1t1 - d1t2

      now if score1 is optimal then score1 > score2
      s1 - d1t1 + s2 - d2t1 -d2t2  > s2 - d2t2 + s1 - d1t1 - d1t2
      cancelling common terms
      NOTE - OBSERVATION CANCELLED ITEMS SE KOI FARAQ NHI padta for example score lol :)
      -d2t1 > -d1t2 
      d2t1 < d1t2
      d2/t2 < d1/t1  --voila here we get the optimal sorting order

      Now just sort the order by these ratios and print the sum
     */
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int  n = s.nextInt();
            //score , time , decay
            int [] score = new int [n] , time = new int [n] , decay = new int [n];
            for(int i = 0; i < n ; i++ ) score[i] = s.nextInt();
            for(int i = 0; i < n ; i++ ) time[i] = s.nextInt();
            for(int i = 0; i < n ; i++ ) decay[i] = s.nextInt();
            solve( n , time , decay , score);
        }

    }
    
        static int solve( int n , int [] time , int [] delay , int [] score ) {
            Struct [] grps = new Struct[n];
            for( int i = 0; i < n ; i++ ) {
                Struct grp = new Struct(score[i], time[i], delay[i]);
                grps[i] = grp;
            }
            Arrays.sort (grps , (a , b ) -> {
                return a.time*b.decay - a.decay*b.time;
            });
            long total_points = 0L;
            long time_till = 0L;
            for( int i = 0; i < n ; i++ ) {
                time_till += grps[i].time;
                total_points+= grps[i].score - time_till*grps[i].decay;
            }
            System.out.println(total_points);
            return 0;
        }


    public static class Struct {
        int score , time , decay;
        public Struct (int s , int t , int d  ) {
            score=s;time=t;decay=d;
        }
    }
}
