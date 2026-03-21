package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class searchIn2Darray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3},
                {18, 2, 3},
                {90, -12, 45}
        };
        int target = -12;
        int[] answer = search(arr, target);

        System.out.println("th index at which the target is found is : (row ,column) " + Arrays.toString(answer));
    //maximum in 2D array;

        int max_in_2D = max_2d(arr , target);
        System.out.println(
                "The maximum in the array is : " + max_in_2D
        );

    }

    static int[] search(int[][] arr, int target) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == target) {
                    return new int[]{row, col};
                }
            }
        }
        //if not found return {-1 , -1 }
        return new int[]{-1, -1};
    }


    static int max_2d(int[][] arr , int target ) {
        int maximum = Integer.MIN_VALUE;
        for(int[] subarr : arr) {
            for (int elem  : subarr) {
                if  (elem > arr[0][0]) {
                    maximum = elem;
                }
            }
        }
        return maximum;
    }

    public static class Hcfoptimized {
        //find the largest number
        //find the difference between two numbers
        //replace the difference with the largest number
        // do it till both numbers become the same and return any one of them
        // as Arrays.ncr_and_npr.HCF
        static int HcfOptimize(int a , int b) {
            while (a !=b ) {
                if(a < b) {
                    b = b-a;
                }
                else a = a-b ;
            }
        return a ;
        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();

            System.out.println("Arrays.ncr_and_npr.HCF of two numbers is : " + HcfOptimize(a,b));
        }
    }

    public static class HCFultimate {

        //algorithm
        //rather than comparing the two and taking the difference
        //take the larger and modulo it with the smaller
        //replace the remainder with the larger
        // if it becomes zero then return the non zero which should be the hcf
        static int HcfOptimize(int a , int b) {
            while (a!= 0  && b!=0) { //while a not equal to zero and b not equal to zero
                if(a < b) {
                    b = b%a;
                }
                else a = a%b ;
            }
            if(a !=0 ) {
                return a;
            }
            else return b;

        }
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int a = in.nextInt();
            int b = in.nextInt();

            System.out.println("Arrays.ncr_and_npr.HCF of two numbers is : " + HcfOptimize(a,b));
        }
    }

    public static class NoOfOccurences {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int x  = in.nextInt();
            int count  =0 ;
            while( x > 0 ) {
                if(x%10== 7 ) {
                    count++;
                }
                x =x /10;
            }
            System.out.println("The number of occurrences of 7 are : " + count);
        }
    }

    public static class Keeptakingx {
    //keep taking the sum until the user enters 'x'.
        static  int sumx () {
            Scanner x = new Scanner(System.in);
            System.out.println("Enter numbers and x to stop");
            int sum = 0;
    //        while (true){
    //            String a = x.next();
    //            if(a.equals("end") ) {
    //                break;
    //            }
    //            int number = Integer.parseInt(a); //parsing the string into number
    //            sum += number
    //            ;
    //        }

            //using do while loop;

            do{
                String a = x.next();
                if(a.equals("x")){
                    break;
                }
                int number = Integer.parseInt(a);
                sum +=number;
            }while (true);
            return sum;
        }
        public static void main(String[] args) {
            int answer = sumx();
            System.out.println("The sum is  : " + answer);
        }
    }

    public static class reversenum {
        //i wrote this all on my own in one go !

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            int rev_number = 0;
            while (number  > 0 ) {
                rev_number += number%10;
                rev_number*=10;
                number/=10;
            }
            rev_number/=10;
            System.out.println("The reversed number is  : " + rev_number);
        }
    }
}
