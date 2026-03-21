package Leetcode;
import java.util.*;
public class letter_comb_phone_number {

    public static void main (String [] args)  {


        String input =  "23";
        System.out.println(genCombPhoneNumbers(input));

    }

    static List<String> genCombPhoneNumbers(String digits) {

        HashMap<Character , String > map = new HashMap<>();
        for( int i = 0 ; i < digits.length() ; i++) {
            if(digits.charAt(i) == '2') {
                map.put('2' , "abc");
            }else if(digits.charAt(i) == '3') {
                map.put('3' , "def");
            }else if(digits.charAt(i) == '4') {
                map.put('4' , "ghi");
            }
            else if(digits.charAt(i) == '5') {
                map.put('5' , "jkl");
            }
            else if(digits.charAt(i) == '6') {
                map.put('6' , "mno");
            }
            else if(digits.charAt(i) == '7') {
                map.put('6' , "pqrs");
            }
            else if(digits.charAt(i) == '8') {
                map.put('8' , "tuv");
            }
            else if(digits.charAt(i) == '9') {
                map.put('9' , "wxyz");
            }
            else {
                map.put('1' , "");
            }
        }
        List<String> answer = new ArrayList<>();
        if(digits.isEmpty()) return answer;
        answer.add("");

        for(int i  = 0 ; i < digits.length() ; i++) {
            int size = answer.size();
            String possible = map.get(digits.charAt(i));
            int possible_len = possible.length();



            for( int j = 0 ; j < size ; j++){

                for(int l = 0 ; l < possible_len ; l++) {
                    StringBuilder str = new StringBuilder(answer.get(j));
                    str.append(possible.charAt(l));
                    answer.add(str.toString());

                }

            }
        }
        List<String> final_s = new ArrayList<>();
        for( int i = 0 ; i < answer.size() ; i++ ){
            if(answer.get(i).length() == digits.length()){
                final_s.add(answer.get(i));
            }
        }

        return final_s;
    }

}
