package Leetcode;
import java.util.ArrayList;
import java.util.Arrays;
public class even_permutation {
    public static void main(String[] args) {
        int[] arr = {2,1,3,0};
        int [] inputarray_occur  = digitOccurrence(arr);
        ArrayList<Integer> list= new ArrayList<>();
        //run a for loop for even 3 digit numbers from 100 to 999
        //then check if the number's digit occurrences matches with the no of occurrences of that particular digit in
        //the given array
        for (int i  =100  ; i < 1000  ; i+=2 ){
            int[] digit_count = input_occur(i);
            if(canBeAdded(digit_count , inputarray_occur)  ) {
                list.add(i);
            }
        }
        System.out.println(list);
    }
    static boolean canBeAdded (int [] digit_occur , int [] input_occur) {
        for(int i = 0; i  <10 ; i++ ){
            if (digit_occur[i] > input_occur[i] ) {
                return false;
            }
        }
        return true;
    }
    static int [] input_occur(int num) {
        int [] num_occurrences = new  int[10];
        while( num  > 0 ) {
            int rem = num%10;
            num_occurrences[rem]++;
            num /=10;
        }
        return  num_occurrences;
    }
    static int [] digitOccurrence(int [] input_arr)  {
        int [] occurences = new int[10];
        for (int i = 0; i < input_arr.length; i++) {
            occurences[input_arr[i]]++;
        }
        return  occurences;
    }
}
