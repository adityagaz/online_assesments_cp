package Recursion;
import java.util.*;
public class createSubsests {


    public static void main (String [] args) {

        String s= "abc";
        //output -- create all subsets
        // [ a , b, c, ab, bc, ac, abc (this is not same as number of permutations)
        ArrayList<String> subsets = new ArrayList<>();
        StringBuilder str =  new StringBuilder();
//        generateAllSubsets(s , subsets, str);
//
//        System.out.println(subsets);
        System.out.println(genCombWithAscii(str , s));
    }

    static void generateAllSubsets(String s , ArrayList<String> subsets ,
                                                StringBuilder str) {

        //base case
        if(s.isEmpty() ) {
            if(!str.isEmpty()){
                subsets.add(str.toString());
            }
            return;
        }

        str.append(s.charAt(0));
        generateAllSubsets(s.substring(1) , subsets , str);
        str.deleteCharAt(str.length() -1);
        generateAllSubsets(s.substring(1) , subsets , str);

    }

    static void generateAllSubsets2(String s , ArrayList<String> subsets ,
                                   StringBuilder str) {

        //base case
        if(s.isEmpty() ) {
            if(!str.isEmpty()){
                subsets.add(str.toString());
            }
            return;
        }

        generateAllSubsets2(s.substring(1) , subsets , str);
        str.append(s.charAt(0));
        generateAllSubsets2(s.substring(1) , subsets , str);
        str.deleteCharAt(str.length()-1);

    }



    //another way to not put array list in the parameter
    // challenge -- put the array list in each function call and then return it




    static ArrayList<String> genComb(StringBuilder str , String s) {

        if(s.isEmpty()) {
            if(!str.isEmpty()) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str.toString());
                return list;
            }
            else {
                return new ArrayList<>();
            }
        }


        ArrayList<String> left_ans = genComb(str.append(s.charAt(0)), s.substring(1));

        ArrayList<String> right_ans  = genComb( str.deleteCharAt(str.length() -1), s.substring(1) );
        //add answers from both lists
        left_ans.addAll(right_ans);

        return left_ans;
    }


    static ArrayList<String> genCombWithAscii(StringBuilder str , String s) {

        if(s.isEmpty()) {
            if(!str.isEmpty()) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str.toString());
                return list;
            }
            else {
                return new ArrayList<>();
            }
        }


        ArrayList<String> take_char = genCombWithAscii(str.append(s.charAt(0)), s.substring(1));
        str.deleteCharAt(str.length() -1);
        ArrayList<String>  take_ascii = genCombWithAscii(str.append(s.charAt(0) - 0), s.substring(1));
        str.deleteCharAt(str.length() -1 );
        ArrayList<String> not_take = genCombWithAscii( str.deleteCharAt(str.length() -1), s.substring(1) );
        //add answers from both lists

        take_char.addAll(take_ascii);
        take_char.addAll(not_take);
        return take_char;
    }
}


