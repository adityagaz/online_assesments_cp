package subarray.substrings;
import java.util.*;
public class longest_substring_diff_adjacent_pairs_atmostK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int k = s.nextInt();
        solve(str , k );

    }

    static void solve(String str , int k) {
        /*
          we have to find the longest substring such that the adjacent pairs ascii difference is at most k
          a b a b b a c a
        now if we start making the sub string from 0 then ans = 1
        now the second element comes and if a[1] - a[0] <= k then  ans becomes last_answer + 1 
        if it doesnot match then dp[that index]= 1 

        so 
        if(arr[i] == arr[i-1] ) {
                //match
                then dp[i] = 1 + dp[i-1];
            }
                else {
                    dp[i] = 1;
                    }


        Now find the max of the dp array
        In these types of problems we can say that we have to finc the maximum /minimum of the dp array
        here dp[i] -- means the max length subarray ending at index i which satisfies the conditions
        NOTE -- this meaning is not same as best answer till index i instead it calculates the best answer for each index 
        and then we have to find the max of all elemenets in the dp array


         */
        int n = str.length();
        int [] dp = new int[n];
        dp[0]=1;
        int mx_len = 1 , mx_idx = 0;
         for(int i = 1; i < n ; i++) {
            int  r = str.charAt(i)  - '0', l = str.charAt(i-1) - '0';
            if(Math.abs(r - l) <= k) {
                //they are good
                dp[i] = 1 + dp[i-1];

            }
            else{
                dp[i] = 1;
            }

            if(dp[i] > mx_len)  {
                mx_len = dp[i];
                mx_idx = i;
            }
         }

        int start_idx = mx_idx - mx_len +1;         
        System.out.println(str.substring(start_idx, start_idx + mx_len));
        
    }
}
