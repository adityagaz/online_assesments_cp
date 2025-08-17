package DSA_BEST_TEMPLATES.TWO_POINTERS;
import java.util.*;

public class shivain {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt() , m = s.nextInt();
        int [][] arr = new int[n][2];
        for( int i = 0; i < n ; i++ ) {
            int u = s.nextInt();
            int v= s.nextInt();
            arr[i][0] = u;
            arr[i][1] = v;
        }

        solve(arr , n , m);
    }

    static int solve( int [][] arr , int n , int m ) {
        int ans = 0;


        Arrays.sort(arr , (a , b) -> {
            int diff1  = a[1]-a[0];
            int diff2 = b[1]-b[0];

            if(diff1 == diff2) {
                return diff2 - diff1;
            }
            else {
                return a[0] - b[0];
            }
        });
        int start = 0;
        int  endtime = 0;
            // O(N) , S - O(1)
        int min = (int)1e9;
        int boxes_taken = 0;
        int index =0;
        while (boxes_taken < m) {
            start=arr[index][0];
            endtime= arr[index][1];
            ans+=Math.abs(endtime -start);
            boxes_taken++;
            if(boxes_taken >=m) break;
            ans+=Math.abs(endtime- arr[index+1][0]);
            index++;
        }
        ans+=Math.abs(arr[0][0]);
        for( int [] i : arr ) {
            System.out.println(Arrays.toString(i));
        }

        System.out.println(ans);
        return 0;
    }
}
