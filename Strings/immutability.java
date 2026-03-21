package Strings;

import java.lang.invoke.StringConcatFactory;

public class immutability {
    public static void main(String[] args) {
        //when two objects with the same name are created then java internally makes every object points to the same value in heap.
        //for example
        String a =  "aditya";
        String b = "aditya";

        //since these strings are having the same value then a and b are pointed to same location in the heap

        //Strings are immutable  why ??
        // for example we have a database of name of some members if suppose four people have the same name "aditya"
        //and one person decides to change their name in the database so if the string is mutable all four member's name would be changed
        // there fore strings are immutable

        //now aditya tell me one thing if strings are immutable how to check

        // if we want to check if value and location are same for two objects then we can use a == in java if we  just want to compare
        //strings by value we can go for .equals() method
        System.out.println(a.equals(b));

        System.out.println(a==b); //outputs true

        //hey aditya now if say that no bro if we explicitly want to have the same value but different objects
        // then we can use new keyword just like arrays

        String c = new String("aditya");
        String d = new String("aditya");

        System.out.println(c==d); //outputs false because it is stored in different location
        //remember String class is not mutable but StringBuilder Class is mutable



    }
}
