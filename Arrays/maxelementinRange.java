package Arrays;

public class maxelementinRange {

    public static void main(String[] args) {
        int [] arr = {1, 2,3, 4, 23,444,21} ;
        //find the max element in the range from index 2 till 4

        int start =2 ;
        int end = 4;
        System.out.println("The max value in the range is : " + maxRange(arr , 2 ,4));

    }
    static int maxRange(int [] arr  ,int start , int end) {
    //edge cases
        if (arr == null ) {
            return -1;
        }

        if (arr.length == 0) {
            return -1;
        }

        if(end < start ) {
            return -1;
        }
        //logic part
        int max_val = arr[start];
        for (int i = start; i <= end; i++) {
            if(arr[i] > max_val) {
                max_val = arr[i];
            }
        }
        return  max_val;
    }
}
