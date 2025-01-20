import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int M;
    static ArrayList<ArrayList<Integer>> map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int result = Integer.MAX_VALUE;
        int x = 0, y = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i; j <= N; j++) {
                int temp = dijkstra(i, j);
                if (temp < result){
                    x = i;
                    y = j;
                    result = temp;
                }
            }
        }

        bw.write(String.format("%d %d %d", x, y, result));
        bw.flush();
    }

    private static int dijkstra(int x, int y) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int distance[] = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.offer(x);
        pq.offer(y);
        distance[x] = 0;
        distance[y] = 0;

        while (!pq.isEmpty()) {
            int loc = pq.poll();
            for (int next : map.get(loc)){
                if (distance[next] <= distance[loc] + 2) continue;
                distance[next] = distance[loc] + 2;
                pq.offer(next);
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }

        return sum;
    }
}
