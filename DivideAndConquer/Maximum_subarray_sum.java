package DivideAndConquer;

public class Maximum_subarray_sum {

    public static void main(String[] args) {


        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int result = max_sub_arr_sum(arr);

        System.out.println(result);
    }

    static int max_sub_arr_sum(int [] arr) {

        int start = 0 ;
        int end = arr.length -1;

        return max_sum(arr, start , end);
    }

    static int max_sum(int [] arr , int start , int end  ) {
        //base condition
        //if the start == end then return the element itself
        if( start == end  ) {
            return arr[start];
        }
        int mid = start + (end - start) /2;
        int lss = max_sum(arr, start , mid);
        int rss = max_sum(arr , mid+1, end);
        int left_max = Integer.MIN_VALUE;
        int right_max = Integer.MIN_VALUE;

        int sum =0;
        for( int i = mid; i >=start ; i--){
            sum+=arr[i];
            if(sum > left_max) {
                left_max = sum;
            }
        }
        sum = 0;
        for( int j = mid+1 ; j<=end ; j++) {
            sum +=arr[j];
            if(sum  > right_max ) {
                right_max = sum;
            }
        }
        int css = left_max+right_max;

        return Math.max(Math.max(lss, rss) , css);
    }

}
