import java.io.*;
import java.util.*;

public class B_Interesting_drink implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new B_Interesting_drink(), "whatever", 1 << 30).start();
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(System.out);
            FastReader sc = new FastReader();

            solve(sc);

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    Small Observations:


        n shops are there
        price of cola at i th shop is xi.
        
        drink is bought for q consecutive days...

        on i th day he can spend mi coins


        goal :
            find in each day :
                how many shops can he buy the drink


        tests 

        n = 5
        prices -- 3 10 8 6 11
        q = no of days he plans to buy a drink 4 
        allowed spending per day -- 1 10 3 11

        0 -- since he has only one rupee to spend and all shops are out of his budget
        4 -- shops 0 , 1 , 2 , 3 are in budget
        1 so on...
        5

        brute force :
            for each day in q :  // 1e5
                count = 0
                for each shop : // 1e5
                    if m > x : 
                        count++
                print(count)

        O(n * n) == O (1e10) TLE

        How can we optimise ?? 


        Is there a monotone ??

        So if we sort the prices. 
            
        then if at an arbitrary point the shop x is expensive then it is guaranteed that shop x + 1 would 
        be out of budget too!!

        so we can discard...
        
        core idea for each q -- find the index of the last shop that is equal or less than spending limit of that day 

        solution --- binary search (lower bound)

    Logic :


    */



    static void solve(FastReader sc) throws Exception {

        // int t = sc.nextInt();
        int t = 1;

        while (t-- > 0) {

            int n = sc.nextInt();
            int [] prices = new int[n];
            for ( int i= 0 ; i < n ; i++ ) prices[i] = sc.nextInt();
            int q = sc.nextInt();
            int [] spendingLimit = new int[q];
            for( int i = 0 ; i <q ; i++) {
                spendingLimit[i]= sc.nextInt();
            }
            Arrays.sort(prices);
            int count = 0;
            for( int dayLimit : spendingLimit) { //(N * logN)
                int idx = bs( prices, dayLimit);
                count = idx == -1 ? 0 : idx +1;
                System.out.println(count);
            }
        }

    }

    static int bs(int [] prices , int limit) {
        int lo = 0;
        int hi = prices.length-1;
        int ans = -1;
        while (lo<=hi) {

            int mid = lo + (hi - lo )/2;
            if(prices[mid] <= limit) {
                ans = mid;
                lo = mid +1;
            }
            else {
                hi = mid -1;
            }
            
        }

        return ans;
    }





    static class FastReader {
        BufferedReader b; StringTokenizer s;
        public FastReader() { b = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while (s == null || !s.hasMoreElements()) { try { s = new StringTokenizer(b.readLine()); } catch (IOException e) { e.printStackTrace(); } } return s.nextToken(); }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() { String str = ""; try { if (s != null && s.hasMoreTokens()) str = s.nextToken("\n"); else str = b.readLine(); } catch (IOException e) { e.printStackTrace(); } return str; }
    }
}