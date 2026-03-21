package Leetcode;
public class countNoofDigits {

    public static void main(String[] args) {
    int [] arr = { 12 , 345,  2 , 6 ,7896} ;
    int [] arr1 = { 0,222442,0,-22} ;
        System.out.println(noofeven(arr1));
    }


    //method 2 to find the number of digits

    //algo - take the integer value of log (base =10 incase of normal representation and 2 for binary) +1;

    static boolean is_even(int num ){
        if( num < 0 ){
             num *= -1;
        }
        //counting the number of digits shortcut
        int digit_count  =  (int)(Math.log10(num)) + 1;
        return digit_count % 2 == 0  ? true : false;
    }
    static int noofeven(int [] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (is_even(arr[i])) {
                answer++;
            }
        }
        return answer;
    }
    static boolean isDigitsEven(int number ){
        int count = 0;
        if(number == 0) {
            //to handle the zero edge case
            return false;
        }
        if(number  < 0) {
            //to handle the negative edge cases
            number *= -1;
        }
        while (number > 0) {
            number /= 10;
            count++;
        }
        if(count % 2 ==0 ){
            return true;
        }
        return false;
    }
}
