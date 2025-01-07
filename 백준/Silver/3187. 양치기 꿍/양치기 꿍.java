import java.util.*;
import java.io.*;
public class Main {
    private static class Animal{
        boolean isSheep = false;
        int cnt = 0;

        Animal(boolean isSheep, int cnt){
            this.isSheep = isSheep;
            this.cnt = cnt;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] map;
    static boolean[][] visited;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        visited = new boolean[r][c];
        int sheep = 0, wolf = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    Animal animal = bfs(i, j);
                    if (animal.isSheep) sheep += animal.cnt;
                    else wolf += animal.cnt;
                }
            }
        }

        bw.write(sheep + " " + wolf);
        bw.flush();
    }

    private static Animal bfs(int x, int y) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});
        visited[x][y] = true;

        int sheep = 0, wolf = 0;
        if(map[x][y] == 'k') sheep++;
        else if(map[x][y] == 'v') wolf++;

        while (!deque.isEmpty()) {
            int[] cur = deque.pop();
            for (int i = 0; i < direction.length; i++) {
                int nx = cur[0] + direction[i][0];
                int ny = cur[1] + direction[i][1];
                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }
                if (map[nx][ny] == '#' || visited[nx][ny]) continue; //울타리거나 방문했던 좌표 시
                visited[nx][ny] = true;
                if(map[nx][ny] == 'k') sheep++;
                else if (map[nx][ny] == 'v') wolf++;
                deque.add(new int[]{nx, ny});
            }
        }

        return new Animal(sheep>wolf, Math.max(sheep, wolf));
    }
}
