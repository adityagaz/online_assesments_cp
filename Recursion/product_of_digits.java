package Recursion;

public class product_of_digits {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(product_of_digits(n));
    }

    static int product_of_digits(int n ) {
        //base case --> if only one digit is remaining then return that digit
        //how to check if only one digit is present by taking modulo with 10 if the same number comes then only one digit is left
        if(n%10 ==  n) {
            return n;
        }
        return n%10 * product_of_digits(n/10) ;
    }

}
