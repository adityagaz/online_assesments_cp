package Leetcode;

import java.util.Arrays;
import java.util.Collections;

public class koko_bananas {
    public static void main(String[] args) {
        int [] piles =  {312884470}; // [4,11,20,23,30]
        int h = 968709470;
        int eats = 30;
//        System.out.println(min_eat_speed(piles , h));
        System.out.println(min_eat_speed_two(piles , h));
    }

    static int min_eat_speed_two  (int [] piles , int h) {
        int start  = 1 ;
        int end  = Integer.MIN_VALUE;
        for (int i= 0 ; i < piles.length ; i++ ) {
            if(piles[i]  > end) {
                end = piles[i];
            }
        }
        while (start < end ) {
            int mid = start + (end - start) /2 ;

            if(can_complete_two(piles ,mid , h)) {
                end = mid;
                if(start == mid ) return start;
            }
            else {
                start = mid +1;
            }
        }
        return start;
    }


    static int min_eat_speed(int [] piles , int h) {
        Arrays.sort(piles);
        //sort the array
        //start from the last and tell me the point where it can't complete within hours
        //visualize that the answer will lie between that point and the last of the array
        int cannot_complete = -1;
        int can_complete = piles.length -1;
        for ( int i = can_complete ; i>=0 ; i--) {
            if(!can_complete(piles , piles[i], h)) {
                cannot_complete = i;
                break;
            }
         }
        if(cannot_complete == -1) {
            return piles[0];
        }
        int start = piles[cannot_complete] ;
        int end = piles[can_complete];
        while(start < end) {
            int mid = start + (end - start) /2;
            if(can_complete(piles , mid , h )) {
                end = mid;
                if(start == end) {
                    return start;
                }
            }
            else {
                start = mid+1;
            }
        }

        return start;
    }

    static boolean can_complete_two(int [] piles , int eats , int h ) {
        int hours_to_complete = 0 ;
        int i = 0 ;
        while (i < piles.length) {
            int quo = piles[i] / eats;
            int rem = piles[i] % eats;
            if(rem == piles[i] ) {
                hours_to_complete++;
            }
            else if( rem == 0 ) hours_to_complete += quo;
            else {
                hours_to_complete += quo +1;
            }
            if(hours_to_complete > h) {
                return false;
            }
            i++;
        }
        if(hours_to_complete <= h ) {
            return true;
        }
        else {
            return false;
        }
    }

    static boolean can_complete ( int [] piles , int eats , int h ) {
        int hrs_to_complete = 0 ;
        int i = 0 ;
        while (i < piles.length) {
            int rem = piles[i];
            while (rem > 0) {
                rem -=eats;
                hrs_to_complete++;
            }
            if(hrs_to_complete > h) {
                break;
            }
            i++;
        }
        if(hrs_to_complete <=h) {
            return true;
        }
        else {
            return false;
        }
    }
}
