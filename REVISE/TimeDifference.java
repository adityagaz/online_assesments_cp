package REVISE;
import java.util.*;
public class TimeDifference {

    public static void main (String [] args){
        String t1 = "23:30";
        String t2 = "00:10";
        String []  time = {
                "23:59","00:00"
        };
        //tell the time difference that is 1
        List<String> timePoints = new ArrayList<>(List.of(time));

//        System.out.println(timePoints);
        System.out.println(minDiff(timePoints));

        //O(n^2) approach

    }

    static int minDiff(List<String> timePoints) {
        int  min = Integer.MAX_VALUE;
        for( int i = 0 ; i < timePoints.size() ; i++ ){
            for(int j = i+1 ; j < timePoints.size() ;j++) {
                 min = Math.min(min , (difference(timePoints.get(i) , timePoints.get(j))));
            }
        }

        return min;
    }


    static int difference(String t1 , String t2) {
        int difference = 0;
        String [] time1 = t1.split(":");
        String [] time2 = t2.split(":");
        int h1= Integer.parseInt(time1[0]);
        int m1= Integer.parseInt(time1[1]);
        int h2= Integer.parseInt(time2[0]);
        int m2= Integer.parseInt(time2[1]);

        if(h1 < h2) {
            m1 = 60 - m1;
            h1++;
            difference = (h2 - h1) * 60 + m1 + m2;
        }
        else if( h1 > h2) {
            m1 = 60-m1;
            h1++;
            difference= ((24+h2) - h1)* 60 + m1 +m2;
        }
        else {
            if(m1 <= m2) {
                difference = m2 -m1;
            }
            else {
                difference = 23*60 + (60 -m1) + m2;
            }
        }

        return difference;
    }
}
