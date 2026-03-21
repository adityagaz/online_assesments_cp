package Arrays;
import java.util.*;
/*https://leetcode.com/problems/largest-number/description/?envType=daily-question&envId=2024-09-18

Topics
Companies
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.



Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 109
 */

public class largestNumber {

    public static void main(String [] args) {
        int [] arr = {3,30,34,5,9};

        System.out.println(getLargest(arr));
        //use comparator




    }

    static int getFirstDigit(int n ) {
        int no_of_digit = (int) ((int) Math.log10(n) +1);
        n = n / (int )Math.pow(10 , no_of_digit -1);
        return n;
    }

    static String getLargest(int [] arr)
    {
        String [] str = new String[arr.length];
        int index = 0 ;

        for(int i : arr)
        {
            str[index++] = String.valueOf(i);
        }
        Arrays.sort(str , (a , b) -> {

            if(Integer.parseInt(a+b) >= Integer.parseInt(b+ a)) {
                return -1;
            }
            else {
                return 1;
            }

        });
        if(str[0].equals("0")) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for(String s : str) {
            ans.append(s);
        }
        return ans.toString();
    }


}
