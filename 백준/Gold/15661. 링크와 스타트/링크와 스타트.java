import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] ability;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        ability = new int[n][n];
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                ability[i][j] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 1<<n; i++){
            int[] status = new int[n];
            int oneCnt = 0;
            for (int j = 0; j < n; j++){
                if ((i & (1<<j)) != 0) {
                    status[j] = 1;
                    oneCnt++;
                }
            }
            min = Math.min(min, calculate(status, oneCnt));
        }

        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int calculate(int[] status, int oneCnt){
        int zero = 0;
        int one = 0;
        int zeroTeam[] = new int[status.length-oneCnt];
        int oneTeam[] = new int[oneCnt];

        int i=0, j=0;
        for (int k = 0; k < status.length; k++){
            if(status[k] == 0) zeroTeam[i++]  = k;
            else oneTeam[j++] = k;
        }

        for(i =0; i<zeroTeam.length;i++){
            for (j = i+1; j < zeroTeam.length;j++)
                zero += ability[zeroTeam[i]][zeroTeam[j]] + ability[zeroTeam[j]][zeroTeam[i]];
        }

        for (i = 0; i < oneTeam.length; i++){
            for (j = i+1; j < oneTeam.length;j++)
                one += ability[oneTeam[i]][oneTeam[j]] + ability[oneTeam[j]][oneTeam[i]];
        }

        return Math.abs(one - zero);
    }
}
