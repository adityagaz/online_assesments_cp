package Arrays;

import java.util.Scanner;

public class colnofixedsize {

    public static void main(String[] args) {

        int [][] arr = {{
            1,2,3
        }, {
            4,5
        }, {
            7,8,9
        }};


        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                System.out.println(arr[i][j]);
            }
        }
    }

    public static class fibonacci {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);


            int number = in.nextInt();
            int p = 0;
            int i = 1;

            int count =2;
            System.out.println(0);
            System.out.println(1);

            while ( count <= number) {
                int temp = i;
                i +=p;
                p =temp;
                count++;
                System.out.println(i);
            }

            System.out.println("The Arrays.colnofixedsize.fibonacci number is  : " +  i );
        }
    }
}


