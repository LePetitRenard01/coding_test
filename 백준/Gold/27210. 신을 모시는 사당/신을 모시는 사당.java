import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int stone = 0;          // 돌 방향 (1 또는 2)
        int prefix_sum = 0;     // 사당을 돌면서 생기는 누적합
        int min = prefix_sum;   // 현재 상태인 0으로 초기화
        int max = prefix_sum;
        for (int i=0; i<n; i++) {
            stone = Integer.parseInt(st.nextToken());
            // 돌의 뱡향 체크
            if (stone == 1) {
                prefix_sum++; // +1
            } else {
                prefix_sum--; // -1
            }
            min = Math.min(min, prefix_sum);
            max = Math.max(max, prefix_sum);
        }

        // 최대한 많은 깨달음의 양
        // = 최대한 큰(많은) 변화량 (특정 구간 [i, j]에서의 변화량: 누적합[j] − 누적합[i-1])
        // = 누적합 최대 - 누적합 최소
        System.out.println(max-min);
    }
}