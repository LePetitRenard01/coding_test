import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static ArrayDeque<Integer> deque;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();
        backtracking(1);
        bw.flush();
    }

    static void backtracking(int idx) throws IOException {
        if(deque.size() == m){
            for(int i : deque)
                bw.write(i + " ");
            bw.write("\n");
            return;
        }
        for(int i = idx; i <= n; i++){
            deque.addLast(i);
            backtracking(i);
            deque.removeLast();
        }
    }
}
