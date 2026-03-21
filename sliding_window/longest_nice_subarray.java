package sliding_window;

public class longest_nice_subarray {
    public static void main(String[] args) {

        int [] nums = {1,3,8,48,10};
        System.out.println(longestNiceSubarray(nums));
    }

    static int longestNiceSubarray(int[] nums) {
//        int i = 0 ;
//        int j = 0;
//        int max_size = 0;
//        int sub_arr =0;
//        while( j < nums.length) {
//            if((sub_arr & nums[j] ) == 0) {
//                sub_arr = sub_arr | nums[j];
//                max_size = Math.max(max_size , j-i+1);
//                j++;
//            }
//            else {
//                sub_arr ^= nums[i++];
//            }
//        }
//        return max_size;
//    }

        //another way
        int i = 0;
        int num = 0;
        int max = 0;
        for (int j = 0; j < nums.length; j++) {
            while ((nums[j] & num) != 0) {
                num ^= nums[i];
                i++;
            }
            num |= nums[j];
            max = Math.max(max, j - i + 1);
        }
        return max;
    }


}
