import java.util.*;


public class media_net_oa {
    /*
    Company : MEDIA.NET
    CTC : 41 LPA
    TOPICS : Graphs , Math , Number Theory , Hashing 


    Q. you are given and n*n matrix with values either +ve or -1 
    You can't travel cells which have the value -1
    
    You can travel to any adjacent row or column meaning up , down , left , right
    For each cell (i , j) you have to answer the sum of elements in the matrix that are unreachable
    from cell (i , j) and are multiples of i,j
    All values in the matrix are distinct

    Constraints :
    1<=n<=1e6 



    Analysis:

    Solution to Part I 
    Let's solve a simpler version of this problem
    1. For each cell in matrix output the number of +ve values that are unreachable from cell (i , j) 
    return the sum for all the cells
    Example --
    [1 2 -1]
    [4 -1 6]
    [-1 8 9]

    for cell (1,1) val = 1
    1 can go to 2, 4 but 1 can't go to 6 8 9. So, answer for cell(1,1) = 3 (no of unreachable nodes)
    similarly for cell (1,2) = 3
    ...
    return finally ans = 18

    Approach for Simple Version
    Break the matrix into components.
    Make a comp[][] matrix which will store the that any i , j belongs to which component
    start dfs from each node and mark all nodes as same component.
    Make a count array which stores the count of each component
    Now for each cell (i , j) ans = Total no of cells in all component i.e all positive values - 
    the no of the elements in the component which (i , j) belongs to.(current component)
        
    Next Follow-Up 
    What is the sum of all components which are not reachable 
    --> change requiered ?? store the total sum and in map for each component store the component sum

    Final problem
    For each cell value
    Generate all it's multiples from that number to 1e6
    Store all the numbers != -1 in the matrix with their frequencies
    ans = 0
    for each component in components
        remove all freq / contribution of that component from the map
        now the map only contains the freq of all other components except this component
        Now,
        for each item in component
            for each multiple of item from [item - 1e6]
                int freq_of_multiple = map.get(multiple)
                ans+= freq * multiple

        After processing each component we also have to go again in the same component and add the contribution to the map
    print(ans)            
    
3
1 2 -1
4 -1 6
-1 8 9
ans = 18


6
2  3  -1  4  5  6
2  -1  -1  5  4  3
8  9  10  -1 11 12
13 14  15  16 -1 -1
-1 17  18  19 20 21
22 23  -1  24 25 26
ans = 320
    
     */
    static int [][] graph , comp;
    static Map<Integer, Integer> cnt;
    static int [][] dir = {{0 , 1} , {1 , 0 } , { 0 , -1} , {-1 ,0 }};
    static int component_count , total;
     public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        graph = new int [n+1][n+1];
        comp = new int[n+1][n+1];
        boolean [][] vis = new boolean[n+1][n+1];
        for( int i = 1 ; i <= n ; i++ ) {
            for( int j = 1; j <= n ; j++  ) {
                graph[i][j]=s.nextInt();
                if (graph[i][j]  >= 1 ) {
                    total++;
                }
            }
        }
        cnt = new HashMap<>();
        int component_no = 1;
        component_count = 0;
        for( int i = 1 ; i <= n ; i++  ) {
            for ( int j = 1 ; j <= n ; j++ ) {
                if(!vis[i][j] && graph[i][j]!=-1) {
                    dfs( i , j  , component_no , vis , n);
                    cnt.put(component_no , component_count);
                    component_no++;
                    component_count =0;
                }
            }
        }
        long ans = 0L;
        for( int i : cnt.keySet()) {
            ans += cnt.get(i) * (total - cnt.get(i));
        }
        System.out.println(ans);
    }
    
    static void dfs(int r , int c  , int comp_no , boolean [][] vis , int n) {
        vis[r][c] = true;
        comp[r][c] = comp_no;
        component_count++;
        for( int  [] d : dir ){
            int nr = r+d[0] , nc= c+ d[1];
            if(nr>=1&&nc>=1&&nr<=n&&nc<=n && graph[nr][nc]!=-1 && !vis[nr][nc]) {
                //we can visit this node
                dfs(nr , nc , comp_no , vis , n);
            }
        }
        
    }
}
