package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class multiarraylist {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//initialisation
    for (int i = 0 ; i < 3 ; i++){
        list.add(new ArrayList<>());
    }
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list.get(i).add(in.nextInt());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

            //[1, 2, 3]
            //[4, 5, 6]
            //[7, 8, 9]
        }
    }
}
