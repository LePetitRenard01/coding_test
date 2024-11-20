import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<HashMap<Integer, Integer>> map;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            map.add(new HashMap<>());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(!map.get(a).containsKey(b) || map.get(a).get(b) > c)
                map.get(a).put(b, c);
        }

        long dist[] = new long[n+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        //v-1번 업뎃
        for (int i = 0; i < n-1; i++){
            for (int j = 1; j <= n; j++){
                for(int dest : map.get(j).keySet()){
                    if(dist[dest] > dist[j] + map.get(j).get(dest) && dist[j] != Long.MAX_VALUE)
                        dist[dest] = dist[j] + map.get(j).get(dest);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j : map.get(i).keySet()){
                if(dist[j] > dist[i] + map.get(i).get(j) && dist[i] != Long.MAX_VALUE){
                    bw.write("-1");
                    bw.flush();
                    return;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            bw.write(String.format("%d\n", (dist[i]!=Long.MAX_VALUE)?dist[i]:-1));
        }
        bw.flush();
    }
}
