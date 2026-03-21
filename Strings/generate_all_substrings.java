package Strings;
import javax.smartcardio.Card;
import java.util.*;
import java.util.List;

public class generate_all_substrings {

    public static void main(String[] args) {
        String s =  "aabcbaa";
        //output  : a , d, i ,t,y,a, ad,di,it,ty,ya,adi,dit,,ity,tya,adit,dity,itya,adity,ditya,aditya

        System.out.println(generate_substring(s));
    }
//    static List<List<Character>> generate_substring(String s ) {
//        int length = s.length();
//        List<List<Character>> list = new ArrayList<>();
//
//        for (int i = 0; i < length * (length + 1) / 2; i++) {
//            list.add(new ArrayList<>());
//        }
//
//        int index = 0;
//        int window_size = 1;
//        for (window_size = 3; window_size <= length; window_size++) {
//            for (int j = 0; j <= length - window_size; j++) {
//                for (int l = 0; l < window_size; l++) {
//                    list.get(index).add(s.charAt(j + l));
//                }
//                index++;
//            }
//        }
//        return list;
//    }
//
    static int generate_substring(String s ) {
        int length = s.length();
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < length * (length + 1) / 2; i++) {
            list.add(new ArrayList<>());
        }
        int max_beauty = 0 ;
        int index = 0;
        int window_size = 1;
        for (window_size = 3; window_size <= length; window_size++) {
            for (int j = 0; j <= length - window_size; j++) {
                for (int l = 0; l < window_size; l++) {
                    list.get(index).add(s.charAt(j + l));
                }
                max_beauty += beauty_substring(list.get(index));
                index++;
            }
        }
        return max_beauty;
    }

    static int beauty_substring(List<Character> list) {
        if(list.isEmpty()) {
            return 0;
        }
        HashMap<Character , Integer> map = new HashMap<>();
        for(Character i : list) {
            map.put( i , map.getOrDefault(i , 0) +1);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i : map.values()){
            if(i < min) {
                min =i ;
            }
            if(i > max) {
                max = i;
            }
        }
        int beauty= max - min;
        if(beauty > 0){
            return beauty;
        }
        else {
            return 0;
        }

    }


}
//this approach is O(n^3)
//takes time exceeded -- use sliding window