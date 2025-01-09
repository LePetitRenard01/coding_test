import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] board; // input 받는 배열
    static int[][] count; // 각 칸 당 해당 칸에 도달했을 때의 최대 칸 수
    static boolean[][] visited; // 각 칸 방문 여부 배열
    static boolean[] alphabet = new boolean[26]; // 방문했던 알파벳 배열
    static int[][] direction = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        board = new String[r];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine();
        }

        //초기화
        visited = new boolean[r][c];
        count = new int[r][c];

        //0,0 방문처리
        visited[0][0] = true;
        alphabet[board[0].charAt(0) - 'A'] = true;
        count[0][0] = 1;
        
        dfs(0,0, 1);

        int res = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res = Math.max(res, count[i][j]);
            }
        }
        bw.write(res+"");
        bw.flush();
    }

    private static void dfs(int x, int y, int cnt) {
        count[x][y] = Math.max(count[x][y], cnt);
        for (int[] d : direction) {
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length()) continue;
            if(visited[nx][ny]) continue;
            if(alphabet[board[nx].charAt(ny) - 'A']) continue;

            visited[nx][ny] = true;
            alphabet[board[nx].charAt(ny) - 'A'] = true;
            dfs(nx, ny, cnt+1);
            visited[nx][ny] = false;
            alphabet[board[nx].charAt(ny) - 'A'] = false;
        }
    }
}
