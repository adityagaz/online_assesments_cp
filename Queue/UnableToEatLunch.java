package Queue;
import java.util.*;
public class UnableToEatLunch {
    public static void main (String [] args) {
        int [] sandwiches = {1,0,1,0,0,1,1,0,0,0};
        int [] students = {0,0,0,1,1,1,1,0,0,0};
        System.out.println(unableToEat(students , sandwiches));

    }
    static int unableToEat(int [] stud , int [] sand) {
//        Queue<Integer> q = new LinkedList<>();
//        Stack<Integer> st = new Stack<>();
//        for ( int i : stud) q.add(i);
//        for ( int j = sand.length -1; j>=0 ; j-- ) st.push(sand[j]);
//        int rot =0;
//        while(!st.isEmpty() && !q.isEmpty()) {
//            if(st.peek() == q.peek()) {
//                st.pop();
//                q.remove();
//                rot = 0;
//            }
//            else{
//                rot++;
//                int front = q.remove();
//                q.add(front);
//                if(rot >= st.size()) {
//                    break;
//                }
//            }
//
//        }
//        return q.size(); //naive approach
        Stack<Integer> st = new Stack<>();
        for( int j = sand.length -1 ; j>=0 ; j--) {
            st.push(sand[j]);
        }
        int ctone = 0;
        int ctzro = 0;
        for ( int i : stud) {
            if(i ==0) ctzro++;
            else ctone++;
        }
        while(!st.isEmpty()) {
            if(st.peek() == 0  && ctzro == 0) {
                return ctone;
            }
            else if(st.peek() == 1 && ctone == 0) {
                return ctzro;
            }
            else if(st.peek() == 0 && ctzro != 0) {
                st.pop();
                ctzro--;
            }
            else if(st.peek() == 1 && ctone != 0) {
                st.pop();
                ctone--;
            }
        }
        return 0;

    }
}
