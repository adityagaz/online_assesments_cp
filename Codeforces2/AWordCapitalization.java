package Codeforces;
import java.util.*;
public class AWordCapitalization {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        String res = "";
        res  += word.charAt(0);
        res = res.toUpperCase();
        res = res.concat(word.substring(1));
        System.out.println(res);
    }
}
