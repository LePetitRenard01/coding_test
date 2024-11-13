import java.util.*;
import java.io.*;
//벨만포드
//초기화 : integer.max_value 거리
// v-1 번 : 각 노드 i마다 연결된 로드 따라가면서 최단 업뎃
//v번째 : 바뀌면 음수 사이클
class Road{
	int next;
	int time;
}
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<HashMap<Integer,Integer>> graph; // graph.get(i) : i번째 노드의 연결된 도로의 map<next, cost>
	public static void main(String[] args) throws IOException {
		int tc = Integer.valueOf(br.readLine());
		for (int i = 0; i < tc ; i++) {
			solution();
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void solution() throws IOException{
		int n, m, w;
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		w = Integer.valueOf(st.nextToken());
		
		graph = new ArrayList<>();
		for (int i = 0; i < n+1; i++)
			graph.add(new HashMap<>());
		
		int s,e,t;
		for (int i = 0; i < m; i++) {
			//도로
			st = new StringTokenizer(br.readLine());
			s = Integer.valueOf(st.nextToken());
			e = Integer.valueOf(st.nextToken());
			t = Integer.valueOf(st.nextToken());
			addRoad(s,e,t);
			addRoad(e,s,t);
		}
		for (int i = 0; i < w; i++) {
			//웜홀
			st = new StringTokenizer(br.readLine());
			s = Integer.valueOf(st.nextToken());
			e = Integer.valueOf(st.nextToken());
			t = Integer.valueOf(st.nextToken());
			addRoad(s,e,-t);
		}
		
		bw.write(hasNegativeCycle()?"YES\n":"NO\n");
	}
	
	static void addRoad(int s, int e, int t) {
		if (graph.get(s).get(e) == null)
			graph.get(s).put(e, t);
		else if(graph.get(s).get(e) > t) {
			graph.get(s).replace(e, t);
		}		
	}
	
	static boolean hasNegativeCycle() {
		int[] dist = new int[graph.size()];
		Arrays.fill(dist, 0);
		dist[1] = 0;
		for (int i = 0; i < dist.length - 1; i++) {
			//최단 업뎃
			update(dist);
		}
		int[] extraDist = new int[dist.length];
		extraDist = Arrays.copyOf(dist, dist.length);
		//v번째 업뎃
		update(extraDist);
		for(int i = 0; i < dist.length; i++)
			if(dist[i] != extraDist[i])
				return true;
		return false;
	}
	
	static void update(int[] dist) {
		for (int i = 1; i < graph.size(); i++) {
			HashMap<Integer, Integer> map = graph.get(i);
			for (Integer key : map.keySet()) {
				if (dist[key] > dist[i] + map.get(key))
					dist[key] = dist[i] + map.get(key);
			}
		}
	}
}
