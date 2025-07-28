
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] direction = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static boolean[][] isEmpty, hasVisited;
    static int res = 0, k;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        isEmpty = new boolean[r][c];
        hasVisited = new boolean[r][c];

        for (int i = 0; i<r; i++){
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                isEmpty[i][j] = s.charAt(j) != 'T';
            }
        }

        hasVisited[r-1][0] = true;
        visit(r-1, 0, 1);

        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void visit(int x, int y, int cnt) throws IOException {
        if (x == 0 && y == isEmpty[0].length-1 && cnt == k){
            res++;
            return;
        }
        else if (cnt == k) return;

        for (int[] d : direction) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < 0 || nx >= isEmpty.length || ny < 0 || ny >= isEmpty[0].length) continue;
            if (!isEmpty[nx][ny]) continue;
            if (hasVisited[nx][ny]) continue;
            hasVisited[nx][ny] = true;
            visit(nx, ny, cnt+1);
            hasVisited[nx][ny] = false;
        }
    }
}
