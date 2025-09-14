package VISA;
import java.io.*;
import java.util.*;

public class one {

    public static void main(String[] args) throws Exception {
        int width = 16;
        List<List<String>> paragraphs = List.of(
            List.of("hello", "world"),
            List.of("How", "areYou", "doing"),
            List.of("Please look", "and align", "to center")
        );
        List<String> page = solve(paragraphs , width);
        for( String p : page) {
            System.out.println(p);
        }
    }
    static String format(String str , int width) {
        int leftOver = width - str.length();
        int left = leftOver/2;
        int right = leftOver - left;
        String res  = "";
        for( int i = 0; i < left ; i++ ) {
            res+=" ";
        }
        res+=str;
        for( int i = 0 ; i < right ; i++ ){
            res+= " ";
        }
        return res;
    }
    static List<String> solve(List<List<String>> para , int w) {
        List<String> result = new ArrayList<>();
        
        for(List<String> line : para) {
            StringBuilder curr = new StringBuilder();
            int curr_len = 0 ;
            for(String word : line) {
                int len = word.length();
                if(curr_len == 0) {
                    curr.setLength(0);
                    curr.append(word);
                    curr_len+=len;
                }
                else {
                    if(curr_len + 1 + len <= w) {
                        curr.append(" ").append(word);
                        curr_len += 1 + len;
                    }
                    else {
                        String temp = format(curr.toString() , w);
                        result.add(temp);
                        //form a new line with this word
                        curr.setLength(0);
                        curr.append(word);
                        curr_len = len;
                    }
                 }
            }
            if(curr_len > 0) {
                String temp = format(curr.toString() ,w);
                result.add(temp); 
            }

        }
        List<String> ans = new ArrayList<>();
        String border = "*".repeat(w+2);
        ans.add(border);
        for( String s : result) {
            ans.add("*" + s + "*");
        }
        ans.add(border);

        return ans;
    }


    
}
