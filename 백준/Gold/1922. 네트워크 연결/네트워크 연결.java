import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge>{
    int dest;
    int dist;
    public Edge(int dest, int dist) {
        this.dest = dest;
        this.dist = dist;
    }
    public int compareTo(Edge o) {
        return dist - o.dist;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        bw.write(prim()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int prim() throws IOException {
        //선이 너무 많으니까 선 업데이트 방식으로
        // HashMap<Integer, Integer> dest, dist?
        //그럼 정렬 어떻게 하지? 그냥 Edge에 넣으면 되지.
        ArrayList<HashMap<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (graph.get(a).containsKey(b)) {
                graph.get(a).put(b, Math.min(graph.get(a).get(b), c));
            }
            else graph.get(a).put(b, c);

            if (graph.get(b).containsKey(a)) {
                graph.get(b).put(a, Math.min(graph.get(b).get(a), c));
            }
            else graph.get(b).put(a,c);
        }

        boolean visited[] = new boolean[n+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int result = 0;
        int cnt = 0;
        while(cnt < n){
            Edge e = pq.poll();

            if(visited[e.dest]) continue;
            visited[e.dest] = true;
            cnt++;
            result += e.dist;
            //큐에 엣지 넣기
            for (int i : graph.get(e.dest).keySet()){
                pq.add(new Edge(i, graph.get(e.dest).get(i)));
            }
        }
        return result;
    }
}
