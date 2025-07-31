package UNSEEN_ALGOS;

import java.util.*;

public class M_Maximum_Subarray_Alternating_Sum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0) {
            int n = s.nextInt();
            int [] arr = new int[n];
            for( int i = 0; i < n ; i++ ) arr[i] = s.nextInt();
            solve(arr , n);
        }
    }

    static void solve(int [] arr , int n) {
	    long [] mxP = new long[n];
	    long [] mxN = new long[n];
	    mxP[0] = arr[0];
	    mxN[0] = -arr[0];
        long max = mxP[0];
	    for( int i = 1 ; i < n ; i++ ) {
	        mxP[i] = Math.max(arr[i] , (long) arr[i] + mxN[i-1]);
	        mxN[i] = Math.max(-arr[i] , (long) -arr[i] + mxP[i-1]);
            max = Math.max(max , mxP[i]);
	    }
	    System.out.println(max);
	}
}