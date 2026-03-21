package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class rotate_array_by_ninety {
    /*
    You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.



Example 1:


Input: matrix = [[1,2,3],
                 [4,5,6],
                 [7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:


Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]


Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000
     */
    public static void main(String[] args) {
        int [] [] image_array  = {
                {1,2,3},{4,5,6}, {7,8,9}
        };
//        rotate_image(image_array); //this logic is correct but it cannot handle duplicate values
        rotate_image2(image_array); // first transpose the matrix and then reverse each smaller matrix


    }

    static void rotate_image2 (int [][] arr) {

        for (int i = 0; i < arr.length ; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i =0 ; i < arr.length ; i++ ){
            int start = 0 ;
            int end =arr[i].length -1;
            while(start < end) {
                int temp  = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }

        for (int i = 0 ; i < arr.length ; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
        //this is okay only if all the elements aren't unique
    static void rotate_image(int [][] arr ){
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++ ){
            for(int j  = 0 ; j <arr.length ; j++ ) {
                ArrayList<Integer> new_position =new ArrayList<>();
                int t_value = arr[i][j];
                int new_j = arr[i].length  - i -1 ;
                int new_i = j;
                new_position.add(new_i);
                new_position.add(new_j);
                map.put(t_value , new_position);
            }
        }
        for(Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();
            int i_n = map.get(key).get(0);
          int j_n = map.get(key).get(1);
          arr[i_n][j_n] = key;
        }
    }
}
