import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int res = Integer.MAX_VALUE;

    // 대륙 구분 bfs 1회
    // 대륙 각 점에서 bfs 후 가장 짧은
    public static void main(String[] args) throws IOException {
        init();
        execute();
    }

    private static void init() throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i= 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int flag = 2;
        for (int i = 0; i < n ;i ++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) setFlag(i, j, flag++);
            }
        }
    }

    private static void setFlag(int x, int y, int flag) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {x, y});
        map[x][y] = flag;

        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            for (int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) continue;
                if (map[nx][ny] != 1) continue;
                map[nx][ny] = flag;
                deque.add(new int[] {nx, ny});
            }
        }
    }

    private static void printMap() throws IOException {
        for (int[] m : map) {
            for (int i : m) bw.write(i+" ");
            bw.write("\n");
        }
    }
    private static void execute() throws IOException {
        // flag 있는 곳에서 다른 flag 있는 곳까지 거리 계산
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 0) res = Math.min(res, buildBridge(i,j));
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
    }

    private static int buildBridge(int x, int y) {
        int stdFlag = map[x][y];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {x, y, 0});
        boolean[][] visited = new boolean[map.length][map[0].length];
        visited[x][y] = true;

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[2] > res) return cur[2];
            for (int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                if (visited[nx][ny] || map[nx][ny] == stdFlag) continue;
                if (map[nx][ny] != 0) return cur[2];
                visited[nx][ny] = true;
                deque.add(new int[] {nx, ny, cur[2] + 1});
            }
        }
        return Integer.MAX_VALUE;
    }
}
