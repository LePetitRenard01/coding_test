import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] field;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        field = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(divideConquer(0, 0, n));
    }

    static int divideConquer(int x, int y, int length){
        if(length == 1)
            return field[x][y];
        int arr[] = new int[4];
        arr[0] = divideConquer(x, y, length/2);
        arr[1] = divideConquer(x+length/2, y, length/2);
        arr[2] = divideConquer(x, y+length/2, length/2);
        arr[3] = divideConquer(x+length/2, y+length/2, length/2);
        Arrays.sort(arr);
        return arr[2];
    }
}
