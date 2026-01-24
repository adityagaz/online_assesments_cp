import java.io.*;
import java.util.*;

public class cf_div3_642_b implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div3_642_b (), "whatever", 1 << 30).start();
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

we need to take at most k elements from array b and swap it to array a.

we need to make the max sum of array 'a'.

so we will swap the smallest k numbers with the largest ones in b.



Logic :

sort both arrays

keep i at 0 in  array 'a'

keep j at n-1 in array 'b'

while(a[i] < b[j]) sum += b[j]

once this condition violates it means all the other elements in b are smaller than 
this j since it is sorted and we are going backwards.

also the indices > i where the condition violates it is trivial to think
that all the further indices are greater than the ones left in b before indices ( < j)


so we add further from a[i]


*/



static void solve(FastReader sc ) throws Exception {

    int t = sc.nextInt();
    // int t = 1;

    while(t-- > 0) {

    	int n = sc.nextInt();
    	int k = sc.nextInt();

    	int [] a = new int[n];
    	int [] b = new int[n];

    	for( int i = 0 ; i < n ; i++ ) a[i] = sc.nextInt();
    	for( int i = 0 ; i < n ; i++ ) b[i] = sc.nextInt();


    	Arrays.sort(a);
    	Arrays.sort(b);



    	int sum = 0; 

    	for( int i = 0 , j = n-1; i < n && j >= 0; i++ , j--) {
    		if(k>0 && b[j] > a[i])
    		{
    			sum += b[j];
    			k--;
    		}
    		else {
    			sum += a[i];
    		}
    	}
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