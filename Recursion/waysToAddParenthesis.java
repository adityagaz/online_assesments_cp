package Recursion;
import java.util.*;
public class waysToAddParenthesis {

    public static void main (String [] args) {

        String s = "2*3-4*5";
        HashMap<String ,List> memo = new HashMap<>();
        System.out.println(ways(s , memo));




    }

    static List<Integer> ways(String s  , Map<String , List> map)
    {

        if(map.containsKey(s)){
            return map.get(s);
        }

        List<Integer> ans  = new ArrayList<>();

        for( int i = 0 ; i < s.length() ; i++)
        {
            char ch = s.charAt(i);
            if(ch  == '+' || ch == '-' || ch == '*') {
                List<Integer> left = ways(s.substring(0,i) , map);
                List<Integer> right = ways(s.substring(i+1) ,map);

                // assemble all the answers and return

                for(int j : left)
                {
                    for( int k : right )
                    {
                        if(ch == '+') {
                            ans.add(j+k);
                        }
                        else if( ch == '-')
                        {
                            ans.add(j-k);
                        }
                        else if( ch == '*' )
                        {
                            ans.add(j*k);
                        }
                    }
                }

            }
        }
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(s));
        }
        map.put(s , ans);
        return map.get(s);
    }
}
