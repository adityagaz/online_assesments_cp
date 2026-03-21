package Codeforces;
import java.util.*;
public class UltraFastMathematician {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> l = new ArrayList<>();
        while(s.hasNext()) {
            String one = s.nextLine();
            String two = s.nextLine();
            XOR(one , two);
        }
    }

    static void XOR (String a ,String b  ) {
        String res = "";
        for( int i  = 0 ; i < a.length() ; i++ ){
            if(a.charAt(i) == b.charAt(i)) {
                res += "0";
            }
            else {
                res +="1";
            }
        }
        System.out.println(res);
    }
}
