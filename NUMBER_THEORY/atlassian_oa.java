package NUMBER_THEORY;

import java.util.Scanner;

public class atlassian_oa {

    /*
        Atlassian has a text‑collaborative tool called Confluence. In this problem, 
        the editor receives an array of lowercase strings and computes a single “parity” result for them as follows.
        Each character c has an ASCII decimal value ord(c):
        • ord(‘a’) = 97, ord(‘b’) = 98, …, ord(‘z’) = 122.

        You are given an integer m. For each string s of length L, define
        value(s) = ord(s[0])^m × ord(s[1])^(m−1) × … × ord(s[L−1])^(m−L+1)
        (Treat any exponent ≤ 0 as giving a factor of 1.)

        Compute value(s) for each string in the array, sum them all to get S, and
        if S is even print EVEN, otherwise print ODD.

        Input format
        t
        For each of the t test cases:
        m
        k
        k strings s[0] s[1] … s[k−1]

        Output format
        For each test case, on its own line, print EVEN or ODD.

        Example
        Input:
        1
        2
        2
        abc abcd

        Explanation:
        ord(‘a’)=97, ord(‘b’)=98, ord(‘c’)=99, ord(‘d’)=100
        value(“abc”) = 97^2 × 98^1 × 99^0 = 9 409 × 98 × 1 = 921 082
        value(“abcd”) = 97^2 × 98^1 × 99^0 × 100^(–1) = 9 409 × 98 × 1 × 1 = 921 082
        Sum = 921 082 + 921 082 = 1 842 164, which is even → output EVEN

        Constraints
        1 ≤ t ≤ 50
        2 ≤ k ≤ 20
        2 ≤ m ≤ 10^9
        1 ≤ length of each string ≤ 10^5
        Sum of all string lengths over all test cases ≤ 10^5
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int m = s.nextInt();
            int k = s.nextInt();
            s.nextLine();
            String [] arr = s.nextLine().split(" ");
            solve(arr , m , k);

        }
        
    }

    static void solve(String [] arr , int m , int k) {
        /*
          Observations --
          1. see if we consider one string first
          ' a b c ' --> a = 97 , b = 98  , c = 99
          now value = 97^m * 98^m * 99^m = some big number
            and if you are naive you will use Math.pow(97 , m) * Math.pow(98 , m) ... and then check %2.
            So sad for you but that is the most bruteforce and naive approach and fyi 
            z = 122 and m <= 1e9 so imagine (122)^1e9 = that is out of range of even long long
            so relax baby we have to think something else
            see if we have to check even or odd only then we should focus on the same 
            if (even)^m  where m is any number is even 
            and even * any number of odds will be even 
            Proof - 
            even number is of the form - 2n 
            now even^m = (2n)^m = 2^m * n^m  = 2 * (2^m-1 * n^m ) = it is not very hard to see it will always be even
            and since we have to multiply numbers  a^m * b^m * c^m ... we can say 
            even * odd * odd * odd ... = always even 
            If you are doing products then if even one number that is even comes then whole product becomes odd.
            Proof - 
            (2n) * (2n + 1 ) * k = 2nk * (2n + 1) = 4n^2k + 2nK = 2 ( 2n^2k + nk). Again not very hard to see
            that it is always even
            So our algo -->
            go to each string check if any letter is even then mark increment even count and break if all the strings are odd
            then increase odd count 
            finally for each string we will get 
            ['abc' , 'def' , 'asdga'] => [e , o , e ] 

            now in this final array we can observe that 
            if odd number appears odd times then it is odd in all other cases it is even 
            even any number of times is even 
            odd if even times = even
            odd if odd times = odd
            
            Proof - 
            k * (2n) = 2 * (kn) --> always even
            2n * (2n+1) = 4n^2 + 2n = 2(2n^2 + n) --> even
            (2n+1) * (2n+1) = 4n^2 + 4n + 1  = 2(2n^2 + 2n) + 1 --> always odd 
            so finally check if we had odd number odd times then answer will be odd otherwise even
            because odd + even = odd
          */
          int odd_c = 0 , even_c =0;
          for( String s : arr ) {
            boolean flag = false;
            for( int i = 0 ; i < s.length() ; i++ ) {
                int x = s.charAt(i) - '0';
                if(x%2 == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag) even_c++;
            else odd_c++;
          }
          if((odd_c  & 1 )== 1) {
            System.out.println("ODD");
          }
          else {
            System.out.println("EVEN");
          }
    }
}
