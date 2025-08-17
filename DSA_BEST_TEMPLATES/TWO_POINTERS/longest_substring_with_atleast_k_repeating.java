package DSA_BEST_TEMPLATES.TWO_POINTERS;
import java.util.*;
public class longest_substring_with_atleast_k_repeating {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0 ) {
            String str = s.next();
            int  k  = s.nextInt();

            System.out.println(longestSubstring(str ,  k));
        }
        
    }
    static int longestSubstring(String s, int k) {
        int n =s.length();
        int t = 0  , h = -1;
        //ds
        Map<Character , Integer> map = new HashMap<>();


        int ans =0;
        while(t<n) {
            while(h+1 < n && (check(map , s.charAt(h+1) , k))) {
                h++;
                map.put(s.charAt(h) , map.getOrDefault(s.charAt(h) , 0 ) +1);

            }
            ans = Math.max(ans , h-t+1);

            if(t>h) {
                t++;
                h=t-1;
            }
            else {
                map.put(s.charAt(t) , map.get(s.charAt(t)-1));
                if(map.get(s.charAt(t))==0)map.remove(s.charAt(t));
                t++;
            }

        }
        return ans;
        
    }

    static boolean check(Map<Character , Integer> map , char ch , int k ) {

        for( char c : map.keySet()) {
            if(map.get(c) < k) return false;
        }

        if(!map.containsKey(ch) || map.get(ch) + 1 < k) return false;

        return true;
    }
}
