import java.io.*;
import java.util.*;

public class cf_div2_91_a implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div2_91_a (), "whatever", 1 << 30).start();
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



we have to find three indices i < j < k where a[i] < a[j] and a[j] > a[k].
if such three indices occur in array then return yes and print indices otherwise print no.


brute force is : three loops -- {n^3}
n<=1e4
won't pass
so....
we notice that we have an permutation of the array
so all elements are distinct

in these questions try to fix one variable and then work on the other two..

so let's fix the a[j]

	now the problem is to find to an index i < j where a[j] >  a[i]

	since it is a permutation if suppose a[j] = 5... then we have to look for elements 1...4
	on the left

		here map will help us get the index of the numbers

		loop on numbers less than 5 on the left and greater than 5 on the right..


3 <= a[j] <= n only...
least case can be 1 3 2




Logic :

store numbers with their indices in a map
fix a[j] : iterate on that


loop a[j] = 3 ... a[j] <= n :



*/



static void solve(FastReader sc ) throws Exception {

    int t = sc.nextInt();
    // int t = 1;


    while(t-- > 0) {

    	int n = sc.nextInt();
    	int [] arr = new int[n];
    	for ( int i = 0 ; i < n ; i++ ) arr[i]= sc.nextInt();
    	int idxL = -1;
    	int idxR = -1;
    	int idxMid = -1;
    	Map<Integer , Integer> map = new HashMap<>();

    	for( int i = 0; i < n ; i++ ) map.put(arr[i] , i);

    	int [] leftMin = new int[n];
    	int [] rightMin = new int[n];

    	leftMin[0] = (int)1e9;
    	rightMin[n-1] = (int)1e9;
    	int min_till_now = arr[0];
    	for( int i = 1 ; i < n ; i++) {
    		if(arr[i] < min_till_now) {
    			min_till_now = arr[i];
    		}
    		leftMin[i] = min_till_now; //precompute left Min
    	}

    	min_till_now = arr[n-1];
    	for( int i = n-2 ; i>=0;i--){
    		if(arr[i] < min_till_now) {
    			min_till_now = arr[i];
    		}
    		rightMin[i]= min_till_now; // pre compute right min
    	}


    	for ( int j = 3 ;  j <= n ; j++ ) {
    		idxL = -1;
    		idxR = -1;
    		idxMid = map.get(j);

    		if(leftMin[idxMid] < j && rightMin[idxMid] < j) {
    			idxL = map.get(leftMin[map.get(j)]);
    			idxR = map.get(rightMin[map.get(j)]);
    		}
    		if(idxL != -1 && idxR !=-1 ) {
    			break;
    		}
    	}
    	if (idxL != -1 && idxR !=-1) {
			//we found the index 
			System.out.println("YES");
			System.out.println(idxL + " " + idxMid + " " + idxR);
    	}
    	else {
    		System.out.println("NO");

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