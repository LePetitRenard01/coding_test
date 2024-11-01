import java.io.*;
import java.util.*;
public class Main {
	static String[] maze;
	static int[][] dist;
	static int n = 0;
	static int m = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		dist = new int[n][m];
		for (int i = 0; i < n ; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		maze = new String[n];
		for(int i = 0; i < n; i++) {
			maze[i] = br.readLine();
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0,0});
		dist[0][0] = 1;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.pop();
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || nx >= n || ny < 0 || ny >= m) continue;
				if(dist[nx][ny] <= dist[cur[0]][cur[1]]+1) continue;
				if(maze[nx].charAt(ny)=='0') continue;
				dist[nx][ny] = dist[cur[0]][cur[1]]+1;
				queue.push(new int[] {nx,ny});
			}
		}
		return dist[n-1][m-1];
	}
}
