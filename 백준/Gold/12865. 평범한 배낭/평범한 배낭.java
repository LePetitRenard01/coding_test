import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        int[][] knapsack = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(weight[i] > j)
                    knapsack[i][j] = knapsack[i-1][j];
                else knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-weight[i]]+value[i]);
            }
        }

        bw.write(knapsack[n][k]+"");
        bw.flush();
        bw.close();
    }
}
