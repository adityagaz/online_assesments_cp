package sts;

import java.util.*;

public class permutation {
    public static void main(String [] args) {
        String s= "aal";
        //generate all permutations
        ArrayList<String> perms = new ArrayList<String>();
        generateperms(s , "" , perms);
        System.out.println(perms);
        HashSet<String> set = new HashSet<String>();
        set.addAll(perms);
        System.out.println(set);

    }
    static void generateperms(String s , String up , ArrayList<String> perms) {
        if(s.isEmpty()) {
            System.out.println(up);
            perms.add(up);
            return;
        }
        for( int i = 0 ; i <= up.length() ; i++ ) {
            String processed = up.substring(0, i) + s.charAt(0) + up.substring(i);
            generateperms(s.substring(1) , processed , perms);
        }
    }
}
