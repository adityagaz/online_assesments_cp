package Arrays;

public class rotate_max {
    public static void main (String [] args) {
        int [] arr =   { 4,4,4,4};

        System.out.println(solve(arr));
    }
    static int solve(int [] arr) {

        int max = Math.max((arr[0] + arr[arr.length -1]) ,arr[0] + arr[1] );

        for(int i = 1  ; i <= arr.length -2 ; i++) {
            if((arr[i] + arr[i+1] ) > max) {
                max = arr[i] + arr[i+1];
            }
        }

        return max;
    }
}
