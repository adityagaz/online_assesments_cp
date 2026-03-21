package Codeforces;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ProbC {
    static class FastReader {

        // BufferedReader to read input
        BufferedReader b;

        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader
                    (new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) {
        FastReader s = new FastReader();
         int t = s.nextInt();
        while( t-- > 0 ) {
            int n = s.nextInt();
            int m = s.nextInt();
            long [] arr = new long[n];
            long [] arr2 = new long[m];
            for( int i = 0 ; i < n ;i++) {
                arr[i] = s.nextInt();
            }
            for( int j = 0 ; j <m ; j++ ){
                arr2[j] = s.nextInt();
            }
            solve(arr, arr2 , n , m);
        }
    }
    static void solve(long [] arr , long [ ] arr2 , long n , long m) {
        Arrays.sort(arr2);
        boolean cando = true;
        long prev = min(arr[0] , arr2[0] - arr[0]);
        for( int i  = 1  ; i < n ; i++ ) {
            // in the array op >= prev + arr -- > smallest number that satisfies this condition  (lower bound)
            int lb_index = bs(prev + arr[i] , arr2);
            if(lb_index == -1 ) {
                //no lower bound found so check if prev is greater then stop else assign  prev to arr[i]
                if(prev > arr[i]) {
                    cando = false;
                    break;
                }
                else {
                    prev = arr[i];
                }
            }
            else {
                //if you found  a lower bound then
                long op = (arr2[lb_index] - arr[i]);
                if(prev <= arr[i] && prev <= op) {
                    //take the minimum
                    prev = min(arr[i] , op);
                }
                else if (prev > op) {
                    prev = arr[i];
                }
                else {
                    prev = op;
                }
            }
        }

        if(cando) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    static int bs(long num , long []  arr2) {
        int lo = 0; int hi = arr2.length-1;
        int ans = -1;
        while(lo <= hi) {
            int mid = lo +  (hi - lo  ) /2;
            if(arr2[mid] >= num) {
                ans = mid;
                hi = mid -1;
            }
            else {
                lo = mid +1;
            }
        }
        return ans;
    }
    }
