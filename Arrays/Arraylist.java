package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Arraylist {

    public static void main(String[] args) {
        //syntax
        // ArrayList < Integer >  list  = new ArrayList<>();

        ArrayList<Integer > list = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        //updating values: syntax list.set(index ,value)

        list.set(0 , 99 );
        //set 0th index to 99
        System.out.println(list);
        System.out.println(list.contains(99));
        //.contains(value) is used to detect whether the list contains the value or not
 //adding any number of entries and it's size dynamically increases

        //removing stuff

        list.remove(1);
        //remove index 1
        System.out.println(list);
        //accessing the items suppose i want to access the first element of the list
        // so we can't write list[0] like that instead we need to use list.get(index)

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) +  "  ");
            //accessing and printing the value one by one
        }
    }
}
