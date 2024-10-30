import java.io.*;
import java.util.*;
public class Main {
	static boolean[][] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new boolean[n+1][n+1];
		
		for (int i = 0; i < m; i++) {
			StringTokenizer token = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		visited = new boolean[n+1];
		dfs(v);
		
		visited = new boolean[n+1];
		bfs(v);
		
	}
	
	static void dfs(int start) {
		//스택
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayList<Integer> order = new ArrayList<>();
		stack.push(start);
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(visited[now])
				continue;
			visited[now] = true;
			order.add(now);
			for (int i = graph[now].length-1; i > 0 ;i--) {
				if(visited[i] || !graph[now][i])
					continue;
				stack.push(i);
			}
		}
		print(order);
	}
	
	static void bfs(int start) {
		ArrayList<Integer> order = new ArrayList<>();
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		deque.add(start);
		order.add(start);
		visited[start] = true;
		
		while(!deque.isEmpty()) {
			int now = deque.poll();
			for(int i = 0; i < graph[now].length; i++) {
				if(visited[i] || !graph[now][i])
					continue;
				deque.add(i);
				order.add(i);
				visited[i] = true;
			}
		}
		print(order);
	}
	
	static void print(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
