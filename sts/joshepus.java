package sts;
import java.util.*;

public class joshepus {

    public static void main (String [] args ) {
        int n = 14;
        int k = 2;
        List<Integer> people = new ArrayList<Integer>();
        int idx = 0;
        for( int i = 1; i <=n; i++   ) {
            people.add(i);
        }
        int curr_index = 0 ;

        joshepus(people , k , curr_index);

        //time complexity is O(n)

    }

    static void joshepus(List<Integer> people , int k  , int curr_index)  {
        //base case
        if(people.size() == 1 ) {
            System.out.println(people.get(0));
            return;
        }

        int death_index = (curr_index + k-1) % people.size();
        people.remove(death_index);
        joshepus(people , k , death_index);

    }
}
