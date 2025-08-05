package minimization;
import java.util.*;
public class longest_arithmetic_progression {

    // Geeks for geeks
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n+1];
        for( int i = 1 ; i <= n; i++ ) {
            arr[i] = s.nextInt();
        }

        solve(arr, n);
    }

    static void solve(int []arr , int n) {
        Arrays.sort(arr);
        int [] dp= new int[n+1];
        arr[0] = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        Set<Integer> set = new LinkedHashSet();
        for( int i : arr ) set.add(i);
        for( int i =1 ; i < n ; i++ ) {
            int max = 1;
            for( int j = i+1 ; j <= n; j++ ) {
                int temp = 2;
                int d = arr[j]-arr[i];
                int cnt = 2;
                while(d*cnt + arr[i] <= arr[n]) {
                    if(set.contains(d*cnt + arr[i])) {
                        temp++;cnt++;
                    }
                    else{
                        break;
                    }
                    
                }
                max = Math.max(max, temp);

            }
            dp[i] = max;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
    
}