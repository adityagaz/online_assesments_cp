package Recursion;
public class count_zeros {
    public static void main(String[] args) {
        int n = 123000032;
        //count the number of zeros
        System.out.println(count_zero(n ,0))    ;
    }
    static int count_zero(int number , int count) {
        if(number == 0) {
            return  count;

        }
        if(number % 10 == 0) {
            return count_zero(number/10 , count+1);
        }
        else {
            return count_zero(number/10 , count);
        }
    }
}
