import java.io.*;
import java.util.*;
//https://codeforces.com/problemset/problem/34/B
public class cf_div2_34_b implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div2_34_b (), "whatever", 1 << 30).start();
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

	If the price is negative it means they are ready to pay me...
	it is the most win win situation coz i am earning money by buying and not spending money

	so it makes sense to take all of the tv sets with negative price and then the sets with zero price and then the positive ones.

	So....
	it makes sense to sort the array and take the first 'm' sets...

	now if a[i] < 0 then we add to the price otherwise we subtract from the total sum.

	we donot need to subtract coz we can take atmost 'm' sets we are not required to take exactly 'm' sets so...


	we will be greedy and take only the negative ones


Logic :
	

*/



static void solve(FastReader sc ) throws Exception {

    // int t = sc.nextInt();
    int t = 1;

    while(t-- > 0) {

    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	int [] arr = new int[n];
    	for( int i = 0 ; i < n ; i++ )arr[i] = sc.nextInt();
    	Arrays.sort(arr);
    	int sum = 0;
    	for( int i = 0; i < m ; i++) if(arr[i] < 0) sum+=-arr[i];
    	System.out.println(sum);
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