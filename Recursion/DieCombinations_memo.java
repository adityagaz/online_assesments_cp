package Recursion;

public class DieCombinations_memo {

    public static void main (String [] args) {
        int n = 30;
        int k = 30;
        int target = 500;

        //creating a memo table
        Integer [][] memo = new Integer[n*20][k*20];
        System.out.println(CountWaysToGetTarget(n,k,0,target, 0 ,memo));
        //good you did it!!



    }
    static int CountWaysToGetTarget(int n , int k , int i , int target , int num , Integer [][]memo) {


        if(i ==  n) {
            int count = 0;
            if(target == num) {
                return 1;
            }
            else {
                return 0;
            }
        }


        int ans = 0;
        for(int j = 1 ; j <= k ; j++ ){
            int t = num+j;
            if(t > target ) {
                continue;
            }
            int one = -1;
            if(i>0 && memo[i][t] != null) {
                one=  memo[i][t];
            }
             else {
                one = CountWaysToGetTarget(n,k,i+1,target,t , memo);
            }
            ans += one ;
            memo[i][t]= one;
        }

        return ans;

    }



}
