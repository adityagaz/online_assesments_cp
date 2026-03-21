package DP;
import java.util.*;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int []  wt = {4,5,1};
        int  [] val = {1,2,3};
        int capacity = 4;
        System.out.println(maximumCapacity(wt, val , capacity , val.length -1));


    }

    static int maximumCapacity(int [] wt , int [] val , int capacity , int index)   {
        if(capacity <= 0) {
            return 0;
        }
        if(index == 0) {
            if(capacity >= wt[0]){
                return val[0];
            }
            else {
                return 0;
            }
        }
        int pick = 0;
        if(capacity >= wt[index]) {
             pick = val[index] + maximumCapacity(wt , val, capacity - wt[index] , index-1);
        }

        int notPick = maximumCapacity(wt , val , capacity , index -1);
        return  Math.max(pick, notPick);
    }
}
