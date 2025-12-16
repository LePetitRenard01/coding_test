import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        solve();
    }
    
    static void solve() throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];
        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(tokens[i]);
        }

        int left = 0;
        int right = liquid.length - 1;
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        // 음수인 동안
        while (left < right) {
            // right 줄이면서 커지는 구간 찾기
            int localMin = Integer.MAX_VALUE;
            while (left < right) {
                if (Math.abs(liquid[left] + liquid[right]) <= localMin) {
                    localMin = Math.abs(liquid[left] + liquid[right]);
                    right--;
                }
                else break;
            }
            right++;

            if (localMin < min) {
                res[0] = left;
                res[1] = right;
                min = localMin;
            }

            left++;
        }

        bw.write(liquid[res[0]] +" " + liquid[res[1]]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
