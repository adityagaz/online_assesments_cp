package Leetcode;

public class powxn {
    public static void main(String[] args) {
        double input_num = 2.00000 ;
        int exponent = -2;
        double result = raised_to_power(input_num , Math.abs(exponent));
        if(exponent >= 0 ){
            System.out.println(result);
        }
        else  {
            System.out.println(1/ result);
        }
    }
    static double raised_to_power (double num , int exponent) {
        if(num ==0 ) return 0;
        if (exponent ==0 ) return 1;
            double res = raised_to_power(num , exponent /2 );
            res = res * res;
            return  exponent %2 ==0 ? res : num * res;
    }
}
