import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static ArrayDeque<Integer> a;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        a = new ArrayDeque<>();
        backtracking();
    }
    static void backtracking() throws IOException {
        if(a.size() == m){
            for(int i : a)
                bw.write(i + " ");
            bw.write("\n");
            bw.flush();
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                visited[i] = true;
                a.addLast(i);
                backtracking();
                a.removeLast();
                visited[i] = false;
            }
        }

    }

}
