import java.io.*;
import java.util.*;
//https://codeforces.com/problemset/problem/158/B
public class vkCup_B implements Runnable {
final static long mod = 1_000_000_007L;
static PrintWriter out;


public static void main(String[] args) {
    new Thread(null, new vkCup_B (), "whatever", 1 << 30).start();
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

	
	car can take max 4 passengers.
	one group is max 4 passengers so on booking one car we can take atleast one group

	so for each team if we book one car then it would be n cars for n teams.

	the point here is not all the teams have 4 passengers so we can accomodate two or more teams..

	we will go through all teams and then keep a variable to check totak passengers the moment it 
	surpasses >4 we mark it as a new car and set the variable to that a[i]..


	so it is best to accomodate the teams with the least no of people first..

	idea again is to sort the array...


Logic :


*/



static void solve(FastReader sc ) throws Exception {

    // int t = sc.nextInt();
    int t = 1;

    while(t-- > 0) {

    	int n = sc.nextInt();
    	int [] arr = new int[n];
    	for( int i = 0; i < n ;i++) arr[i] = sc.nextInt();
    	Arrays.sort(arr);
    	int res = 0;
    	int i = 0;
    	int j = n-1;

		while(i<=j) {
			int spaceLeft = 4 - arr[j];
			j--;
			//this group at j is processed..
			res++; // one car occupied

			//check for as many more groups you can accomodate...
			while(i<=j && spaceLeft >= arr[i]) {
				spaceLeft -= arr[i];
				i++;
			}
		}
		
		System.out.println(res);
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