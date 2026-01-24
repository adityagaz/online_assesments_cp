import java.io.*;
import java.util.*;
//https://codeforces.com/problemset/problem/1360/B
public class cf_div3_644_b implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div3_644_b (), "whatever", 1 << 30).start();
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
	

	given an array -> partition them into two arrays such that
	fx = | max(A) - min(B)| is minimum 

	we have to minimise this function 

	the minimum value of this mod can go zero.
	
	fx >= 0

	goal -- find two elements in the array such that their 
			difference is the minimum.

	if we iterate from i = 0 .. n 
		then j = i + 1 ... n 
			then check 

	{TC - n^2}

	Observation --- when will numbers will have minimum difference ?? 
			if we have sorted numbers then their adjacent differences can be our answer.

			proof :: if the array is sorted then for any i we know that 
			diff(a[i] , a[i+1]) < diff(a[i] , a[i+2]) 

			a[i+1] - a[i]  < a[i+2] - a[i]

			=> a[i+1] < a[i+2]

	

	a1 a2 a3 a4 ...  a5


	Exchange arguments :: 
		argument 1 : i chose a1 and a4 => this says |a4 - a1| is the minimum.
		argument 2 : i chose a1 and a2 => this says |a2 - a1| is the minimum.


		let's assume argument 1 is correct : 


			a4 - a1 < a2 - a1 

			can you notice something ?? 

			IT IS INDEPENDENT OF A1

			a4 < a2 

			this means we have to sort it according to a1>a2>a3>a4>a5...

Logic :

sort the array
check the minimum adjacent difference..



*/



static void solve(FastReader sc ) throws Exception {

    int t = sc.nextInt();
    // int t = 1;

    while(t-- > 0) {
    	int n = sc.nextInt();
    	int []arr = new int[n];
    	for ( int i = 0 ; i < n  ; i++) arr[i] = sc.nextInt();
    	Arrays.sort(arr);
    	int ans = (int)1e9;

    	for( int i = 0 ; i < n-1 ;i++) {
    		ans = Math.min(ans , arr[i+1] - arr[i]);
    	}
    	System.out.println(ans);
       
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