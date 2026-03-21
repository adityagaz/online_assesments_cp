package Strings_and_Hashmaps;
import java.lang.reflect.Array;
import java.util.*;
public class minimum_length_string_after_k_operations {
    public static void main(String[] args) {
        String s=  "abcdabcd";
        // we will sort the string and then we will check if the i -1 and i +1 elements are the same
        //if they are we will remove those.
        List<Character> list = new ArrayList<>();
        for( int i = 0 ; i < s.length() ; i++ ) {
            list.add(s.charAt(i));
        }
        Collections.sort(list);
        int i =1;
        while (i <= list.size() -2) {
            if(list.get(i-1) == list.get(i) && list.get(i)  == list.get(i+1)) {
                list.remove(i-1);
                list.remove(i+1);
            }
            i++;
        }
        System.out.println(list.size());

        //now that i have failed the test cases now we need to understand that
        //sorting the array won't help us
        //so let us think that if we have 4 a's in the whole string if we end up cancelling all those we can cancel 2 and will be left with 2
        // and if we have 5 a's then we can think that we can cancel 2 then 3 will be left and other than the middle one between those two we can delete the
        //left and right so in conclusion if we have even frequency count then we will have freq -2 (two elements will be left)  deletions  , if odd then we have freq - 1 deletions (only one element left)
        // we can return the string length - no of deletions possible
        System.out.println(min_length_after_deleting(s));
    }
    static  int min_length_after_deleting(String s ) {
        HashMap<Character , Integer> mp = new HashMap<>();
        for( int i = 0 ; i < s.length() ; i++ ){
            mp.put(s.charAt(i) , mp.getOrDefault(s.charAt(i) , 0) +1);
        }
        int deletions = 0;
        for( char ch : mp.keySet()) {
            if(mp.get(ch) % 2 ==0 ) {
                //even
                deletions += mp.get(ch) - 2;
            }
            else  {
                deletions += mp.get(ch) - 1;
            }
        }
        return s.length() -deletions ;
    }
}
