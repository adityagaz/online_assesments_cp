package TREES;
import java.util.*;
public class meesho_OA {

    /*
      Problem statement --
      MEESHO | 35LPA | TREES | NUMBER THEORY | DP ON TREES OPTIMISATION
      Given a tree with n nodes 1..n and each node can have a number in val[i].
      Your job is to find how many unique paths are there in the tree such that only one prime number exists in 
      that path.

      Approach 
      Path that has only one prime can be 
        1. start from Non-prime and end at Non Prime and include only one prime
        2. start from a prime and end at non prime

        So at every prime number we do a dfs till we find prime 
        we collect all the different branches count of non prime nodes. Now, we count all the paths by adding 
        the sum of paths and multiplying them. 
        [2 , 2 , 4] --> 2 (2+ 4 )  + 2 ( 4) - > arr[i] * (total_sum - pref[i]);
        also, at last we will add all those paths which start from prime node 
            that is simply sum of all branch sums 
        Now we do the same for all the primes in the tree and add the answer.
        Time Complexity - O(n*n) - Space - O(n*n);

        Can be optimised with Dp on trees.
     */

    static List<List<Integer>>  tree;
    static List<Integer> val;


    static boolean [] sieve( int n) {
        boolean [] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for( int i  = 2 ; i*i <= n ; i++) {
            if(isPrime[i]) {
                for( int j = i*i; j <= n ; j+=i) {
                    isPrime[j]= false;
                }
            }
        }
        return isPrime;
    }

    static boolean [] isPrime = sieve((int)1e5);
    static List<Integer> primes;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        val = new ArrayList<>();
        tree= new ArrayList<>();
        primes = new ArrayList<>();
        val.add(0);
         for( int i = 1 ; i <= n ; i++ ) {
            int ip= s.nextInt();
            val.add(ip);
            if(isPrime[ip]) {
                primes.add(i);
            }
        }
        for( int i = 0 ; i <= n ; i++ ) {
            tree.add(new ArrayList<>());
        }
        for( int i = 0 ; i < n-1 ; i++) {
            int u = s.nextInt();int v = s.nextInt();

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

       Map<Integer, List<Integer>> combinations = new HashMap<>();

        for( int root : primes ) {
            List<Integer> tempAns = new ArrayList<>();
            for( int i : tree.get(root)){
                tempAns.add(dfs(i , root));
            }
            combinations.put(root, tempAns);
        }
        long ans = calculateCombinations(combinations);
        System.out.println(ans);
    }

    static long calculateCombinations(Map<Integer , List<Integer>> map) {
        long ans = 0;   
        for(int prime : map.keySet()) {
            List<Integer> lengths = map.get(prime);
            long sum = 0;
            long runningSum = 0;
            long pref_sum = 0;

            for(int i : lengths)  sum += i;
            for( int i = 0 ; i < lengths.size(); i++) {
                pref_sum += lengths.get(i);
                runningSum += lengths.get(i) * (sum - pref_sum);
            }
            runningSum += sum; //paths for prime to non-prime
            ans += runningSum;
        }
        return ans;
    }
    static int dfs(int node , int parent ) {
        if(isPrime[val.get(node)] ) {
            return 0;
        }
        int cnt =1;
        for(int i :  tree.get(node)) {
            if (i != parent) {
                cnt += dfs(i , node );
            }
        }
        return cnt;
    }
}


/*
  
10
1 2 4 6 8 3 14 12 10 16
1 2
2 3
2 5
2 4
5 6
6 7
6 8
8 9
8 10

ans - 22
 */