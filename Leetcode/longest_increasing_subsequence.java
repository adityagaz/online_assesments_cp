package Leetcode;

public class longest_increasing_subsequence {

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18}; //output = 4
        int[] arr1 = {7,7,7,7,7,7,7}; // output =1
        int[] arr2 = {0,1,0,3,2,3}; //output  =4

        //test cases
        System.out.println(longest_increasing_sub_string(arr2));
    }

    static int longest_increasing_sub_string(int[] arr) {
//        int max_count = 1;
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            int count = 1;
//            int last = arr[i];
//            for (int j = i + 1; j <= arr.length - 1; j++) {
//                if (arr[j] > arr[i] && arr[j] > last || arr[j] <last && arr[j] >arr[i]) {
//                     last = arr[j];
//                    count++;
//                }
//            }
//            if (max_count < count) {
//                max_count = count;
//            }
//        }
//        return max_count;
//    }
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] tails = new int[arr.length];
        int size = 0;
        for (int num : arr) {
            int left = 0, right = size;
            while (left != right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = num;
            if (left == size) {
                size++;
            }
        }
        return size;
    }

}