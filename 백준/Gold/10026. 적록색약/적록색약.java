import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static short[][] map;
    static boolean[][] visitedA;
    static boolean[][] visitedB;
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new short[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                switch (s.charAt(j)) {
                    case 'R': {
                        map[i][j] = 2;
                        break;}
                    case 'G':{
                        map[i][j] = 1;
                        break;
                    }
                    case 'B':{
                        map[i][j] = 0;
                        break;
                    }
                }
            }
        }
        
        //적록색약
        visitedA = new boolean[n][n];
        int cntA = 0;

        //비적록색약
        visitedB = new boolean[n][n];
        int cntB = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedA[i][j]) {
                    bfsA(i, j, visitedA);
                    cntA++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedB[i][j]) continue;
                if (map[i][j] == 0) {
                    bfsA(i, j, visitedB);
                }
                else {
                    bfsB(i, j, visitedB);
                }
                cntB++;
            }
        }

        bw.write(cntA + " "+cntB);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfsA(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        short std = map[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (visited[nx][ny] || map[nx][ny] != std) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    private static void bfsB(int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y});
        short std = map[x][y];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) continue;
                if (visitedB[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}
