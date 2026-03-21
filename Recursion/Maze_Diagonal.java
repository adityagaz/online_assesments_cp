package Recursion;
import java.util.*;

public class Maze_Diagonal {

    public static void main (String [] args) {
        int row = 3;
        int column = 3;
        //we can go three ways -- down , right , diagonal

        //printing the number of ways to do that
        System.out.println(maze_diagonal(3,3, ""));
    }

    static ArrayList<String> maze_diagonal (int r , int c , String p) {

        if(r==1  && c==1) {
            ArrayList<String > list = new ArrayList<>();
            list.add(p);
            return list;
        }


        ArrayList<String> list = new ArrayList<>();


        //go down
        if(r > 1 ) {
            list.addAll(maze_diagonal(r-1 , c , p + "Do"));     // adds a string that i am going down
        }

        if ( c > 1) {
            list.addAll(maze_diagonal(r , c-1 , p + "R")); // adds a string i am going right
        }

        if(r >1 && c > 1) {
            list.addAll(maze_diagonal(r-1,c-1, p + "Dia"));
        }
        return list;

    }
}
