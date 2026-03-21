package Arrays;

import java.util.Scanner;

public class ncr_and_npr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;
        int number = in.nextInt();
        System.out.println(" Enter the r");
        int r = in.nextInt();
        System.out.println("the factorial is  : " + fact_recursion(number));
        System.out.println("the ncr is  : " + ncr(number , r));
        //similarly do for npr also
    }
    static int ncr(int number, int r) {
        return fact_recursion(number) / (fact_recursion(r) * fact_recursion(number -r ));
    }
    //approach 1 -recursion
    static  int fact_recursion ( int n ) {
        //base case
        if (n ==1 || n==0) {
            return 1;
        }
        return n * fact_recursion(n-1);
    }
    //approach 2 - using loops
    static int fact(int n ) {
        int product =1 ;
        while ( n >1) {
            product *= n;
            n--;
        }
        return product;
    }

    //GCD or Arrays.ncr_and_npr.HCF and LCM  Program BruteForce Approach
    public static class HCF {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a  = in.nextInt();
            int b  = in.nextInt();
            int min;
            //algorithm
            //1. find the minimum
            //2. run a for loop from the minimum number till one in reverse
            //3. check if it divides both the numbers and then return i if yes otherwise it is 1.
            if(a <b) {
                min = a;
            }
            else min= b;
            int answer  =1 ;
            for (int i = min ; i > 1 ; i-- ) {
                if (a % i == 0 && b % i == 0) {
                    answer = i;
                }
            }
            int lcm = (a*b)/answer;
            System.out.println("hcm of two number is " + answer);
            System.out.println("lcm of two numbers is  : " + lcm);
        }
    }
}
