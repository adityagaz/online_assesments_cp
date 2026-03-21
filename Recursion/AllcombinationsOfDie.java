package Recursion;
import java.util.*;

public class AllcombinationsOfDie {

    public static void  main( String []  args) {

        int n = 2; // there are two dies
        int k = 6; // outcomes of die are [1,2,3]
        int target =7; //which all throws sum upto target eg [1,2] [2,1]
//        System.out.println(genDieCombTarget(n,k,new ArrayList<>() , target));
        System.out.println(CountWaysToGetTarget(n,k,0,target ,0));
    }

    static List<List<Integer>> genDieAllComb(int n , int k , ArrayList<Integer> temp , int target){
        //base case
        if(temp.size() == n) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> t = new ArrayList<>(temp);
            list.add(t);
            return list;
        }
        List<List<Integer>> list = new ArrayList<>();

        for(int j = 1 ; j <= k ; j++) {
            temp.add(j);

            List<List<Integer>> one = genDieAllComb(n , k , temp ,target);
            temp.remove(temp.size()-1);
            list.addAll(one);
            }

        return list;
    }

    static List<List<Integer>> genDieCombTarget(int n , int k , ArrayList<Integer> temp , int target){
        //base case
        if(temp.size() == n) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> t = new ArrayList<>(temp);
            list.add(t);
            return list;
        }
        List<List<Integer>> list = new ArrayList<>();

        for(int j = 1 ; j <= k ; j++) {
            temp.add(j);

            List<List<Integer>> one = genDieCombTarget(n , k , temp ,target);
            temp.remove(temp.size()-1);
            int sum =0 ;
            if(one.size() > 0) {
                for(int i :one.get(0)){
                    sum+=i;
                }
                if(sum == target) {
                    list.addAll(one);
                }
            }
        }

        return list;
    }

    static int CountWaysToGetTarget(int n , int k , int i , int target , int num) {


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
            int one = CountWaysToGetTarget(n,k,i+1,target,t);
            ans += one;
        }

        return ans;

    }

}
