package Codeforces;
import java.util.*;
public class QueueAtTheSchool {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int people = s.nextInt();
        int t = s.nextInt();
        s.nextLine();
        char [] arr = s.nextLine().toCharArray();
        for (int time = 1 ; time <= t ; time++ ) {
            int i = 0;
            while ( i < arr.length -1 ) {
                if(arr[i] == 'B' && arr[i+1] == 'G') {
                    arr[i] = 'G' ;
                    arr[i+1] = 'B';
                    i++;
                }
                i++;
            }
        }
        for( char c : arr) System.out.print(c);
    }
}
