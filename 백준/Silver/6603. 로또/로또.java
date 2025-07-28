import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb;
    static int[] stack = new int[6];

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        while(true){
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            build(0,0,arr);

            bw.write(sb.append("\n").toString());
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void build(int start, int idx, int[] arr) {
        if (idx == 6) {
            for (int i = 0; i < stack.length-1; i++) {
                sb.append(stack[i]+" ");
            }
            sb.append(stack[5]+"\n");
            return;
        }
        for (int i = start; i <= arr.length - (6-idx); i++){
            stack[idx] = arr[i];
            build(i+1, idx+1, arr);
        }
    }
}
