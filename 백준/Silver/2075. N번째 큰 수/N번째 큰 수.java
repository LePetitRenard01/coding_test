import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args ) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i*n+j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);
        bw.write(arr[arr.length-n]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
