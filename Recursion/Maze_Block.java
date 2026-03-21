package Recursion;
import java.util.*;
public class Maze_Block {

    public static void main (String [] args) {
        int row = 3;
        int column = 3;
        //we can go three ways -- down , right , diagonal


        //we have an boolean maze array that stores the true or false value so if the coordinate is
        //blocked we will have a false at that particular position

        boolean [][] maze = {
                {true ,true, true},
                {true , false , true},
                {true , true , true}
        };

        //so we basically have a obstacle in the middle we can't go through it

        //printing the number of ways to do that
        System.out.println(maze_diagonal_with_obstacle(0,0, "" ,maze));
    }

    static ArrayList<String> maze_diagonal_with_obstacle(int r , int c , String p , boolean [][] maze){
        if(r == maze.length -1 && c == maze[0].length -1 ) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list =  new ArrayList<>();

        if(maze[r][c] == false) {
            ArrayList<String> empty = new ArrayList<>();
            list.add("");
            return list;
        }

        if(r <  maze.length-1)
        {
            list.addAll(maze_diagonal_with_obstacle(r +1 , c , p + "Dow" , maze));
        }
        if(c   < maze.length -1 ) {
            list.addAll(maze_diagonal_with_obstacle(r  , c+1 , p + "R" , maze));
        }
        if(r < maze.length -1 && c <maze.length  -1  ) {
            list.addAll(maze_diagonal_with_obstacle(r+1 , c+1 , p + "Dia" , maze));
        }

        return list;

    }
}
