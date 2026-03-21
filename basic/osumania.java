package basic;

import java.util.Scanner;

public class osumania {
    /*
    memory limit per test256 megabytes
You are playing your favorite rhythm game, osu!mania. The layout of your beatmap consists of n
 rows and 4
 columns. Because notes at the bottom are closer, you will process the bottommost row first and the topmost row last. Each row will contain exactly one note, represented as a '#'.

For each note 1,2,…,n
, in the order of processing, output the column in which the note appears.

Input
The first line contains t
 (1≤t≤100
) — the number of test cases.

For each test case, the first line contains n
 (1≤n≤500
) — the number of rows of the beatmap.

The following n
 lines contain 4
 characters. The i
-th line represents the i
-th row of the beatmap from the top. It is guaranteed that the characters are either '.' or '#', and exactly one of the characters is '#'.

It is guaranteed that the sum of n
 over all test cases does not exceed 500
.

Output
For each test case, output n
 integers on a new line, the column that the i
-th note appears in for all i
 from 1
 to n
.

Example
InputCopy
3
4
#...
.#..
..#.
...#
2
.#..
.#..
1
...#
OutputCopy
4 3 2 1
2 2
4
     */
    public static void main (String [] args ) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 0 ; i < n ; i++) {
            int row = s.nextInt();
            s.nextLine();
            String [] arr = new  String[row];
            for (int j =0 ; j < row ; j++) {
                arr[j] = s.nextLine();
            }
            for( int  l = row-1 ; l >=0 ; l--) {
                for( int m = 0 ; m < 4  ; m++) {
                    if(arr[l].charAt(m) == '#'){
                        System.out.print(m+1+" ");
                        break;
                    }
                }
            }
            System.out.println();
        }

    }
}
