package Codeforces;
import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;
public class probE {
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
        FastReader s= new FastReader();
        int t =  s.nextInt();
        while(t--  > 0) {
            long n  = s.nextInt();
            long m = s.nextInt();
            long k = s.nextInt();
            solve(n , m , k);
        }
    }
    static  void solve(long n , long m , long  k) {
        if (k>m && k>n){
            System.out.println("-1");
            return;
        }
        else if(m <= n) {
            if(n - m > k ){
                System.out.println("-1");
                return;
            }

            makeString(n,m,k,"01");

        }
        else {
            if(m -n > k ){
                System.out.println("-1");
                return;
            }
            makeString(m,n,k,"10");
        }
    }

    static void makeString(long abundant , long exhaustive , long k ,String s) {
        StringBuilder ans = new StringBuilder();

        long length = abundant+exhaustive;
        long counter = k;
        for(int i=0;i<length;i++) {
            if(counter < 1) {
                if(exhaustive < 1) {
                    System.out.println(-1);
                    return;
                }
                if(s.equals("10")){
                    ans.append("0");
                }
                else{
                    ans.append("1");
                }
                counter++;
                exhaustive--;
            }
            else {
                if(abundant >= 1) {
                    if(s.equals("10")) {
                        ans.append("1");
                    }
                    else {
                        ans.append("0");
                    }
                    counter--;
                    abundant--;
                }else {
                    //pad with zeros and end
                    for( int j =0 ; j < exhaustive ; j++) {
                        if(s.equals("10")){
                            ans.append(0);
                        }
                        else {
                            ans.append(1);
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(ans);
    }

}
