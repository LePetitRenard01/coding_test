import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int knapsack[][] = new int[n+1][100];
        int[] weight = new int[n+1];
        int[] value = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++)
            value[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 100; j++) {
                if(weight[i] > j) knapsack[i][j] = knapsack[i-1][j];
                else knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-weight[i]]+value[i]);
            }
        }

        bw.write(knapsack[n][99]+"");
        bw.flush();
    }
}
