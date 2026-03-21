package BitManipulation;

public class lonely_number {
    public static void main(String[] args) {
        int [] arr = {1,2,3,2,1,5,5,6,6,7,3,9,7};
        int result = 0 ;

        for( int i : arr) {
            result ^= i;
        }
        System.out.println(result);
    }
}
