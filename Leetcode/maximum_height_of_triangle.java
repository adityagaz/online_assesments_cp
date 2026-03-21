package Leetcode;

public class maximum_height_of_triangle {

    public static void main(String[] args) {

        int red =10;
        int blue =1;
        int possibility1 =  height_of_tree(10,1);
        int possibility2 =  height_of_tree(1,10);



    }

    static int height_of_tree (int red , int blue) {
        int height = 0;
        int i =1;
        while ( blue !=0 || red != 0) {
            if(i% 2 == 1) {
                if (blue >=i) {
                    blue -= i;
                    height++;
                    i++;
                }
                else{
                    break;
                }
            }
            else{
                if(red >=i) {
                    red -=i;
                    height++;
                    i++;
                }
                else {
                    break;
                }
            }
        }

        return height;
    }
}
