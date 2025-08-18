package DSA_BEST_TEMPLATES.TWO_POINTERS;
import java.util.*;
public class vowel_count {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(helper(str ,5) - helper(str, 4));
    }
    

    public static int helper(String word , int k) {
        int n = word.length();
        //ds
        Map<Character , Integer> map = new HashMap<>();
        //ans
        int ans = 0;

        int tail = 0 , head = -1;
        while(tail < n) {
            while(head+1 < n ) {
                char next = word.charAt(head+1);
                if(!check(next)) break;
                if(map.size() == k && !map.containsKey(next)) break;
                head++;
                map.put(next , map.getOrDefault(next,0) +1);
            }

            ans += Math.max(0, (head- tail+1));
            

            if(tail<=head) {
                char ch  = word.charAt(tail);
                if(check(ch)) {
                    map.put(ch, map.get(ch)-1);
                    if(map.get(ch)==0)map.remove(ch);
                }
                tail++;
            }
            else {
                tail++;
                head = tail-1;
            }

        }

        return ans;
    }

    static boolean check(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch == 'u') {
            return true;
        } 
        return false;
    }
}
