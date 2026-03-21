package Leetcode;

import java.util.Arrays;

public class pass_the_pillow {
    /*
    There are n people standing in a line labeled from 1 to n. The first person in the line is holding a pillow initially. Every second, the person holding the pillow passes it to the next person standing in the line. Once the pillow reaches the end of the line, the direction changes, and people continue passing the pillow in the opposite direction.

For example, once the pillow reaches the nth person they pass it to the n - 1th person, then to the n - 2th person and so on.
Given the two positive integers n and time, return the index of the person holding the pillow after time seconds.



Example 1:

Input: n = 4, time = 5
Output: 2
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3 -> 4 -> 3 -> 2.
After five seconds, the 2nd person is holding the pillow.
Example 2:

Input: n = 3, time = 2
Output: 3
Explanation: People pass the pillow in the following way: 1 -> 2 -> 3.
After two seconds, the 3rd person is holding the pillow.

     */
    public static void main(String[] args) {
        //approach make an array of double the length of n , then iterate through the array and take nums % time = index
        //return element at index

        int n=4;
        int time =5;
        System.out.println(pillow_index(4,5));
    }

    static int pillow_index(int n , int time) {
        int [] arr = new int[n *2 -2];
        int rem = time % arr.length;
        int temp = 2;
        int index = 0;
        for (int i =1 ; i <= n*2 -2 ; i++ ){
            if( index > n-1){
                arr[index++] = i -temp;
                temp+=2;
            }else {
                arr[index++] = i;
            }
        }
        return arr[rem];
    }
}
