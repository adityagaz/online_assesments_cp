package Codeforces;
import java.util.*;

public class BorzeB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(decodeBorze(str));
    }

    static String decodeBorze(String str) {
        String res = "";
        for( int i = 0 ; i < str.length() ;i++ ){
            if (str.charAt(i) == '.') {
                res+="0";
            }
            else if( str.charAt(i) == '-' && str.charAt(i+1) == '.') {
                res+="1";
                i++;
            }
            else if(str.charAt(i) == '-' && str.charAt(i+1) == '-'){
                res+="2";
                i++;
            }
        }
        return res;

    }
}
