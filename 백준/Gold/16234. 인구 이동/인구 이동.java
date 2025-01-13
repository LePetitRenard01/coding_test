import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static boolean[][] visited;
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    static int l, r;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        while(true){
            visited = new boolean[n][n];
            boolean doesEnd = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;
                    if (hasMovement(i,j))
                        doesEnd = false;
                }
            }
            if (doesEnd) break;
            res++;
        }

        bw.write(res + "");
        bw.flush();
    }

    private static boolean hasMovement(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> neighbors = new ArrayList<>();
        queue.addLast(new int[]{x, y});
        neighbors.add(new int[]{x, y});
        visited[x][y] = true;

        int cnt = 1;
        int sum = map[x][y];

        while (!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if( nx < 0 || nx >= map.length || ny < 0 || ny>= map[0].length || visited[nx][ny]) continue;
                int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if (diff < l || diff > r) continue;
                visited[nx][ny] = true;
                sum += map[nx][ny];
                cnt++;
                neighbors.add(new int[]{nx, ny});
                queue.addLast(new int[]{nx,ny});
            }
        }

        if (cnt == 1) return false;

        int res = sum / cnt;
        for (int[] loc : neighbors) {
            map[loc[0]][loc[1]] = res;
        }
        return true;
    }
}
