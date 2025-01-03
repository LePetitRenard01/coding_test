import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] game;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        game = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(max()+" ");
        bw.write(min()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int max() {
        int[][] dp = new int[game.length][3];
        for (int i = 0; i < 3; i++)
            dp[0][i] = game[0][i];

        for (int i = 1; i < dp.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]) + game[i][0];
            dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])) + game[i][1];
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]) + game[i][2];
        }

        return Math.max(dp[dp.length-1][0], Math.max(dp[dp.length-1][1], dp[dp.length-1][2]));
    }

    private static int min() {
        int[][] dp = new int[game.length][3];
        for (int i = 0; i < 3; i++)
            dp[0][i] = game[0][i];

        for (int i = 1; i < dp.length; i++){
            dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + game[i][0];
            dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2])) + game[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2]) + game[i][2];
        }

        return Math.min(dp[dp.length-1][0], Math.min(dp[dp.length-1][1], dp[dp.length-1][2]));
    }
}
