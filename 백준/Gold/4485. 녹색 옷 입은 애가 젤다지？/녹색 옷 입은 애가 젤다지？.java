import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            bw.write("Problem "+idx+++": "+test(n)+"\n");
        }
        bw.flush();
    }

    private static int test(int n) throws IOException {
        int[][] map = new int[n][n];
        int[][] visited = new int[n][n];
        for (int[] v : visited) Arrays.fill(v, Integer.MAX_VALUE);
        int[][] direction = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0, map[0][0]});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(visited[cur[0]][cur[1]] < cur[2]) continue;
            visited[cur[0]][cur[1]] = cur[2];
            for(int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(visited[nx][ny] <= cur[2] + map[nx][ny]) continue; //이미 더 적은 횟수로 방문했다면 컨티뉴
                visited[nx][ny] = cur[2] + map[nx][ny];
                pq.offer(new int[]{nx, ny, visited[nx][ny]});
            }
        }

        return visited[n-1][n-1];
    }
}
