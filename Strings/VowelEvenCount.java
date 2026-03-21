package Strings;
import java.util.*;

public class VowelEvenCount {



    public static void main (String [] args)  {

        String s = "bcbcbc";
        System.out.println(findTheLongestSubstring(s));

    }
    public static int findTheLongestSubstring(String s) {
        int [] arr = new int [5];
        HashMap<String , Integer > map = new HashMap<>();
        int res = 0;

        map.put("00000" , -1);


        for( int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) == 'a') {
                arr[0]= (arr[0] + 1 ) %2 ;
            }

            else if(s.charAt(i) == 'e') {
                arr[1] = (arr[1] + 1 ) %2;
            }

            else if(s.charAt(i) == 'i') {
                arr[2] = (arr[2] + 1 ) %2;
            }
            else if(s.charAt(i) == 'o') {
                arr[3] = (arr[3] + 1 ) %2;
            }
            else if(s.charAt(i) == 'u') {
                arr[2] = (arr[2] + 1 ) %2;
            }
            StringBuilder str = new StringBuilder();

            for(int j: arr)  {
                str.append(j);
            }


            if (map.containsKey(str.toString())) {
                    int lastIndexFound = map.get(str.toString());
                    res = Math.max(res , i - lastIndexFound );
                    //the max would be the current index we are at and last index it is found
            }
            else {
                map.put(str.toString() , i);
            }
        }

        return res;
    }
}
