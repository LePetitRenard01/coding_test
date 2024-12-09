import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder[] sbs = divideConquer(n);
        for(StringBuilder sb : sbs){
            bw.write(sb.toString()+"\n");
        }
        bw.flush();
    }

    static StringBuilder[] divideConquer(int len) {
        if(len == 1) return new StringBuilder[]{new StringBuilder("*")};
        StringBuilder[] unit = divideConquer(len/3);
        StringBuilder[] res = new StringBuilder[len];
        for (int i = 0; i < len; i++) {
            res[i] = new StringBuilder();
        }

        for(int i = 0; i < unit.length; i++){
            res[i].append(unit[i]).append(unit[i]).append(unit[i]);
        }
        for(int i = 0; i < unit.length; i++){
            res[i + unit.length].append(unit[i]);
            for (int j = 0; j < unit.length; j++)
                res[i + unit.length].append(" ");
            res[i + unit.length].append(unit[i]);
        }
        for(int i = 0; i < unit.length; i++){
            res[i + unit.length*2].append(unit[i]).append(unit[i]).append(unit[i]);
        }

        return res;
    }
}
