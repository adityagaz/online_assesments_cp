package DSA_BEST_TEMPLATES.TWO_POINTERS;
import java.util.*;
public class longest_repeating_character_replacement {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0 ) {
            String str = s.next();
            int  k  = s.nextInt();

            System.out.println(solve(str ,  k));
        }
    }
    static int solve( String str , int k)  {

        int ans = 1;

        int n = str.length();

        for( int i  = 0 ; i <=25 ; i++) {
            char ch = (char) (i + 'A');

            int tail = 0 , head =-1;

            //ds-- non ch chararters -- till cnt <=k keep increasing and once it goes more than k shrink

            int cnt =0;

            //answer 
            int answer = 1;

            while(tail < n ) {
                while(head + 1 < n && (cnt + (str.charAt(head+1)==ch ? 0 : 1) <= k)) {
                    head++;
                    if(str.charAt(head)!=ch)cnt++;
                }

                //update the answer

                answer = Math.max(answer, head - tail +1);

                if(tail > head ){
                    tail++;
                    head = tail-1;
                }
                else {
                    if(str.charAt(tail) != ch ) {
                        cnt--;
                    }
                    tail++;
                }
            }

            ans  = Math.max(ans , answer);

        }



        return ans;


    }
}
