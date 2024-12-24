import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(solution()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static long solution() throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        long[][] knapsack = new long[n+1][m+2];
        for(int i = 0; i <= n; i++) knapsack[i][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(coins[i] > j) {
                    knapsack[i][j] = knapsack[i-1][j];
                    continue;
                }
                for (int k = 0; k <= j/coins[i]; k++){
                    knapsack[i][j] += knapsack[i-1][j-k*coins[i]];
                }
            }

        }

        return knapsack[n][m];
    }
}
