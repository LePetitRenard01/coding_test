import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] isWall;
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        init();
        execute();
        bw.close();
        br.close();
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isWall = new boolean[n][m];

        for (int i= 0 ;i < n ; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                isWall[i][j] = str.charAt(j) == '1';
            }
        }
    }

    private static void execute() throws IOException {
        int[][][] space = new int[isWall.length][isWall[0].length][2]; // 넓이, 영역 표시
        int[][] movable = new int[isWall.length][isWall[0].length];
        boolean[][] hasVisited = new boolean[isWall.length][isWall[0].length];

        //isWall false인 곳 땅 넓이 구해서 다 채워넣기
        int flag = 1;
        for (int i = 0; i < isWall.length; i++) {
            for (int j = 0; j < isWall[0].length; j++) {
                if (!isWall[i][j] && !hasVisited[i][j]) {
                    fillSpace(hasVisited, space, i, j, flag);
                    flag++;
                }
            }
        }
        //isWall true인 곳은 상하좌우만 더해서 값 구하기
        HashSet<Integer> set;
        for (int i = 0; i < isWall.length; i++) {
            for (int j = 0; j < isWall[0].length; j++) {
                if (isWall[i][j]) {
                    movable[i][j] = 1;
                    set = new HashSet<>();
                    for (int[] d : direction) {
                        int nx = i + d[0];
                        int ny = j + d[1];
                        if (nx < 0 || nx >= isWall.length || ny < 0 || ny >= isWall[0].length)
                            continue;
                        if (set.contains(space[nx][ny][1])) continue;
                        set.add(space[nx][ny][1]);
                        movable[i][j] += space[nx][ny][0];
                    }
                    movable[i][j] %= 10;
                }
            }
        }

        for (int[] row : movable) {
            for (int m : row) bw.write(m+"");
            bw.write("\n");
        }
        bw.flush();
    }

    private static void fillSpace(boolean[][] hasVisited, int[][][] space, int x, int y, int flag) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        ArrayList<int[]> loc = new ArrayList<>();
        deque.add(new int[]{x, y});
        loc.add(new int[] {x, y});
        hasVisited[x][y] = true;
        int res = 1;

        while (!deque.isEmpty()) {
            int[] cur =  deque.poll();
            for (int[] d : direction) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];
                if (nx < 0 || nx >= isWall.length || ny < 0 || ny >= isWall[0].length) continue;
                if (isWall[nx][ny] || hasVisited[nx][ny]) continue;
                res++;
                hasVisited[nx][ny] = true;
                deque.add(new int[] {nx, ny});
                loc.add(new int[] {nx, ny});
            }
        }

        for (int[] l : loc) {
            space[l[0]][l[1]][0] = res;
            space[l[0]][l[1]][1] = flag;
        }
    }
}
