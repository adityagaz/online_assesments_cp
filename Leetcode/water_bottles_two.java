package Leetcode;

public class water_bottles_two {/*


leet code 3100

*/
    public static void main(String[] args) {

        int numBottles = 13;
        int exchange_bottles =6;
        System.out.println( max_drink_bottles(numBottles , exchange_bottles));

    }

    static int max_drink_bottles  (int numBottles , int exchange_Bottles) {
        int sum = numBottles;
        int no_of_exchanges = 0;

        while (numBottles >= exchange_Bottles) {
            int empty_bottle = numBottles-exchange_Bottles;
            exchange_Bottles++;
            no_of_exchanges++;
            sum++;
            numBottles = empty_bottle + no_of_exchanges;
        }

        return sum;
    }

}
