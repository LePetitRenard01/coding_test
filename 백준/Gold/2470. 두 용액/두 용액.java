import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int left = 0; int right = n - 1;
        int min = Integer.MAX_VALUE;
        int resL = -1, resR = -1;
        while (left < right) {
            int localMin = Integer.MAX_VALUE;
            while (left < right) {
                if (Math.abs(arr[left] + arr[right]) <= localMin) {
                    localMin = Math.abs(arr[left] + arr[right]);
                    right--;
                }
                else break;
            }

            right++;

            if (localMin < min) {
                min = localMin;
                resL = left;
                resR = right;
            }
            left++;
        }

        bw.write(arr[resL] + " " + arr[resR]);
        bw.flush();
        br.close();
        bw.close();
    }
}
