package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class sums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while(true) {
            int input = in.nextInt();
            if (input == 0) {
                break;
            }
            list.add(input);
        }
        System.out.println(" the negative sum is : " + negative_sum(list));
        System.out.println(-5%4);
    }
    static int negative_sum (ArrayList<Integer> list){
        int negative_sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if( list.get(i)  <0 ) {
                negative_sum += list.get(i);
            }
        }
    return negative_sum;
    }
}
