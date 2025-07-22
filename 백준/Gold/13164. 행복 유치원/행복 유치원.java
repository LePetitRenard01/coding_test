import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n-1];
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr.length; i++){
            int cur= Integer.parseInt(st.nextToken());
            arr[i] = cur-prev;
            prev = cur;
        }
        Arrays.sort(arr);

        int res = 0;
        for (int i = 0; i < arr.length - (k-1); i++) {
            res += arr[i];
        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
