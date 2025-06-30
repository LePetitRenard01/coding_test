
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] roof = new int[h];
        int[] floor = new int[h];

        for (int i = 0 ; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (i%2==0){
                floor[h-tmp]++;
            }
            else roof[tmp-1]++;
        }
        
        // 누적합
        for (int i = h-2; i >= 0; i--){
            roof[i] += roof[i+1];
        }

        for (int i = 1; i < h; i++){
            floor[i] += floor[i-1];
        }

        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < h; i++){
            if (min > floor[i] + roof[i]){
                min = floor[i] + roof[i];
                res = 1;
            }
            else if (min == floor[i] + roof[i])
                res++;
        }

        bw.write(min+" "+res);
        bw.flush();
        bw.close();
        br.close();
    }
}
