

import java.io.*;
import java.util.*;

public class Apartments {

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
        
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            int[] desired  = new int[n];
            int[] prices = new int[n];
            for (int i = 0; i < n; i++) desired[i] = sc.nextInt();
            for( int i = 0; i < m ; i++) prices[i] = sc.nextInt();
            solve(n ,m , k , desired , prices);
        
    }

    static void solve( int n, int m , int k , int [] desired , int [] prices) {
        Arrays.sort(prices);

        System.out.println(lowerBound(desired[0], prices));


    }

    static int lowerBound(int x , int [] prices)  {
        int l = 0 , r = prices.length -1;
        int ans = prices.length;
        while(l<=r) {
                int mid = l + (r - l) /2;
                if(prices[mid] >= x)  {
                        //can do better
                        ans = mid;
                        r = mid -1;
                }
                else {
                        l = mid +1;
                }
        }

        return ans;
    }

    static int uppperBound(int x , int [] prices) {
        int l = 0 , r = prices.length-1;
        int ans = prices.length;
        while(l<=r) {
                int mid = l + ( r -l ) /2;
                if(prices[mid] > x) {
                        //can do better
                        ans = mid;
                        r = mid -1;
                }
                else {
                        l = mid +1;
                }
        }

        return ans;
    }


    private static void printl(long[] arr) {
        for (long a : arr) out.print(a + " ");
        out.println();
    }

    private static void printl(int[] arr) {
        for (int a : arr) out.print(a + " ");
        out.println();
    }

    private static void print(int a) {
        out.print(a);
    }

    private static void printl(int a) {
        out.println(a);
    }

    private static void print(long a) {
        out.print(a);
    }

    private static void printl(long a) {
        out.println(a);
    }

    private static void printl(char ch) {
        out.println(ch);
    }

    private static void print(char ch) {
        out.print(ch);
    }

    private static void printl(String s) {
        out.println(s);
    }

    private static void print(String s) {
        out.print(s);
    }

    private static int[] intArr(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        return arr;
    }

    private static long[] lngArr(int n) {
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextLong();
        return arr;
    }

    private static double[] dblArr(int n) {
        double arr[] = new double[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextDouble();
        return arr;
    }

    private static int[][] intMatrix(int n, int m) {
        int mat[][] = new int[n][m];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++) mat[i][j] = sc.nextInt();
        return mat;
    }

    private static long[][] longMatrix(int n, int m) {
        long mat[][] = new long[n][m];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++) mat[i][j] = sc.nextLong();
        return mat;
    }

    private static int intgr() {
        return sc.nextInt();
    }

    private static long lng() {
        return sc.nextLong();
    }

    private static double dbl() {
        return sc.nextDouble();
    }

    private static String str() {
        return sc.next();
    }

    private static char chr() {
        return sc.next().charAt(0);
    }

    //if gcd(a, b) = 1 then a and b are said to be coprime
    //gcd(a, 0) == a
    //gcd(a, 1) == 1
    //gcd(a, a) = a
    //gcd(a, b) = gcd(a - b, b)
    //gcd(a, b) = gcd(a % b, a)
    //gcd(m ⋅ a, m ⋅ b) = m ⋅ gcd(a, b) (m > 0)
    // gcd(a,b) = g, then a/g and b/g should be coprime
    //gcd(a, b) = gcd(a+(m*b), b)
    //gcd(a, b) = gcd(b, a % b)
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long gcdL(long a, long b) {
        if (b == 0) return a;
        return gcdL(b, a % b);
    }

    //lcm(a, a + 1) = a * (a + 1)
    //min(a, b) <= lcm(a, b) <= a * b
    private static long lcmL(long a, long b) {
        return ((a * b) / gcdL(a, b));
    }

    private static int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }

    private static List<Integer> getDivisors(int n) {

        List<Integer> ls = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                ls.add(i);
                if (n / i != i) ls.add(n / i);
            }

        return ls;
    }

    private static List<Long> getDivisors(long n) {

        List<Long> ls = new ArrayList<>();
        for (long i = 1; i <= Math.sqrt(n); i++)
            if (n % i == 0) {
                ls.add(i);
                if (n / i != i) ls.add(n / i);
            }
        return ls;
    }

    private static List<Integer> primeFactors(int n) {

        List<Integer> ls = new ArrayList<>();
        int c = 2;
        while (n > 1) {
            if (n % c == 0) {
                ls.add(c);
                n /= c;
            } else c++;
        }
        return ls;
    }

    private static List<Long> primeFactors(long n) {

        List<Long> ls = new ArrayList<>();
        long c = 2;
        while (n > 1) {
            if (n % c == 0) {
                ls.add(c);
                n /= c;
            } else c++;
        }
        return ls;
    }

    private static long fact(int x) {
        if (x == 0 || x == 1) return 1;
        return x * fact(x - 1);
    }

    private static long powMod(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1) res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    private static long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % mod;

            a = (a * a) % mod;
            b = b >> 1;
        }
        return res;
    }

    //not correct--needs upgrade
    private static boolean[] sieve(int n) {

        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++)
            if (prime[p] == true)
                for (int i = p * p; i <= n; i += p) prime[i] = false;

        return prime;
    }

    private static boolean isPrime(int n) {

        if (n == 2 || n == 3) return true;
        if (n <= 1 || n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }

    private static boolean isPrime(long n) {

        if (n == 2 || n == 3) return true;
        if (n <= 1 || n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0) return false;

        return true;
    }

    static long findGCD(long arr[], int n) {
        long result = arr[0];
        for (long element : arr) {
            result = gcdL(result, element);
            if (result == 1) return 1;
        }

        return result;
    }

    private static void sort(int[] a) {
        Arrays.sort(a);
    }

    private static void sort(long[] a) {
        Arrays.sort(a);
    }

    private static int max(int a, int b) {
        return Math.max(a, b);
    }

    private static int min(int a, int b) {
        return Math.min(a, b);
    }

    private static long max(long a, long b) {
        return Math.max(a, b);
    }

    private static long min(long a, long b) {
        return Math.min(a, b);

    }

    private static int[] KMP(String newS) {

        int[] pi = new int[newS.length()];

        for (int i = 1; i < pi.length; i++) {

            int j = pi[i - 1];
            while (j > 0 && newS.charAt(i) != newS.charAt(j)) j = pi[j - 1];

            if (newS.charAt(i) == newS.charAt(j)) j++;

            pi[i] = j;
        }

        return pi;
    }

    private static boolean isPalindrome(int n) {
        String s = Integer.toString(n), tmp = s;
        String rev = new StringBuilder(tmp).reverse().toString();
        return s.equals(rev);
    }

    private static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private static long hash(String s) {

        long hash = 0, pow = 1;
        int prime = 31;
        for (char c : s.toCharArray()) {
            hash += ((c - 'a' + 1) * pow) % mod;
            pow = (pow * prime) % mod;
        }
        return hash;
    }

    private static boolean bs(long val, long[] arr) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = r + (l - r) / 2;
            if (arr[m] == val) return true;
            else if (arr[m] < val) l = m + 1;
            else r = m - 1;
        }
        return false;
    }

}
