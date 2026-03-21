package DP;
import java.util.*;

public class rodCutting {
    public static void main(String[] args) {
        int [] prices = {3, 5, 8, 9, 10, 17, 17, 20};
        int rodLength = 24;
        System.out.println(maxPrice(prices  ,rodLength , prices.length -1));
    }

    static  int maxPrice( int [] prices , int rodLength , int index) {

        if(index == 0) {
            return rodLength * prices[0];
        }

        int cut =  0;
        int currentLength = index+1;
        if(currentLength <= rodLength) {
            
            cut = prices[index] + maxPrice(prices, rodLength - currentLength , index); //infinite supply of rods so stay
        }
        int nocut = maxPrice(prices , rodLength , index -1);
        return Math.max(cut , nocut);
    }
}
