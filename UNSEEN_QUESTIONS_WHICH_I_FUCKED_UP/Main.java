package UNSEEN_QUESTIONS_WHICH_I_FUCKED_UP;

import java.io.*;
import java.util.*;

class Main implements Runnable {

    final static long mod = 1_000_000_007L;
    static PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new Main(), "whatever", 1 << 30).start();
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


    in each move there will be an index which alice wants as answer....

    so let's take that index as "i" 


    now 

    three cases 

        1. index i is at 0

        [i , .. ,... ,,,,, ]

        so alice will select a subarray which is from [i+1 ... n]

        2. index i is at n-1

        [.. ,.... ,.... ,.... , i]

        alice will remove [0 , n-2] and then the left will be [i]

        3.
        index i is in between

        [.... , ... , i , ... , .... , ....]

    think in other direction 


    let's say array is only two elements

    [a , b] 

    alice plays first so....

    if a > b then alice can remove b and [a] will be our answer.

    else alice will remove a and [b] will be the answer.


    now let's try to exrend this idea.. 

    [a , b , c , d ,e]

    if a is the maximum
    alice will remove the subarray [b , c , d , e] and [a] will be left as answer.

    if e is the maximum 
    alice will pick the subarray [a , b, c , d] and [e] will be the answer.

    now what if the maximum element is in middle

    [a, b, c , d ,e] max is c

    then 
        alice has two options 
            1. chop off [a , b] now BOB is left with [c , d , e].

            and in bob's turn he will immediately chop off 'c'.

            so alice looses her chance to have c as the final element.

            2. chop [ d , e] and left with [a ,b,c] alice again hands over the chance to bob 
                and he will delete [c , ... ] subarray and alice will loose her chance to have 'c' 
                as the final element.

        so... hmm we can never guarantee that any number in between the array is guaranteed to be the last 
        number by alice..

        The question comes back to what she can guarantee ??

        First and Last...

        so if arr[0] > arr[n-1] then she will chop off [1,n-1] and bob will have no option.

        and arr[0] will become the last standing element.

        else if arr[n-1] > arr[0] then alice will chop off [0 , n-2] subarray....

        and element at n-1 will be the last remaining....

        So, alice can guarantee only these two...

        in equal to case it doesnot matter..

    Logic :

    if(arr[0] >= arr[n-1]) return arr[0] 
    else return arr[n-1];

    bruhhh
    */

//https://leetcode.com/problems/final-element-after-subarray-deletions/

    static void solve(FastReader sc) throws Exception {

        // int t = sc.nextInt();
        int t = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            int [] arr = new int[n];
            for( int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();

            if(arr[0] > arr[n-1]) System.out.println(arr[0]);
            else System.out.println(arr[n-1]);
            

        }

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