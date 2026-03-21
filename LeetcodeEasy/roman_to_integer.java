package LeetcodeEasy;

public class roman_to_integer {

    public static void main(String[] args) {
        String s =  "III";
        System.out.println(roman_to_integer(s));
    }

    static int roman_to_integer(String s) {
        int sum = 0 ;
        int i = 0 ;

        while ( i < s.length() ) {
            int current = i;
            Character ch = s.charAt(i);
            if( i!= s.length() -1 && ch == 'I' ) {
                if(s.charAt(i+1) == 'V') {
                    sum+=4;
                    i+=2;
                }
                else if(s.charAt(i+1) == 'X') {
                    sum+=9;
                    i+=2;
                }

            } else if (i!= s.length() -1 && ch =='X') {
                if(s.charAt(i+1) == 'L') {
                    sum+=40;
                    i+=2;
                }
                else if(s.charAt(i+1) == 'C') {
                    sum+=90;
                    i+=2;
                }

            }
            else if (i!= s.length() -1 && ch =='C') {
                if(s.charAt(i+1) == 'D') {
                    sum+=400;
                    i+=2;
                }
                else if(s.charAt(i+1) == 'M') {
                    sum+=900;
                    i+=2;
                }

            }
                if(current == i ) {
                    if(ch == 'I') sum+=1;
                    if(ch == 'V') sum+=5;
                    if(ch == 'X') sum+=10;
                    if(ch == 'L') sum+=50;
                    if(ch == 'C') sum+=100;
                    if(ch == 'D') sum+=500;
                    if(ch == 'M') sum+=1000;
                    i++;
                }
        }
        return sum;
    }


}
