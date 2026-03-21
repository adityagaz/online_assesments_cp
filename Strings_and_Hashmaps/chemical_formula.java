package Strings_and_Hashmaps;

import java.util.HashMap;

public class chemical_formula {

    public static void main(String[] args) {
        String s = "FeH2O2Mn";
        //print the count of all elements in the formula
        System.out.println(parse_formula(s));

    }
    static HashMap<String ,Integer> parse_formula (String s ) {
        HashMap<String, Integer> map =new HashMap<>();
        int i = 0;
        while ( i <s.length()) {
            char c  = s.charAt(i);
            StringBuilder temp_string = new StringBuilder();
            if(c >= 'A' && c <='Z')  {
                temp_string.append(s.charAt(i));
                i++;
                while(true) {
                    if (i<=s.length()-1 && s.charAt(i) >='a' && s.charAt(i) <='z' ) {
                        temp_string.append(s.charAt(i));
                        i++;
                    }
                    else {
                        break;
                    }
                }
            }
            if(i<=s.length()-1 &&  s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder temp_int = new StringBuilder();
                temp_int.append(s.charAt(i));
                i++;
                while(true) {
                    if(i<=s.length()-1 && s.charAt(i) >='0' && s.charAt(i) <='9' ) {
                        temp_int.append(s.charAt(i));
                        i++;
                    }
                    else{
                        break;
                    }
                }
                int value = Integer.parseInt(temp_int.toString());
                if(map.containsKey(temp_string) ) {
                    map.put(temp_string.toString() , map.get(temp_string) + value);
                }
                else {
                    map.put(temp_string.toString() , value);
                }
            }
            else {
                if(map.containsKey(temp_string) ) {
                    map.put(temp_string.toString() , map.get(temp_string) + 1);
                }
                else {
                    map.put(temp_string.toString() , 1);
                }
            }

        }
     return map;
    }

}
