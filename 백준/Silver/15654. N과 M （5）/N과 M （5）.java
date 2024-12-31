import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] numbers;
    static ArrayDeque<Integer> deque;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        numbers = new int[n];
        deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        backtracking();
        bw.flush();
    }
    private static void backtracking() throws IOException {
        if(deque.size() == m){
            for(int i : deque){
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                deque.addLast(numbers[i]);
                backtracking();
                deque.removeLast();
                visited[i] = false;
            }
        }
    }
}
