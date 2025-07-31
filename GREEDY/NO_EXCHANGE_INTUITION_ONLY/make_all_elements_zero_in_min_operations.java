package GREEDY.NO_EXCHANGE_INTUITION_ONLY;
 
import java.util.*;
public class make_all_elements_zero_in_min_operations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for( int i = 0 ; i < n; i++ ) arr[i] = s.nextInt();
        solve(n , arr);
    }

    static void solve(int n , int [] arr)  {
        /*
          Problem --> You are given an array of numbers where a[i] can be either positive, negative or zero.
          You have a choice of a number k
          and in one operation:
            you can choose a suffix subarray from [i....n] and subtract each element in the suffix 
            array by k
            You have to return the minimum number of operations such that all the elements are reduced to zero





            INTUITION-
            if we select a subarray of let's say a....n and another subarray b....n then 
            if a < b then we can reduce more number of elements or let's say the first subarray we choose 
            we have to make sure the arr[0] element is made zero if we donot make sure we have to change arr[0] 
            in future so we will again select [0....n] and disturb the already zeros that we made
            So,

            Wiser option --

            1. Anyways you have to make the first element zero then make it now itself becuase later it will cost us
            more.
            2. First pass choose the subarray [1...n].
            3. Then we will choose k = -1*arr[0]; 
            4. Now i according to the operation i have to do arr[0] - k , arr[1] - k , arr[2] - k, arr[3] - k till n
            5. After operation 1 our array becomes [0 , ... , ... , ... , ... ]
            6. Now Again we have come to the same state, we will again choose  arr[1] as new index to make it zero.
            7. Again, we will do arr[1] - k , arr[2] -k , arr[3] -k .... arr[n] -k 
            8. If we continue like this we will make all elements zero.
            9. but it will be O(n^2)
            
            
             HOW TO OPTIMISE -- ??????
                have a load factor intially = 0;
                COST = 0
                at i = 1 load factor = arr[1] - k;
                at i = 2 load factor = arr[2] - load factor , cost = ;
            




         */
    }
}
