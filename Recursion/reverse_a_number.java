package Recursion;

public class reverse_a_number {
    public static void main(String[] args) {
        int n = 4321;
        //output = 1234
        //recursively call for (num_of_digits) * num % 10 + func(num/10);

        System.out.println(reverse_num(n));
    }
    static int reverse_num(int n ) {
        if(n == 0 ) {
            return 0 ;
        }
        int digit_count = (int) (Math.log10(n) +1 );
        return n%10 * (int) Math.pow(10, digit_count-1)  + reverse_num(n/10);
    }


}
