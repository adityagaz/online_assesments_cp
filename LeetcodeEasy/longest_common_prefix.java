package LeetcodeEasy;

public class longest_common_prefix {

    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println(longest_common_pre(strs));

    }
        static String longest_common_pre(String [] strs) {

        String smallest = strs[0];
        for(String i : strs ) {
            if(i.length() < smallest.length()) {
                smallest = i;
            }
        }
        while(smallest.length() > 0) {
            int count = strs.length;
            for(String i : strs) {
                if(i.substring(0 , smallest.length()).equals(smallest)) {
                    count--;
                }
            }
            if(count ==0) {
                return smallest;
            }
            else {
                smallest =smallest.substring(0 , smallest.length() -1);
            }
        }
        //loop to check if the smallest is a substring of all elements in strs or not if yes you got the answer else replace last index of
            //the string with "" and check again.

        return smallest;
    }
}
