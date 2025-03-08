import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] province = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            province[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, province[i]);
        }
        int budget = Integer.parseInt(br.readLine());

         int low = 0;
         int high = max;
         int res = 0;
         while (low <= high){
             int mid = (low+high)/2;
             int sum = distribute(province, mid);
             if (sum > budget){
                 high = mid-1;
             } else {
                 low = mid + 1;
                 res = mid;
             }
         }
         bw.write(res+"");
         bw.flush();
    }

    static int distribute(int[] province, int mid) {
        int res = 0;
        for (int p : province){
            res += Math.min(p, mid);
        }
        return res;
    }
}
