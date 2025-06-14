import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] map;
    static int[][][] dp;

    private static final int[][] direction = {{0,1}, {1,1},{1,0}};//가로 대각선 세로
    private static final int[][] way = {{0,1},{0,1,2},{1,2}};
    private static final int[][] area = {{0},{0,1,2},{2}};

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) { // 현재 파이프 상태
                    for (int p = 0; p < way[k].length; p++) { // 다음 파이프 상태
                        int x = direction[way[k][p]][0] + i;
                        int y = direction[way[k][p]][1] + j;
                        if (x < 0 || x >= n || y < 0 || y >= n) continue;
                        if (map[x][y] == 1) continue;
                        if(!isValid(i, j, way[k][p])) continue;
                        dp[x][y][way[k][p]] += dp[i][j][k];
                    }
                }
            }
        }

        bw.write(dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2] +"");

        bw.flush();
        bw.close();

    }

    private static boolean isValid(int x, int y , int state) {
        for (int i = 0; i < area[state].length; i++) {
            if(map[x+direction[area[state][i]][0]][y+direction[area[state][i]][1]] == 1)
                return false;
        }
        return true;
    }
}
