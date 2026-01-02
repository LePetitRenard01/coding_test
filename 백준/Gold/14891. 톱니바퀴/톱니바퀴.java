import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] gear = new boolean[4][8]; // idx 0으로 점수 세고, 2, 6을 회전할 때 신경쓰기

    public static void main(String[] args) throws IOException {
        init();
        execute();
    }

    private static void init() throws IOException{
        for (int i = 0; i < gear.length ; i++) {
            String s= br.readLine();
            for (int j = 0; j < gear[0].length; j++) {
                gear[i][j] = s.charAt(j) == '1';
            }
        }
    }

    private static void execute() throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            boolean[] visited = new boolean[4];
            visited[num] = true;
            rotate(num, dir, visited);
        }

        int res = 0;
        for (int i = 0; i < gear.length; i++) {
            if (gear[i][0]) res += 1<<i;
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void printGear() throws IOException{
        bw.write("============================\n");
        for (int i = 0; i < gear.length; i++) {
            for (int j = 0 ; j < gear[0].length;j++)
                bw.write(gear[i][j]?"1":"0");
            bw.write("\n");
        }
        bw.write("============================\n");
    }

    private static void rotate(int num, int dir, boolean[] visited) {
        boolean left = gear[num][6];
        boolean right = gear[num][2];

        // 기어 회전
        // + 1 이면 7 -> 0, 0-> 1
        // - 1 이면 1 -> 0, 0-> 7
        int idx = 0;
        boolean prev = gear[num][(idx-dir+gear[num].length)%gear[num].length];
        for (int i = 0; i < gear[num].length; i++) {
            boolean tmp = gear[num][idx];
            gear[num][idx] = prev;
            prev = tmp;
            idx = (idx + dir + gear[num].length)%gear[num].length;
        }


        //왼쪽 기어
        if (num-1 >= 0 && left != gear[num-1][2] && !visited[num-1]) {
            visited[num-1] = true;
            rotate(num-1, dir*-1, visited);
        }
        //오른쪽 기어
        if (num+1 < gear.length && right != gear[num+1][6] && !visited[num+1]){
            visited[num+1] = true;
            rotate(num+1, dir*-1, visited);
        }
    }
}
