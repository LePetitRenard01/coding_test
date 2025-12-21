import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[][] standard;

    public static void main(String[] args) throws IOException {
        init();
        bw.flush();
        bw.close();
        br.close();
    }

    static void init() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        standard = new int[n][n];

        for (int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                standard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] matrix = divideconquer(b);

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) throws IOException {
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0 ; j < matrix[0].length; j++) {
                matrix[i][j] %= 1000;
                if(j!= matrix[0].length-1) bw.write(matrix[i][j]+" ");
                else bw.write(matrix[i][j]+"");
            }
            bw.write("\n");
        }
    }

    static int[][] divideconquer(long square) {
        if (square == 1) return standard;
        if (square == 2) return multiply(standard, standard);

        int[][] matrix = divideconquer(square/2);
        if (square%2==0) return multiply(matrix, matrix);
        else return multiply(multiply(matrix,matrix),standard);
    }

    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int tmp = 0;
                for (int m = 0; m < a[0].length; m++) {
                        tmp += a[i][m]*b[m][j];
                        tmp %= 1000;
                }
                result[i][j] = tmp;
            }
        }
        return result;
    }
}
