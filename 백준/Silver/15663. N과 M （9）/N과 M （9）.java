import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] cnt;
    static ArrayDeque<Integer> deque;
    static HashMap<Integer, Integer> map; // <number/cnt>
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        numbers = new int[map.size()];
        cnt = new int[map.size()];
        int idx = 0;
        for(int i : map.keySet()){
            numbers[idx++] = i;
        }
        Arrays.sort(numbers);
        backtracking();
        bw.flush();
    }

    private static void backtracking() throws IOException {
        if (deque.size() == m){
            for (int i : deque)
                bw.write(i+" ");
            bw.write("\n");
            return;
        }

        for(int i = 0; i < map.size();i++){
            if(cnt[i] < map.get(numbers[i])){
                cnt[i]++;
                deque.addLast(numbers[i]);
                backtracking();
                cnt[i]--;
                deque.removeLast();
            }
        }
    }
}
