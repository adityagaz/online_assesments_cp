package TREES;
import java.util.*;
public class can_rearrange_to_form_palindrome {


    /*
        DE_SHAW OA AND GOOGLE SDE III | INTERVIEW | HASHING ON TREES
        Problem -
        Given a tree of N nodes and N-1 edges. At each node we can have characters we can have lowercase English Alphabet 
        characters.
        Your task is to find whether the characters from root node to this node i can be re arranged to form a palindrome
        or not.

        Constraints - 
        n<=1e6
        val[i] <=26 english alphabets

        Test cases-
        7
        a b a a b c d
        0 1
        0 2
        1 3
        1 4
        2 5
        2 6
        ans = [true , false , true , true , true, true , true]

        Idea --

        Whenever a tree problem is given think of an array first or say a linear skewed tree.
        Now in a linear tree if we are at index i and if we need that characters from 1...i can be rearranged in some order
        to make a palindrome.
        Now what is the condition to make a palindrome ? 
        All the characters should have even frequency and at max one character can have odd frequency.
        becuase if string length is even then we must have all even frequencies and if we have odd string length then 
        we can have only 1 odd number in between and rest all should be even. (Imagine palindrome)

        Now for an array : if we are standing at index i count in the hashmap how many characters have even frequencies and 
        how many have odd frequencies. If more than one is odd early return false.
        Other wise mark index i as true.

        Now going to trees.
        We can do type 1 dfs:
        ///////////
        GOING DOWN
        ///////////
        mark visited
        when going down add the char to the map.
        check the map 
        store the answer in the array for node i

        ///////////
        REGULAR DFS CALL

        dfs(child , node)
        ///////////

    

        /////////////////
        COMING UP
        remove the freq of the character from the map
        if character freq becomes zero remove it from the map

        O(N*26)
     */

    static boolean [] ans ;
    static Map<String , Integer> map;
    static String [] values;
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t =s.nextInt();
        while(t-- > 0){
            int n = s.nextInt();
        s.nextLine();
        boolean [] vis  = new boolean[n];
        ans = new boolean[n];
        map = new HashMap<>();
        values = s.nextLine().split(" ");
        List<List<Integer>> tree = new ArrayList<>();
        for( int i = 0 ; i <= n ; i++ ) {
            tree.add(new ArrayList<>());
        }
        for( int i = 0 ; i + 1 < n ; i++ ) {
            int u= s.nextInt();int v = s.nextInt();
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        System.out.println(Arrays.toString(values));

        dfs(0 ,-1 , vis , tree);
        System.out.println(Arrays.toString(ans));
        }

        
    }

    static void dfs(int node , int parent , boolean [] vis , List<List<Integer>> tree) {
        vis[node]=true;
        map.put(values[node], map.getOrDefault(values[node], 0) +1);
        int e_c = 0 , o_c =0;
        for( String i : map.keySet()) {
            // loop can go max 26 characters O(26)
            int freq = map.get(i);
            if((freq&1)==1)o_c++;
            else e_c++;
            if(o_c > 1) {
                break;
            }
        }
        ans[node] = o_c <= 1;

        /////////
        //REGULAR DFS
        for( int u : tree.get(node)) {
            if(u!=parent && !vis[u]) {
                dfs(u , node , vis , tree);
            }
        }

        //////////
        //COMING UP
        int freq = map.get(values[node]);
        if(freq == 0) {
            map.remove(values[node]);
        }
        else map.put(values[node] , freq-1);
    }
}

/*

Test cases 
5
1
a
4
a b b a
0 1
1 2
2 3
5
a b b c d
0 1
0 2
0 3
0 4
6
a a b a b a
0 1
1 2
2 3
3 4
4 5
5
a b b b b
0 1
1 2
0 3
3 4

Answers-

[true]
[true,false,true,true]
[true,false,false,false,false]
[true,true,true,false,true,true]
[true,false,true,false,true]

 */