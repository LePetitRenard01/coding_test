import java.util.*;
import java.io.*;

public class Main {
    static private class Road implements Comparable<Road>{
        int prev;
        int next;
        int weight;

        Road(int prev, int next, int weight) {
            this.prev = prev;
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return weight - o.weight;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<HashMap<Integer, Integer>> roads;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //마을이 너무 커서 2개로 나눌것.
        // MST 구한 후 가장 비용 큰 길을 빕용에서 뺌
        roads = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            roads.add(new HashMap<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            checkRoad(a, b, c);
            checkRoad(b, a, c);
        }

        // edge 중심
        ArrayList<Road> updatedRoads = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            for (Integer j : roads.get(i).keySet()) {
                updatedRoads.add(new Road(i, j, roads.get(i).get(j)));
            }
        }

        Collections.sort(updatedRoads);

        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int result = 0;
        int edge = 0;
        int idx = 0;
        while (edge != n-1){
            Road road = updatedRoads.get(idx++);
            if (!union(parent, road.prev, road.next))
                continue;

            edge++;
            result += road.weight;
            if(edge == n-1) result -= road.weight;
        }

        bw.write(result + "");
        bw.flush();
    }

    static void checkRoad(int a, int b, int c) {
        if(!roads.get(a).containsKey(b) || roads.get(a).get(b) > c) { // a-b 거리가 없거나, 기존a-b거리가 더 값으 크면 새로 넣기
            roads.get(a).put(b, c);
        }
    }

    static int find(int[] parent, int target){
        if(parent[target] == target) return target;
        return parent[target] = find(parent, parent[target]);
    }

    static boolean union(int[] parent, int a, int b){
        int parentA = find(parent, a);
        int parentB = find(parent, b);
        if(parentA == parentB) return false;
        else if(parentA > parentB) parent[parentA] = parentB;
        else parent[parentB] = parentA;
        return true;
    }
}
