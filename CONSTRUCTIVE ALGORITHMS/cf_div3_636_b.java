import java.io.*;
import java.util.*;

public class cf_div3_636_b implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div3_636_b (), "whatever", 1 << 30).start();
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
	2 <= n <= 2*1e5  (n is always even)


	sum of (even/odd) number of evens = even
		2 + 2 = 4 (even) 
		2 + 4 + 6 = 12 (even)

	for odds :
		even number of odds 
			3 + 3  = 6(even)
		odd number of odds
			3 + 3 + 3 = 9 (odd)

	so if n/2 % 2 == 1 : odd number 
		then sum odd odd numbers = odd 
		and sum of odd even numbers = even 
		it will never be the same

	if n/2 % 2 == 1 : 

		then ans is "NO"
	else :
	  n/2 % 2 == 0: 


	  	assume n = 8 

	  		then n/2 = 4
	  			2 4 6 8  | 1 3 5 ? 
				
				for the fourth number... 
				
				e 2 : o 1 : diff = 1
				e 4 : o 3 : diff = 1
				e 6 : o 5 : diff = 1 
				e 8 : o ? : this number should accomodate all the earlier differences 

				so if n/2 has x numbers we will place even and odds like this 

				now for the last number to put such that the sum remains the same 

					we put last even + the accumulated difference 

						how does that guarantee that this (even + the accumulated difference) will be odd always

						since last number is even... + (n/2 numbers - 1) accumulated difference will be odd.

						and even + odd = will be odd so...



Logic :


*/



static void solve(FastReader sc ) throws Exception {

    int t = sc.nextInt();
    // int t = 1;

    while(t-- > 0) {

    	int n = sc.nextInt();

    	if((n/2) % 2 == 1) {
    		System.out.println("NO");

    	}
    	else {
    		int [] arr = new int[n];
    		int start = 2;

    		for( int i = 0 ; i < n/2 ; i++) {
    			arr[i] = start;
    			start += 2;
    		}
    		start = 1;
    		for( int i = n/2 ; i < n-1 ; i++) {
    			arr[i] = start;
    			start+=2;
    		}
    		arr[n-1] = arr[n/2 -1] + (n/2 -1);
    		System.out.println("YES");
    		for( int i : arr ) System.out.print( i + " ");
    		System.out.println();

    	}

       
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