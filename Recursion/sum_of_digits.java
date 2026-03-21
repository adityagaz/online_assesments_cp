package Recursion;

public class sum_of_digits {

    public static void main(String[] args) {
        int n  = 12345;
        System.out.println(sum_of_digits(n));
    }
    static int sum_of_digits(int n  ) {
        if (n  < 1 ) {
            return 0;
        }
        return sum_of_digits(n/10) + n%10;
    }
}
