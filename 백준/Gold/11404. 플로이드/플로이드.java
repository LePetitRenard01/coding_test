import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] graph;
	static final int MAX = 100_000_000;
	public static void main(String[] args) throws IOException{
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		graph = new int[n+1][n+1];
		for (int[] g : graph)
			Arrays.fill(g, MAX);
		for (int i = 1; i < graph.length; i++)
			graph[i][i] = 0;
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			if (graph[a][b] > c)
				graph[a][b] = c;
		}
		
		//floyd-warshall
		for(int  k = 1; k < graph.length; k++) {
			for(int i = 1; i < graph.length; i++) {
				for(int j = 1; j < graph.length; j++) {
					if(graph[i][j] > graph[i][k] + graph[k][j])
						graph[i][j] = graph[i][k] + graph[k][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < graph.length; i++) {
			for (int j = 1; j < graph.length; j++) {
				int dist = graph[i][j];
				if(dist == MAX)
					sb.append(0).append(" ");
				else
					sb.append(dist).append(" ");
			}
			sb.append("\n");
		}
		bw.write(new String(sb));
		bw.flush();
	}

}
