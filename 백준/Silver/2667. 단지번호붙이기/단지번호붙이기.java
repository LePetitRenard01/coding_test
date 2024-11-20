import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    static int map[][];
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> unit = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    unit.add(bfs(i,j));
                }
            }
        }
        Collections.sort(unit);
        bw.write(unit.size()+"\n");
        for(int i : unit){
            bw.write(i+"\n");
        }
        bw.flush();
    }

    static int bfs(int startX, int startY){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        map[startX][startY] = 2; //방문
        int cnt = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + d[i][0];
                int ny = cur[1] + d[i][1];
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
                    continue;
                if(map[nx][ny] != 1)
                    continue;
                map[nx][ny] = 2;
                queue.add(new int[]{nx, ny});
                cnt++;
            }

        }
        return cnt;
    }
}
