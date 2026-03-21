package Recursion;

public class numbers_till_n {
    public static void main(String[] args) {
        int n  = 5;


        // i want to print numbers from 5 till 1 using recursion

//        func2(1,5);
//        func1reverse(5);
        funcBoth(5);
    }
    static void func1(int n ) {
        if ( n ==0 ) {
            return;
        }
        System.out.println(n);
        func1(n-1);
    }

    //what if i want to return 1 to 5


    static void func2(int k , int n ) {
        if(k > n) {
            return;
        }
        System.out.println(k);
        func2(k+1 , n);
    }

    //or else there is a trick to that
    //if you want to print the reverse order then print after the function call is completed

    static void func1reverse(int n ) {
        if(n == 0 ) {
            return;
        }
        func1reverse(n-1);
        System.out.println(n);
    }

    //if you want to print n to 1 and then 1 to n
    // you can print before and after the function call
    static void funcBoth(int n) {
        if (n == 0 ) {
            return;
        }
        System.out.println(n);
        funcBoth(n-1);
        System.out.println(n);
    }

}
