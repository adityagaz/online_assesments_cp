package Greedy;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

public class MinimumPeopleToTeach {

    public static void main(String [] args) {

        int [][] languages =  {
                {2},
                {1,3},
                {1,2},
                {3}
        };
        int [][] friendships = {
                {1,4},//no
                {1,2},//no
                {3,4},//no
                {2,3}
        };

        int n = 3 ;
        //no of languages
        System.out.println(MinTeach(n, languages ,friendships));

    }

    static int MinTeach(int n, int[][] languages, int[][] friendships)
    {
        HashMap<Integer , HashSet<Integer>> langmap = map_languages ( languages,  n );
        boolean[] comm = isCommunicating(friendships ,langmap);
        return MinTeachings( n,  langmap ,  comm ,friendships , languages );

    }

    static int MinTeachings(int n, HashMap<Integer , HashSet<Integer>> langmap ,  boolean [] comm ,int  [][]friendships ,int [][] languages ) {

        HashSet<Integer> nonCommunicatingUsers = new HashSet();
        int non_comms = 0 ;
        for (int i = 0 ; i < comm.length ; i++ )
        {
            if(!comm[i])
            {
                nonCommunicatingUsers.add(friendships[i][0]);
                nonCommunicatingUsers.add(friendships[i][1]);
            }
        }
        non_comms = nonCommunicatingUsers.size();
        if(non_comms == 0 ){
           return 0;
        }

        //how will we determine the most popular language
        HashMap<Integer , Integer> map = new HashMap<>();

        for( int i : nonCommunicatingUsers ){
           for(int j  : langmap.get(i)){
               map.put( j, map.getOrDefault(j , 0) +1);
           }
        }
        int  freq = Integer.MIN_VALUE;
        int max_spoken = 0;
        for( Map.Entry entry : map.entrySet()) {
            Integer value = (int)entry.getValue();
            Integer key = (int)entry.getKey();
            if( value > freq) {
               freq  = value;
               max_spoken = key;

            }
        }
        int answer = 0;
        for (int user : nonCommunicatingUsers) {
            if (!langmap.get(user).contains(max_spoken)) {
                answer++;
            }
        }

        return answer;
    }

    static HashMap<Integer , HashSet<Integer>> map_languages (int [][] languages , int n ) {
        HashMap<Integer , HashSet<Integer>> langmap = new HashMap<>();
        int i= 1;
        for (int [] user : languages) {
            HashSet<Integer> set = new HashSet();
            for(int lang: user) {
                set.add(lang);
            }
            langmap.put(i , set);
            i++;
        }
        System.out.println(langmap);
        return langmap;
    }

    static boolean[] isCommunicating(int  [][]friendships , HashMap<Integer , HashSet<Integer>> langmap) {
        boolean [] comm = new boolean[friendships.length];
        int index =0;
        for( int [] everyTwoFriend :friendships ) {
            HashSet<Integer> mixed = new HashSet();

            int f1 = everyTwoFriend[0];
            int f2 = everyTwoFriend[1];

            for( int i  : langmap.get(f1) ) {
                mixed.add(i);
            }
            for( int i  : langmap.get(f2) ) {
                mixed.add(i);
            }
            int x = langmap.get(f1).size();
            int y = langmap.get(f2).size();
            if( mixed.size() < x+y ) {
                //then we have a common language
                comm[index++ ] = true;
            }
            else {
                comm[index++ ] = false;
            }
        }
        return comm;
    }
}
