import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[][] paper; // true - blue
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        paper = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = (Integer.parseInt(st.nextToken()) == 1)?true:false;
            }
        }

        divideConquer(0, 0, n);

        bw.write(white + "\n");
        bw.write(blue+"\n");
        bw.flush();
        bw.close();
    }

    static void divideConquer(int x, int y, int length){
        if(isAllSame(x, y, length)){
            if(paper[x][y]){
                blue++;
            }
            else white++;
            return;
        }
        divideConquer(x, y, length/2);
        divideConquer(x+length/2, y, length/2);
        divideConquer(x, y+length/2, length/2);
        divideConquer(x+length/2, y+length/2, length/2);
    }

    static boolean isAllSame(int x, int y, int length){
        boolean first = paper[x][y];
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                if(paper[i][j] != first)
                    return false;
            }
        }
        return true;
    }
}
