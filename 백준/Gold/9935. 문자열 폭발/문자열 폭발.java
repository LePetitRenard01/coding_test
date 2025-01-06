import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        char[] str = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        char[] ans = new char[str.length];
        int idx = 0;

        for (char c : str) {
            if (idx >= target.length && hasTarget(idx, ans, target)) {
                idx -= target.length;
            }
            ans[idx++] = c;
        }
        if (idx >= target.length && hasTarget(idx, ans, target)) {
            idx -= target.length;
        }
        String res = new String(ans, 0, idx);
        bw.write( (res.equals(""))?"FRULA":res + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean hasTarget(int idx, char[] str, char[] target) {
        for (int i = 0; i < target.length; i++) {
            if (str[idx - target.length + i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
