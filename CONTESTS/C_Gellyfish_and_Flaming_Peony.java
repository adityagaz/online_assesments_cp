// package Contests.DIV2_1028;

import java.io.*;
import java.util.*;

public class C_Gellyfish_and_Flaming_Peony {

    static class FastReader {

        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

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

    static FastReader sc = new FastReader();
    static OutputStream outputStream = System.out;
    static PrintWriter out = new PrintWriter(outputStream);

    final static long mod = 1000000007L;

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
            solve(arr, n);
        }
    }

    static void solve(int[] arr, int n) {

        int g = arr[0];
        for (int i = 1; i < n; i++) {
            g = gcd(g, arr[i]);
        }
        int cnt = 0;
        for( int i : arr){
            if(i==g) cnt++;
        }
        if(cnt > 0 ) {
            System.out.println(arr.length - cnt);
        }
        else {
            //we have to find minimum swaps to find that gcd
            int [] dp = new int[5001];
            Arrays.fill(dp, Integer.MAX_VALUE);
            // for( int x : arr)dp[x]=1;
            // boolean flag = false;
            // int times = 1;
            // while(times ==1 || flag) {
            //     flag = false;
            //     times++; //lol this is such a bad implement :(haha)
            //     for( int v = 1;v<=5000 ; v++ ) {
            //         if(dp[v] <5000) {
            //             for( int j = 0; j < n ;j++ ) {
            //                 int temp = gcd(v , arr[j]);
            //                     if(dp[temp] >dp[v]+1) {
            //                         dp[temp]= dp[v]+1;
            //                         flag=true;
            //                     }
            //             }
            //         }
            //     }
            // }

            Deque<Integer> queue = new ArrayDeque<>();
            boolean[] inQueue = new boolean[5001];
            for (int x : arr) {
            if (dp[x] > 1) {
                dp[x] = 1;
                queue.addLast(x);
                inQueue[x] = true;
            }
          }
           while (!queue.isEmpty()) {
            int v = queue.removeFirst();
            inQueue[v] = false;
            int dv = dp[v];

            for (int j = 0; j < n; j++) {
                int temp = gcd(v, arr[j]);
                if (dp[temp] > dv + 1) {
                    dp[temp] = dv + 1;
                    if (!inQueue[temp]) {
                        queue.addLast(temp);
                        inQueue[temp] = true;
                    }
                }
            }
        }

            System.out.println((dp[g]-1) + (n-1));
        }
    }
    static int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }


}
