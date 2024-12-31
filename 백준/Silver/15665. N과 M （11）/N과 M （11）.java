import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] numbers;
    static int[] stack;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new int[n];
        visited = new boolean[n];
        stack = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        backtracking(0);
        bw.flush();
    }

    static void backtracking(int cnt) throws IOException {
        if(cnt == m){
            for (int i : stack) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        int before = 0;
        for(int i = 0; i < n; i++){
            if(before != numbers[i]){
                stack[cnt] = numbers[i];
                visited[i] = true;
                backtracking(cnt + 1);
                visited[i] = false;
                before = numbers[i];
            }
        }
    }
}
