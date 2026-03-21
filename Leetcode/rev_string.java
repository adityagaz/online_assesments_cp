package Leetcode;

public class rev_string {
    public static void main(String[] args) {
        char [] s = {'h','e','l','l','o'};
        reverse_string(s);
        System.out.println(s);
    }
    static void reverse_string (char [] s){
        int i = 0; int j = s.length -1;
        while ( i < j) {
            swap(s ,i , j);
            i++;j--;
        }
    }
    static void swap (char []  s ,int a ,  int b ){
        char temp = s[a];
        s[a] =s[b];
        s[b]=temp;
    }

}
