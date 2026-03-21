package Codeforces;

import java.util.*;

public class PerfectPermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        if(n % 2 != 0) {
            System.out.println(-1);
        }
        else {
            int [] arr = new int[n];
            for( int i = 1 ; i <= n ; i++) {
                arr[i-1] = i;
            }
            for ( int i = 0 ; i <= n-2 ; i++) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                i++;
            }
            for( int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
