import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] numbers;
    static ArrayDeque<Integer> deque;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        deque = new ArrayDeque<>();
        numbers = new int[set.size()];
        int idx = 0;
        for (int i : set){
            numbers[idx++] = i;
        }
        Arrays.sort(numbers);
        backtracking(0);
        bw.flush();
    }
    private static void backtracking(int idx) throws IOException {
        if(deque.size() == m){
            for (int i : deque){
                bw.write(i +" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = idx; i < numbers.length; i++){
            deque.addLast(numbers[i]);
            backtracking(i);
            deque.removeLast();
        }
    }
}
