package VISA;

public class five {
    public static void main(String[] args) {
        int[] prices = {2, 4, 1, 5, 2, 6, 7};
        int[] algo   = {0, 1, 0, 0, 1, 0, 0};
        int k = 4;
        System.out.println(solution(prices, algo, k)); // 21
    }
    static long solution(int [] prices , int [] algo , int k) {
        int n = algo.length;
        long basePrice = 0L;
       for( int i= 0 ; i < n ;i++   ) {
            if(algo[i] == 1) {
                basePrice += prices[i];
            }else {
                basePrice -= prices[i];
            }
       }
        long [] gain = new long[n];
        for( int i  = 0; i < n ; i++ ) gain[i] = (algo[i] == 0 ) ? 2L * prices[i] : 0;
        long max = Long.MIN_VALUE;
        int h = -1, t = 0;
        long sum  = 0L;
        while(t < n ) {
            while(h + 1  < n && ((h+1)-t + 1) <= k ) {
                h++;
                sum += gain[h];
            }
            max = Math.max(max , sum);
            if(t > h ) {
                t++;
                h = t-1;
            }
            else {
                sum -= gain[t];
                t++;
            }
        }
        if (max == Long.MIN_VALUE ) max = 0;
        // System.out.println(max  + basePrice);
        return max+ basePrice;
    }
}
