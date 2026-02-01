import java.io.*;
import java.util.*;

public class cf_div2_65_a implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new cf_div2_65_a (), "whatever", 1 << 30).start();
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

	check if string length goes beyond 10
		then output string[0] + size + string[size -1] 
	else return string

    hi

Logic :


*/



static void solve(FastReader sc ) throws Exception {

    int t = sc.nextInt();
    // int t = 1;

    while(t-- > 0) {

    	String s = sc.next();
    	int len = s.length();
    	if(len > 10) {
    		System.out.println(s.charAt(0) +""+  (len-2) +"" +  s.charAt(len-1));
    	}
    	else {
    		System.out.println(s);
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