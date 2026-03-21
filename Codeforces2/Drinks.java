package Codeforces;
import java.util.*;

public class Drinks {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int glasses = s.nextInt();
        int [] arr = new int[glasses];
        for( int i  = 0 ; i < arr.length ; i++) {
            arr[i] = s.nextInt();
        }
        double p =  0;
        for(int i : arr){
            p+=(double) i/100;
        }
        System.out.println((p/glasses)*100);
    }
}
