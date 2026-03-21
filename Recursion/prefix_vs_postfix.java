package Recursion;

public class prefix_vs_postfix {
    public static void main(String[] args) {
        //how about we have to print numbers from 5 to 1 using recursion
        int  n  = 5;
//        prefix_vs_postfix_corrected(n);



    }
    static void prefix_vs_postfix ( int  n )  {
        if( n == 0 ) {
            return;
        }
        System.out.println(n);
        prefix_vs_postfix(n--);
    }
    //this code above will give an error because it passes the 5 first and then does a n--;
    //so in the next iteration the same is passed to the recursive call and hence runs in a infinite while loop

    //so we have to decrement first and then pass the value
    //like --n
    //this is called the prefix decrement
    static void prefix_vs_postfix_corrected( int  n )  {
        if( n == 0 ) {
            return;
        }
        System.out.println(n);
        prefix_vs_postfix_corrected(--n);
    }
}
