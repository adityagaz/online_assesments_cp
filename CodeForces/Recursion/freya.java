package CodeForces.Recursion;

import java.util.Scanner;
import java.util.*;

public class freya {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            int k = s.nextInt();
            System.out.println(solve(x, y, k));
        }
    }
    static int solve(int x , int y , int k) {
        int floor_x = (x + k -1) /k;
        //it means it takes [x/k] steps to go to reach x from 0 by incrementing each time by k steps
        int floor_y = (y + k -1) /k;
        //it means it takes [y/k] steps to go to reach y from 0 by incrementing each time by k steps
        int res = 0;

        if(floor_x <= floor_y) {
            res = 2 * floor_y;
            //since it starts from x and in the next move goes to y
        }
        else{
            res = 2 * floor_x -1;
        }

        return res;
    }
}
