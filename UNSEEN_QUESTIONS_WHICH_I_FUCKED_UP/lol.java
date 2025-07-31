package UNSEEN_QUESTIONS_WHICH_I_FUCKED_UP;
import java.util.*;
public class lol {
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        n*=2;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        int req=1;
        while(n-- > 0){
            String [] line = s.nextLine().split(" ");
            String op = line[0];
             if(op.equals("add")) {
                 int val = Integer.parseInt(line[1]);
                 st.push(val);
 
             }
             else {
                     if(!st.isEmpty() && st.peek() !=req) {
                         ans++;
                        st.clear();
                     }
                     else {
                         if(!st.isEmpty())  {
                             st.pop();
                         }
                     }
                    req++;
 
                 }
 
        }
 
        System.out.println(ans);
    }
}