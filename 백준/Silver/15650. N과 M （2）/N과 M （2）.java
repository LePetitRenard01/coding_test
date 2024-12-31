import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n,m;
    static ArrayDeque<Integer> deque;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        deque = new ArrayDeque<>();
        visited = new boolean[n+1];
        backtracking(1);
    }
    static void backtracking(int idx)  throws IOException {
        if(deque.size() == m){
            for (int i : deque)
                bw.write(i + " ");
            bw.write("\n");
            bw.flush();
            return;
        }

        for (int i = idx; i <= n-m+1+deque.size(); i++){
            deque.addLast(i);
            backtracking(i+1);
            deque.removeLast();
        }
    }
}
