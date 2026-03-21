package LeetcodeEasy;

public class remove_outermost_parenthesis {

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(remove_outermost(s));
    }

    static String remove_outermost(String s  )   {
        int count = 0 ;
        StringBuilder result = new StringBuilder();
        int i = 0 ;
        while(i < s.length()) {
            if(s.charAt(i)  == '(') {
                count++;
            }
            else {
                count--;
            }
            if(count >1 ){
                if(s.charAt(i) == '(') {
                    result.append(s.charAt(i));
                    count++;
                }
                else {
                    result.append(s.charAt(i));
                    count--;
                }
            }
            i++;
        }
        return result.toString();
    }
}
