import java.io.*;
import java.util.*;

class Town implements Comparable<Town>{
	int num;
	int time;
	
	Town(int num, int time){
		this.num = num;
		this.time = time;
	}
	
	@Override
	public int compareTo(Town t) {
		return this.time - t.time;
	}

}

public class Main {
	static ArrayList<ArrayList<Town>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int x = Integer.valueOf(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++)
			graph.add(new ArrayList<>());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.valueOf(st.nextToken());
			int end = Integer.valueOf(st.nextToken());
			int time = Integer.valueOf(st.nextToken());
			
			graph.get(start).add(new Town(end, time));
		}
		
		int[] distance = dijkstra(x); // x에서 출발하는 최단거리(집으로 출발)
		for (int i = 1; i <= n; i++) {
			distance[i] += dijkstra(i)[x]; //i번 마을에서 출발하는 최단거리 중 x에 도착하는 경우(집에서 출발)
		}
		
		int answer = 0;
		for (int i = 1; i <= n; i++)
			answer = (answer > distance[i])?answer:distance[i];
		System.out.println(answer);
	}
	
	static int[] dijkstra(int start) {
		int[] distance = new int[graph.size()];
		boolean[] visited = new boolean[distance.length];
		PriorityQueue<Town> queue = new PriorityQueue<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		queue.add(new Town(start, 0));
		
		while(!queue.isEmpty()) {
			Town current = queue.poll();
			if (visited[current.num])
				continue;
			visited[current.num] = true;
			for (Town next : graph.get(current.num)) {
				if (visited[next.num] || distance[next.num] <= current.time + next.time)
					continue;
				distance[next.num] = current.time + next.time;
				queue.add(new Town(next.num, distance[next.num]));
			}
		}
		
		return distance;
	}
}
