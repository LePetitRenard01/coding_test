import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean isFriend[][];
    static int twoFriend[];
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        isFriend = new boolean[n][n];
        for (int i = 0; i < n; i++){
            String s = br.readLine();
            for (int j = 0; j<n;j++){
                isFriend[i][j] = s.charAt(j) == 'Y';
            }
        }

        twoFriend = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(i == j) continue;
                else if (isFriend[i][j]) {
                    twoFriend[i]++;
                }
                else{
                    for (int k = 0; k < n ; k++)
                        if (i != k && j!=k && isFriend[j][k] && isFriend[i][k]){
                            twoFriend[i]++;
                            break;
                        }
                }
            }
        }

        int res = 0;
        for (int i : twoFriend) res = Math.max(res, i);
        bw.write(res+"");
        bw.flush();
    }
}
