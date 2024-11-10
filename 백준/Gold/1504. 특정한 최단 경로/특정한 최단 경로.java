import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	int num;
	int weight;
	
	Node(int num, int weight){
		this.num = num;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.weight - n.weight;
	}
}

public class Main {
	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int e = Integer.valueOf(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.valueOf(st.nextToken());
		int v2 = Integer.valueOf(st.nextToken());
		
		int answer1 = calculate(v1,v2);
		int answer2 = calculate(v2,v1);
		int answer = (answer1<answer2)? answer1 : answer2;
		System.out.println((answer==Integer.MAX_VALUE)?-1:answer);
	}
	static int calculate(int v1, int v2) {
		int result = 0;
		int tmp = dijkstra(1, v1);
		if(tmp == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		result += tmp;

		tmp = dijkstra(v1, v2);
		if(tmp == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		result += tmp;

		tmp = dijkstra(v2,graph.size()-1);
		if(tmp == Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		result += tmp;

		return result;
	}
	
	static int dijkstra(int v1, int v2) {
		int[] distance = new int[graph.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(v1, 0));
		
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if(distance[now.num] < now.weight)
				continue;
			distance[now.num] = now.weight;
			for (Node next : graph.get(now.num)) {
				if(distance[next.num] <= now.weight + next.weight)
					continue;
				distance[next.num] = now.weight + next.weight;
				queue.add(new Node(next.num, distance[next.num]));
			}
		}
		
		return distance[v2];
	}

}
