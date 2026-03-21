package Leetcode;

public class number_of_one_bits {
    /*
    Write a function that takes the binary representation of a positive integer and returns the number of
set bits
 it has (also known as the Hamming weight).
Example 1:
Input: n = 11
Output: 3

Explanation:

The input binary string 1011 has a total of three set bits.

Example 2:

Input: n = 128

Output: 1

Explanation:

The input binary string 10000000 has a total of one set bit.

Example 3:

Input: n = 2147483645

Output: 30

Explanation:

The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
     */

    public static void main(String[] args) {

    int num =  2147483645;
        System.out.println(toBinDigits(num));

    }
    static int toBinDigits (int num  ) {
        int count = 0 ;
        while (num > 0 ) {
            int rem = num % 2;
            if(rem == 1  ) count++;
            num /=2;
        }
        return count;
    }
}
