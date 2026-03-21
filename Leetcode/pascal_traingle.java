package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class pascal_traingle {

    public static void main(String[] args) {
        System.out.println(calc_pascal(5));
    }
    static List<List<Integer>> calc_pascal (int n ) {
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        for( int i = 1 ; i <= n ; i++ ) {
            List<Integer> to_append = row_pascal(i);
            list.add( index , to_append);
            index++;
        }
        return list;
    }
    static List<Integer> row_pascal(int num ) {
        List<Integer> list = new ArrayList<>();
        if(num ==1 ) {
            list.add(1);
            return list;
        }
        if( num ==2 ) {
            list.add(1);
            list.add(1);
            return list;
        }
        list = row_pascal(num-1);
        List<Integer> list_temp = new ArrayList<>(list.size() +1);
        list_temp.add(0,1);
        list_temp.add(list_temp.size()-1 , 1);
        int start = 1;
        int end = num -2;
        for(int i = start ; i <= end ; i++ ) {

            int sum = 0 ;
            sum = list.get(i-1)+ list.get(i);
            list_temp.add(start , sum);
        }
        return list_temp;
    }


}
