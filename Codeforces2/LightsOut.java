package Codeforces;
import  java.util.*;
public class LightsOut {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [][] ip = new int[3][3];
        for( int i  = 0 ; i < 3  ;i ++ ) {
            for( int j = 0 ;  j < 3 ; j++ ){
                ip[i][j] = s.nextInt();
            }
        }
        currentState(ip);
    }
    static void currentState( int [][] ip) {
        int [] [] res = new int[3][3];
        for( int [] i : res) {
            Arrays.fill(i , 1);
        }
        for( int i  = 0 ; i < 3  ; i ++ ) {
            for( int j = 0 ;  j < 3 ; j++ ){
                if(ip[i][j] % 2 != 0)  {
                    //if odd
                    if(i -1 >= 0 ) {
                        if(res[i-1][j] == 0){
                            res[i-1][j] = 1;
                        }
                        else {
                            res[i-1][j] = 0;
                        }
                    }
                    if(i+1 <=2) {
                        if(res[i+1][j] == 0){
                            res[i+1][j] = 1;
                        }
                        else {
                            res[i+1][j] = 0;
                        }
                    }
                    if(j+1 <=2) {
                        if(res[i][j+1] == 0){
                            res[i][j+1] = 1;
                        }
                        else {
                            res[i][j+1] = 0;
                        }
                    }
                    if(j-1 >=0) {
                        if(res[i][j-1] == 0){
                            res[i][j-1] = 1;
                        }
                        else {
                            res[i][j-1] = 0;
                        }
                    }
                    if(res[i][j] == 0 ) {
                        res[i][j] = 1;
                    }
                    else {
                        res[i][j] = 0;
                    }

                }
            }
        }
        for( int [] i : res) {
            for( int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
