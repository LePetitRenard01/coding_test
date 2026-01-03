import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args ) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int area = 0;
        while (left < arr.length-1) {
            right = left + 1;

            int localMax = arr[right];
            int tmpRight = right;
            //arr[left]보다 큰 수 중 가장 왼쪽에 있는 arr[right]
            while(right < arr.length) {
                if (localMax < arr[right]) {
                    tmpRight = right;
                    localMax = arr[right];
                }
                if (arr[left] <= arr[right])
                    break;
                right++;
            }

            int std = Math.min(arr[left], arr[tmpRight]);
            for (int i = left+1; i < tmpRight; i++){
                area += std - arr[i];
            }
            left = tmpRight;
        }

        bw.write(area+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
