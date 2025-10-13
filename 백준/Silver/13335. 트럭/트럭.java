import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 개수
        int m = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 최대 하중

        st = new StringTokenizer(br.readLine());
        int[] truck = new int[n];
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            q.offer(0);
        }

        int cnt = 0;
        int sum = 0;
        int idx = 0;
        while (!q.isEmpty()) {
            cnt++;
            sum -= q.poll();
            if (idx >= n) {
                while (sum > 0) {
                    cnt++;
                    sum -= q.poll();
                }
                break;
            }
            else if (sum + truck[idx] <= l) {
                sum += truck[idx];
                q.addLast(truck[idx]);
                idx++;
            } else q.addLast(0);
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
