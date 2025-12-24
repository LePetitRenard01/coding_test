import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] isWall;
    static int[] red = new int[2], blue = new int[2];
    static int[] goal = new int[2];
    static int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        init();
        execute();
    }

    private static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        isWall = new boolean[n][m];

        for (int i= 0 ; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m ; j++) {
                char cur = str.charAt(j);
                if (cur == '#') isWall[i][j] = true;
                else if (cur == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
                else if (cur == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                else if (cur == 'O') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
    }

    private static void execute() throws IOException {
        // R, B
        ArrayDeque<int[]> deque = new ArrayDeque<>(); // rx ry bx by n
        deque.add(new int[] {red[0], red[1], blue[0], blue[1], 0});
        // r b  경로 다르면 서순 ㄴ 상관
        // r b  경로 같으면 그 경로 방향으로 앞서는 거 먼저 이동
        //만약 공 빠지면  r이면 b 까지 해보고 break or continue
        // b 면 continue
        int res = -1;
        loop : while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            if (cur[4] == 10) break;

            int rx = cur[0];
            int ry = cur[1];
            int bx = cur[2];
            int by = cur[3];

            for (int[] d : direction) {
                // red precedent 확인 후
                // move(red, blue)
                // 아니면 move(blue, red)
                //red랑 blue 좌표 돌려주기
                // red가 goal이랑 같고, blue가 goal이랑 다르면 while문 끝내고
                // red랑 blue가 같으면 버리고
                int[] next,nextRed,nextBlue;
                if (isRedPrecedent(d, rx, ry, bx, by)){
                    next = move(d, new int[] {rx, ry}, new int[] {bx, by});
                    nextRed = new int[] {next[0], next[1]};
                    nextBlue = new int[] {next[2], next[3]};
                }
                else {
                    next = move(d, new int[] {bx, by}, new int[] {rx, ry});
                    nextRed = new int[] {next[2], next[3]};
                    nextBlue = new int[] {next[0], next[1]};
                }

                if (isOnSameLocation(nextRed, goal) && !isOnSameLocation(nextRed, nextBlue)) {
                    res = cur[4]+1;
                    break loop;
                } else if (isOnSameLocation(goal, nextBlue)) continue;
                deque.add(new int[] {nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], cur[4]+1});
            }
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isRedPrecedent(int[] d, int rx, int ry, int bx, int by) {
        // 1. rx == bx && d[1] != 0
        // 2. ry == by && d[0] != 0
        if (rx == bx && d[1] != 0)
            return (ry > by && d[1] == 1) || (ry < by && d[1] == -1);
        if (ry == by && d[0] != 0)
            return (rx > bx && d[0] == 1) || (rx < bx && d[0] == -1);
        return false;
    }

    private static int[] move(int[] d, int[] first, int[] second) {
        while (true){
            first[0] += d[0];
            first[1] += d[1];
            if (isOnSameLocation(goal, first)) break;
            if (isWall[first[0]][first[1]]) {
                first[0] -= d[0];
                first[1] -= d[1];
                break;
            }
        }

        while (true) {
            second[0] += d[0];
            second[1] += d[1];
            if (isOnSameLocation(first, second) && !isOnSameLocation(first, goal)) {
                second[0] -= d[0];
                second[1] -= d[1];
                break;
            }
            if (isOnSameLocation(goal, second)) break;
            if (isWall[second[0]][second[1]]) {
                second[0] -= d[0];
                second[1] -= d[1];
                break;
            }
        }
        return new int[] {first[0], first[1], second[0], second[1]};
    }

    private static boolean isOnSameLocation(int[] x, int[] y){
        return x[0] == y[0] && x[1] == y[1];
    }
}
