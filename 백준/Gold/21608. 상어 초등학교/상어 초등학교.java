import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int map[][];
    static int direction[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int likes[][];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        likes = new int[n*n+1][4];

        for (int i = 0; i < n*n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int member = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) likes[member][j] = Integer.parseInt(st.nextToken());

            ArrayList<int[]> location = new ArrayList<>();
            // (x,y)가 빈 자리면
            // x, y에 대해 1. likeCnt, 2. emptyCnt 구해서 location에 넣기
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] != 0 ) continue;
                    int[] loc = new int[4];
                    loc[0] = x; loc[1] = y;
                    for (int[] d : direction){
                        int nx = x + d[0];
                        int ny = y + d[1];
                        if (nx < 0|| nx>=n || ny < 0 || ny >= n) continue;
                        if (map[nx][ny] == 0) {
                            loc[3]++;
                            continue;
                        }
                        if (isWhomMemberLikes(member,nx,ny)) loc[2]++;
                    }
                    location.add(loc);
                }
            }
            Collections.sort(location, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[2] != o2[2]) return o2[2] - o1[2];
                    if (o1[3] != o2[3]) return o2[3] - o1[3];
                    if (o1[0] != o2[0]) return o2[0] - o1[0];
                    return o2[1] - o1[1];
                }
            });

            map[location.get(0)[0]][location.get(0)[1]] = member;
        }

        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) {
                int likeCnt = 0;
                for (int[] d: direction){
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if (nx < 0|| nx>=n || ny < 0 || ny >= n) continue;
                    if (isWhomMemberLikes(map[i][j], nx, ny)) likeCnt++;
                }
                if (likeCnt == 0) continue;
                res += (int)Math.pow(10, likeCnt - 1);
            }
        }
        bw.write(res+"");
        bw.flush();
    }

    private static boolean isWhomMemberLikes(int member, int x, int y) {
        for (int l : likes[member]){
            if (map[x][y] == l) {
                return true;
            }
        }
        return false;
    }
}
