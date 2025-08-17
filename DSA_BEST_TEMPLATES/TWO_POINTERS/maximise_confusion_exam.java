package DSA_BEST_TEMPLATES.TWO_POINTERS;
import java.util.*;
public class maximise_confusion_exam {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0 ) {
            String str = s.next();
            int  k  = s.nextInt();

            System.out.println(maxConsecutiveAnswers(str ,  k));
        }
    }

    static int maxConsecutiveAnswers(String key, int k) {
        char [] options = {'T' , 'F'};
        int n = key.length();

        int res =1;
        for(char ch :options ) {
            int t = 0 , h = -1;

            // ds
            int cnt = 0;

            //local answer
            int ans = 0;

            while(t<n) {
                while(h+1<n && (cnt + (key.charAt(h+1)==ch ? 0 : 1 ) <= k)) {
                    h++;
                    if(key.charAt(h)!=ch) {
                        cnt++;
                    }
                }

                ans=Math.max(ans,h-t+1);

                if(t>h) {
                    t++;
                    h=t-1;
                }
                else {
                    if(key.charAt(t)!=ch) {
                        cnt--;
                    }
                    t++;
                }
            }

            res = Math.max(ans , res);
        }
        return res;
    }
}
