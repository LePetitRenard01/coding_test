import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<ArrayList<int[]>> graph;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int m = Integer.valueOf(br.readLine());
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        visited = new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());
            graph.get(start).add(new int[] {end, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int end = Integer.valueOf(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        dist[start] = 0;
        queue.add(new int[]{start, 0});

        while(!queue.isEmpty()) {
            int[] now = queue.poll(); //destination, distance
            int current = now[0];
            int distance = now[1];
            if (visited[current]) continue;
            visited[current] = true;
            for (int[] candidate : graph.get(now[0])) {
                int next = candidate[0];
                int weight = candidate[1];
                if(dist[next] <= distance + weight)
                    continue;
                dist[next] = distance + weight;
                queue.add(new int[] {next, dist[next]});
            }
        }
        return dist[end];
    }
}