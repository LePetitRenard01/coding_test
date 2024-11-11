import java.util.*;
import java.io.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		int n = Integer.valueOf(br.readLine());
		int idx = 1;
		while(n != 0) {
			solution(n, idx++);
			n = Integer.valueOf(br.readLine());
		}
		
		
		br.close();
		bw.close();
	}
	
	static void solution(int num, int idx) throws IOException {
		
		int answer = 0;
		int map[][] = new int[num][num];
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < num; j++) {
				map[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		answer = dijkstra(map);
		bw.write("Problem "+idx+": "+ answer+"\n");
	}
	
	static int dijkstra(int[][] map) {
		int n = map.length;
		int m = map[0].length;
		int[][] cost = new int[n][m]; //{0,0}에서 해당 좌표까지의 최소 cost
		for(int[] c : cost) {
			Arrays.fill(c, Integer.MAX_VALUE);
		}
		cost[0][0] = map[0][0];
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[2], b[2]));
		queue.add(new int[] {0,0,cost[0][0]});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curCost = cur[2];
			for (int i = 0; i < 4; i++) {
				int nX = cur[0] + d[i][0];
				int nY = cur[1] + d[i][1];
				if(nX < 0 || nX >= n || nY < 0 || nY >= m)
					continue;
				if(cost[nX][nY] <= map[nX][nY] + curCost)
					continue;
				cost[nX][nY] = map[nX][nY] + curCost;
				queue.add(new int[] {nX,nY,cost[nX][nY]});
			}
		}
			
		return cost[n-1][m-1];
	}
}
