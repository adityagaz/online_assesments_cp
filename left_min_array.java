import java.io.*;
import java.util.*;

public class left_min_array implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new left_min_array (), "whatever", 1 << 30).start();
}

@Override
public void run() {
    try {
        setupIO(); 
        out = new PrintWriter(System.out);
        FastReader sc = new FastReader();

        solve(sc);

        out.flush();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


/*
Small Observations:

for an array 
pre compute another array --> leftMinArray[i] denotes smallest element to the left 

[3 4 2 1 5]
[-1 3 2 1 1] 


also calculate the right min array -->

rightMinArray[i] -> denotes the smallest element to the right

[3 4 2 1 5]

[ 1  1  1  1 -1]


Logic :


*/



static void solve(FastReader sc ) throws Exception {
    int t = sc.nextInt();
    // int t = 1;
    while(t-- > 0) {

    	int n = sc.nextInt();
    	int [] arr = new int[n];
    	for( int i = 0 ; i< n ; i++ ) arr[i] = sc.nextInt();

    	int [] leftMinArray = new int[n];
    	leftMinArray[0] = -1;
    	int min_till = arr[0];

    	for (int i = 1 ; i < n ; i++) {
    		if(arr[i] < min_till) {
    			min_till = arr[i];
    		}
    		leftMinArray[i] = min_till;
    	}

    	int [] rightMinArray = new int[n];
    	min_till = arr[n-1];
    	rightMinArray[n-1]=-1;
    	for( int i = n-2; i >= 0 ; i--) {
    		if(arr[i] < min_till) {
    			min_till = arr[i];
    		}
    		rightMinArray[i]=min_till;
    	}

    	for( int i  : leftMinArray) System.out.println(i+ " ");
    	System.out.println();
    	for( int i  : rightMinArray) System.out.println(i+ " ");
    }
}





































private static void setupIO() throws Exception {
    String inputPath  = "/Users/aditya/CP/online_assesments_cp/input.txt";
    String outputPath = "/Users/aditya/CP/online_assesments_cp/output.txt";

    System.setIn(new FileInputStream(inputPath));
    System.setOut(new PrintStream(new FileOutputStream(outputPath)));
}


    // —— FASTREADER ——
    static class FastReader {
        BufferedReader b; StringTokenizer s;
        public FastReader() { b = new BufferedReader(new InputStreamReader(System.in)); }
        String next() { while(s==null||!s.hasMoreElements()){ try { s=new StringTokenizer(b.readLine()); } catch(IOException e){ e.printStackTrace(); } } return s.nextToken(); }
        int nextInt()    { return Integer.parseInt(next()); }
        long nextLong()  { return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next()); }
        String nextLine(){ String str=""; try{ if(s!=null&&s.hasMoreTokens()) str=s.nextToken("\n"); else str=b.readLine(); } catch(IOException e){ e.printStackTrace(); } return str; }
    }
}