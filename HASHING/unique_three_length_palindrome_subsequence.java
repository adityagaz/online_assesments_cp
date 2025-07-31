package HASHING;
import java.util.*;
public class unique_three_length_palindrome_subsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int res = countPalindromicSubsequence(str);
        System.out.println(res);

    }

    static  int countPalindromicSubsequence(String s) {
        int n = s.length();
        HashMap<Character , List<Integer>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        
        for( int i = 0; i < n; i++ ) {
            char ch = s.charAt(i);
            map.putIfAbsent(ch , new ArrayList<>());
            map.get(ch).add(i);
        }
        
        int ans =0;
        for( int i  = 0 ; i < n ; i++ ) {
            char ch = s.charAt(i);
            if(map.get(ch).size() == 1 || set.contains(ch)) continue;
            //Calculation  part
            ans+=checkUniqueNoElements(map, map.get(ch).get(0), map.get(ch).get(map.get(ch).size()-1));
            set.add(ch);
        }
        return ans;
    }

    static int checkUniqueNoElements(HashMap<Character , List<Integer>> map , int l  , int r ) {
        int count =0;
        Set<Integer> set= new HashSet<>();
        for( char c: map.keySet()){
            
            List<Integer> range = map.get(c);
            for( int i : range) {
                if(i>l && i < r){
                    set.add(i);
                    break;
                }
            }
            
        }
        return set.size();
        //O(26) at max O(1) approach
    }
}
