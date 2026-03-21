package Leetcode;

import java.util.Map;
import java.util.SplittableRandom;

public class crawler_frog {
    /*1598. Crawler Log Folder
Easy
Topics
Companies
Hint
The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.

     */

    public static void main(String[] args) {

        String arr [] =  {"d1/","d2/","../","d21/","./"};//2
        String arr2 [] =  {"d1/","d2/","./","d3/","../","d31/"};//3
        String arr3 [] =  {"d1/","../","../","../"};//0
        String arr4 [] =  {"./","../","./"}; //0

        System.out.println(minimum_op(arr4));

    }
    static int minimum_op(String [] arr){
        int count = 0;
        for (String i : arr) {
            if (i.equals("../") && count != 0) {
                count -= 1;
            } else if (i.equals("./")) {
                continue;
            } else {
                if(count == 0 && i.equals("../")){
                    continue;
                }
                else {
                    count++;
                }
            }
        }
        return count;
    }

}
