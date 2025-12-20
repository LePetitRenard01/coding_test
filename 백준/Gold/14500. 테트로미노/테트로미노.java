import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] map;
    static int res = 0;

    static int[][][] tet = {{{0,0},{0,1},{0,2},{0,3}},//일자
            {{2,0},{1,0},{0,0},{0,1}},//L
            {{2,0},{1,0},{1,1},{0,1}},//z모양
            {{0,0},{0,1},{0,2},{1,1}},//ㅗ 모양
            {{0,0},{0,1},{1,0},{1,1}}};//정사각형

    public static void main(String[] args) throws IOException {
        init();
        calculate();
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
    }

    static void calculate() throws IOException {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0 ; j < map[0].length; j++){
                for (int k = 0; k < tet.length; k++) {
                    // k번째의 tet 내의 좌표들을
                    // (i,j) (h-i,j) (i,w-j) (h-i,w-j) 별로 계산
                    execute(i,j,k,1,1, false);
                    if (k==tet.length-1) continue;
                    execute(i,j,k,1,1, true);
                    execute(i,j,k,-1,1, false);
                    execute(i,j,k,-1,1, true);
                    execute(i,j,k,1,-1, false);
                    execute(i,j,k,1,-1, true);
                    execute(i,j,k,-1,-1, false);
                    execute(i,j,k,-1,-1, true);
                }
            }
        }

        bw.write(res+"");
    }

    static void execute(int x, int y, int k, int diffX, int diffY, boolean reverse) throws IOException {
        int localRes = 0;
        for (int i = 0; i < tet[k].length; i++){
            int nx = diffX * tet[k][i][0];
            int ny = diffY * tet[k][i][1];

            if (reverse) {
                int temp = nx;
                nx = ny;
                ny = temp;
            }

            nx += x;
            ny += y;

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;

            localRes += map[nx][ny];
        }

        res = Math.max(res, localRes);
    }


}
