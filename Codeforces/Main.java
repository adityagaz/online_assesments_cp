import java.util.*;

public class Main {

	static char [][] g;
	static int [][] fire_time;
	static int [][] reach_time;
	static boolean [][] vis;
	static int [][] dir = {{1,0} , {0 , 1  } , {-1 , 0} , {0 , -1}};
	static int si , sj , gi , gj , fi , fj , n ,m;
	
	static List<int [] > blow;
	public static void main(String [] args ) {
		Scanner s = new Scanner(System.in);
		
		int t = s.nextInt();
		while(t-- >0) {
			
			n = s.nextInt();
			m = s.nextInt();

		g = new char[n][m];
		fire_time = new int[n][m];
		reach_time = new int[n][m];
		vis  = new boolean[n][m];
		blow = new ArrayList<>();
		// we have to take care and fill all our reach_time , fire_time as int max;
		for( int [] i : fire_time) {

			Arrays.fill(i , (int) 1e7);

		}
// 
		// for( int [] i : reach_time) {
// 
			// Arrays.fill(i , (int) 1e7);
		// }
		s.nextLine();
		for( int i  =0 ; i < n ;  i++ ) {
			String ip = s.nextLine();
			g[i] = ip.toCharArray();
		}
		
	

		for( int i = 0; i < n ; i++ ) {
			for( int j = 0; j < m ; j++ ) {
				if(g[i][j]=='S') {
					si = i;
					sj = j;

				}
				if(g[i][j] == 'E') {
					gi = i;
					gj = j;
				}

				if(g[i][j] == 'F') {
					// fi = i;
					// fj = j;
					blow.add(new int [] {i , j});
				}
			}	
		}
		
		

		bfs(fi , fj , fire_time , true);
		vis = new boolean[n][m]; 
		bfs(si ,  sj , reach_time , false); 
// 		
// 		
		// for (int [] i : reach_time) {
			// System.out.println(Arrays.toString(i));
		// }
		// System.out.println();
		// for (int [] i : fire_time) {
			// System.out.println(Arrays.toString(i));
		// }
		//edge case -- if fire also can't reach and so as we then we it will be -1'
		if(reach_time[gi][gj] == 0 )  {
			// the answer is not possible
			System.out.println(-1);
		}
		else {
			System.out.println(reach_time[gi][gj]);
		}

		/*
			9
			3 3
			S.E
			...
			...
			5 5
			S...E
			.###.
			F...#
			.#.#.
			.....
			4 4
			S..E
			.##.
			.F..
			....
			4 4
			S...
			.##F
			..#E
			....
			3 3
			#F#
			FS#
			#E#
			3 3
			SE.
			..F
			...
			3 3
			S#E
			###
			F..
			3 3
			SF.
			..E
			...
			5 8
			S......E
			........
			....F...
			........
			........


			Expected -
			
			2
			4
			3
			-1
			1
			1
			-1
			-1
			-1


		*/
		
			
		}
		


	}

	static void bfs(int i,int  j , int [][] mat , boolean flag) {
		Queue<int []> q = new LinkedList<>();

		
		if(flag) {
			for( int [] f : blow) {
				q.add(new int [] {f[0] , f[1]});
				mat[f[0]][f[1]] = 0;
				vis[f[0]][f[1]]=true;
			}
			
		}
		else {
			q.add(new int [] {i , j});
			vis[i][j] = true;

			mat[i][j] = 0;
		}

		while(!q.isEmpty()) {
			int [] curr = q.poll();
			for( int  [] d:dir ) {
				int ni  = curr[0] + d[0]; 
				int nj = curr[1] + d[1]; 
				if(!inRange(ni , nj)) continue; 
				if(g[ni][nj] == '#') continue;
				if(vis[ni][nj]) continue;
				vis[ni][nj] = true;
				if(!flag ) {
					if( 1 + mat[curr[0]][curr[1]] < fire_time[ni][nj]) {
						q.add(new int [] {ni , nj});
						mat[ni][nj] = 1 + mat[curr[0]][curr[1]] ;
					}
					else{
						continue;
					}
				}
				else {
					q.add(new int [] {ni , nj});	
					mat[ni][nj] = 1 + mat[curr[0]][curr[1]] ;
				}
			}
		}
	}
	

	
	static boolean  inRange( int i , int j )  {
		return (i>=0&&j>=0&&i<n&&j<m);
	}
}
