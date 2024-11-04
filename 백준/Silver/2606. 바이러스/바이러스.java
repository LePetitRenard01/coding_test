import java.util.*;
import java.io.*;

public class Main{
	static ArrayList<ArrayList<Integer>> al;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		
		visited = new boolean[n+1];
		al = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			al.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			al.get(a).add(b);
			al.get(b).add(a);
		}
		
		System.out.println(bfs());
	}
	
	static int bfs() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		visited[1] = true;
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.pop();
			for (int next : al.get(now)) {
				if (visited[next])
					continue;
				visited[next] = true;
				queue.add(next);
				cnt++;
			}
		}
		
		return cnt;
	}
}