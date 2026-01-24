import java.io.*;
import java.util.*;

public class cf_div2_142_a implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div2_142_a (), "whatever", 1 << 30).start();
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
	
	spell 1  : we have a spell which adds +1 to our answer and decreases health by 1 for 2 monsters.
	it only makes sense if we have 2 monsters of health 1 and select both of them and kill them.

	spell 2 : another spell is we can count 1 and kill a monster regardless of their health..


	so... 

	if we kill all monsters from spell 2 we have n monsters --> so we require n spell usages.
	but if we have monsters of health 1 --> we can use spell 1 to kill 2 monsters at a time.

	which reduces the total count..

	so

	count the total number of monsters with health 1

	then we need floor(cnt / 2 ) steps to kill them all . 
	 + count of monsters with health > 1 



Logic :


*/



static void solve(FastReader sc ) throws Exception {

    int t = sc.nextInt();
    // int t = 1;

    while(t-- > 0) {

    	int n = sc.nextInt();
    	int [] arr = new int[n];
    	for( int i = 0 ; i < n ; i++ ) arr[i] = sc.nextInt();

    	int cnt = 0;
    	for( int i : arr) if (i == 1) cnt++;
    	int ans = cnt % 2 == 0 ? (cnt/2) + (n - cnt) : (cnt/2) + (n - cnt) + 1;
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