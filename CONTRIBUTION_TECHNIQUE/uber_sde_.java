import java.util.*;

import TREES.re_arrange_tree;
public class uber_sde_ {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int[n];
        for( int i  =0 ;i < n ; i++) arr[i] = s.nextInt();

        /*
          Problem --
            Given a array count the number of valleys in the array. 
            A valley is a subarray which has elements in this fashion.
             There is a index j in the subarray such that all the elements before j are strictly greater
            and all the elements after it in the subarray is strictly greater.

            Brute Force--

            Count all subarrays and count the valleys.

            how to count the valley
            Optimised -- 
            Contribution technique --focus on how one index element contributes in the whole answer..

         */
        //brute Force --
        int ans =0;
        for( int i= 0 ; i <n ;i++) {
            for( int j = i; j<n ; j++ ){
                if(j - i + 1 >= 3 && vaild(i , j , arr)){
                    ans++;
                }
            } 
        }
        System.out.println("Brute force --> " + ans);
        System.out.println("Optimised --> " + optimised(arr));
        // 5 4 2 3 4 4 11 12  ans - 4

    }

    static int optimised(int [] arr ){
        int n = arr.length;
        int [] pref = new int[n];
        int [] suf = new int[n];
        pref[0]=1;
        for( int i=1 ; i < n; i++ ) {
            if(arr[i-1] > arr[i]) {
                pref[i] = 1 + pref[i-1]; // continue
            }
            else {
                pref[i]=1; // can start a new one
            }
        }
        suf[n-1]=1;
        for( int i = n-2 ; i >= 0 ; i--) {
            if(arr[i+1] > arr[i]) {
                suf[i]  = 1 + suf[i+1];  //  continue
            }
            else {
                suf[i]=1; // can start a new one
            }
        }
        int ans =0;

        for( int i = 1 ; i < n-1 ; i++ ){
            //potential valley candidate
            if(arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
                ans += (pref[i]-1) * (suf[i]-1);
            }
        }
        return ans;
    }

    static boolean vaild(int l , int r, int [] arr) {
        int valleys = 0;
        int valley_idx = -1;
        for( int i = l+1 ; i <=r-1 ; i++ ){
            if(arr[i-1] > arr[i] && arr[i] < arr[i+1]) {
                valleys++;
                valley_idx=i;
            }
            if(valleys>1)return false;
        }
        if(valleys != 1) return false;
        for( int k = l + 1 ; k <= valley_idx-1 ; k++ ) {
            if(!(arr[k-1] > arr[k])) return false;
        }
        for( int k = valley_idx ; k < r ; k++ ){
            if(!(arr[k] < arr[k+1])) return false;
        }
        return true;
    }
    
}
