
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args ) throws Exception{
        int x = Integer.parseInt(br.readLine());
        String s = Integer.toBinaryString(x);
        int last = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1') last = i;
        }
        if (last ==0) bw.write((int)Math.pow(2,s.length()-1)+" 0");
        else bw.write((int)Math.pow(2,s.length())+" "+ (last+1));
        bw.flush();
        bw.close();
        br.close();
    }
}
