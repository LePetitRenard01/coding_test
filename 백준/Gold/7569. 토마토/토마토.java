import java.io.*;
import java.util.*;

public class Main {
	static int n = 0;
	static int m = 0;
	static int h = 0;
	static int[][][] tomatoes;
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static ArrayDeque<int[]> queue;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		h = Integer.valueOf(st.nextToken());
		tomatoes = new int[h][m][n];
		
		queue = new ArrayDeque<>();
		
		boolean isAllRipe = true;
		for (int i = 0; i < h; i++) {
			for(int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					tomatoes[i][j][k] = Integer.valueOf(st.nextToken());
					if (tomatoes[i][j][k] == 1)
						queue.add(new int[] {i,j,k,0});
					else if (tomatoes[i][j][k] == 0)
						isAllRipe = false;
				}
			}
		}

		if(isAllRipe)
			bw.write("0");
		else
			bw.write(String.valueOf(bfs()));
		bw.flush();
		bw.close();
	}
	
	static int bfs() {
		int answer = 0;
		while(!queue.isEmpty()) {
			int cur[] = queue.pop();
			for(int i = 0; i < 6; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				int nz = cur[2] + dz[i];
				if(nx<0 || nx >= h || ny < 0 || ny >= m || nz < 0 || nz >= n) continue;
				if(tomatoes[nx][ny][nz] != 0) continue;
				tomatoes[nx][ny][nz] = 1;
				queue.add(new int[] {nx,ny,nz, cur[3]+1});
				answer = cur[3] + 1;
			}
		}
	
		for (int[][] box : tomatoes) {
			for (int[] row : box) {
				for (int tomato : row) {
					if (tomato == 0) return -1;
				}
			}
		}
		return answer;
	}
}