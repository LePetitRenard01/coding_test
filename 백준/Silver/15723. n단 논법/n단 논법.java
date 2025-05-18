import java.io.*;
import java.util.HashMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int num = 0;
        boolean[][] isIncluded = new boolean[26][26];
        for (int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            if(!map.containsKey(s[0])){
                map.put(s[0], num++);
            }
            if (!map.containsKey(s[2])){
                map.put(s[2], num++);
            }

            isIncluded[map.get(s[0])][map.get(s[2])] = true;
        }

        for (int k = 0; k < num; k++){
            for (int i = 0; i < num; i++) {
                for (int j = 0; j < num; j++){
                    if (isIncluded[i][k]&&isIncluded[k][j])
                        isIncluded[i][j] = true;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++){
            String[] s = br.readLine().split(" ");
            if(map.containsKey(s[0]) && map.containsKey(s[2])){
                bw.write(isIncluded[map.get(s[0])][map.get(s[2])]?"T\n":"F\n");
            }
            else bw.write("F\n");
        }

        bw.flush();
        bw.close();
    }
}
