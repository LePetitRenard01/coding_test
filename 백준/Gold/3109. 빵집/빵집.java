import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] empty;
    static int[] directX = {-1,0,1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        empty = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0 ; j < c; j++){
                empty[i][j] = str.charAt(j) == '.';
            }
        }

        int cnt = 0;
        for (int i = 0; i < r; i++){
            if (dfs(i,0))
                cnt++;
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean dfs(int x, int y) {
        if (y == empty[0].length - 1)
            return true;

        for (int dx: directX){
            int nx = x + dx;
            int ny = y + 1;
            if (nx < 0|| nx >= empty.length || ny < 0 || ny >= empty[0].length)
                continue;
            if(!empty[nx][ny]) continue;
            empty[nx][ny] = false;
            if (dfs(nx, ny))
                return true;
        }

        return false;
    }
}
