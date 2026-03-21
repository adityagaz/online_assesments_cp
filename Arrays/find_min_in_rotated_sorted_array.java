package Arrays;

public class find_min_in_rotated_sorted_array {

    public static void main(String[] args) {
        int arr [] = { 3,4,5,1,2};
        //this method won't be able to handle duplicate elements efficiently 

        System.out.println(min_in_rotated_sorted_array(arr));
    }

    static int min_in_rotated_sorted_array(int [] arr ){
        //logic
        //find mid then see to the right
        /*
        image you are standing at mid and if the middle element is smaller than the end element then you are in
        the sorted part of the array
        but if the mid is greater than the array then there is a break in the right part
        so we will have start = mid +1;
        now if we are getting the first condition that middle element is smaller than the last then we move
        right = mid
        and change the loop confition to while(Start < end)
        eventually start == end will happen and we will get our answer to the smallest element in the array
          2. once we get the index of the smallest element we will apply normal binary search on the two arrays
          from (0 to min-1) and (min - arr.len -1)
         */
        int start = 0;
        int end = arr.length -1;
        while ( start < end ) {
            int mid = start + (end - start  ) /2;
            if( arr[mid] >  arr[end] ) {
                //there is a break in the area from  [ mid .... last ]
                // make your search space to that area and definitely mid is not the answer so start = mid +1 not mid;
                start = mid +1;
            }
            else {
                //all the elements are sorted in [ mid ... last ]
                //now check the left side that is [ left ... mid]
                //also here mid could be the answer so the condition is end  = mid and not mid -1 ;
                //also to avoid infinite loop we have changed the original condition to start < end instead of start <= end

                end = mid;
            }
        }
        //at last start == end so return any of them
        return arr[start];
    }
}

