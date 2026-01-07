import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//kruskal edge 
	static int parents[];
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parents = new int[n+1];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		ArrayList<int[]> edges = new ArrayList<>();
		
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new int[] {a,b,c});
		}
		
		Collections.sort(edges, (a,b) -> a[2] - b[2]);
		
		int res = 0;
		int cnt = 0;
		for (int[] e : edges) {
			if(find(e[0]) != find(e[1])) {
				res += e[2];
				union(e[0], e[1]);
				if (++cnt == n-1) {
					break;
				}
			}
		}
		
		bw.write(res+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}

	private static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA > parentB) parents[parentA] = parentB;
		else if (parentA < parentB) parents[parentB] = parentA;
		else return false;
		return true;
	}
}
