import java.util.*;
public class C_Okabe_and_Boxes {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n*=2;
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        while(n-- > 0){
            String [] line = s.nextLine().split(" ");
            String op = line[0];
            int val = Integer.parseInt(line[1]);

            System.out.print(line); 
            
            // if(op=="add") {
            //     if(!st.isEmpty()) {
            //         if(st.peek() < val) {
            //             int popped  = st.pop();
            //             st.push(popped);
            //             ans++;
            //         }
            //         st.push(val);
            //     }
            // }
            // else {
            //     st.pop();
            // }

        }

        System.out.println(ans);
    }
}