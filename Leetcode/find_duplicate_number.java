package Leetcode;

public class find_duplicate_number {

    public static void main(String []  args) {
        int [] arr= {3,1,3,4,2};
        System.out.println(duplicate_number(arr));
    }

    static int duplicate_number(int [] arr) {
// logic --> arrange every element to their correct index if the elements in the array are
// from [1,n] then arrange them from index 0 to n-1
//the correct index for each element is the value of that element -1;
//for example 4 should be at the index (4-1) that is three .

        int i =0;
        while(i < arr.length){
            int correct = arr[i] - 1; //found the correct index
            if(arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i]= arr[correct];
                arr[correct] = temp;
            }
            else {
                i++;
            }
        }


        //check which index is not at its correct position that will be your answer

        for( int  j = 0 ; j < arr.length ; j++ ){
            if(arr[j] != j+1) {
                return arr[j];
            }
        }

        return -1;
    }
}
