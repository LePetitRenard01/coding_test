import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] tshirts = new int[6];
        for (int i = 0; i < 6; i++) {
            tshirts[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int res1 = 0;
        for (int tshirt : tshirts) {
            if(tshirt % t != 0) res1++;
            res1 += tshirt / t;
        }
        bw.write(res1 + "\n");
        bw.write(n/p + " " + n%p);
        bw.flush();
    }

}
