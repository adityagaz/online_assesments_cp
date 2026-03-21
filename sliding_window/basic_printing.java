package sliding_window;

public class basic_printing {

    //trying to implement basic sliding window
    public static void main(String[] args) {

        String s = "cbaebabacd";

        String find = "abc";

        //try to print all strings of size 3 and store them in a string array and print the array .


    }

    static void sw_printing ( String s   , int l ) {
        //try to print windows of length l

        //try to implement for size 3 first
        int index =0 ;
        String [] str_array = new String[100];
        //write the first window
        int i = 0 ; int j =0 ;
        StringBuilder temp_str = new StringBuilder();
        for(i=0 ; i < 3 ; i++ ) {
            temp_str.append(s.charAt(i));
        }
        //first window done
        str_array[index++] = temp_str.toString();
//
//        for()
    }
}
