import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
    int src; //kruskal에서만 쓰임
    int dest;
    int dist;

    Node(int dest, int dist){
        this.dest = dest;
        this.dist = dist;
    }

    Node(int src, int dest, int dist){
        this.src = src;
        this.dest = dest;
        this.dist = dist;
    }

    public int compareTo(Node n){
        return dist - n.dist;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int v;
    static int e;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        bw.write(kruskal()+"");
        bw.flush();
        bw.close();
        br.close();
    }

    //프림 - 노드 중심
    static long prim() throws IOException {
        boolean[] vis = new boolean[v+1];
        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < v+1; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>();
        q.add(new Node(1, 0));

        long result = 0;
        while(!q.isEmpty()){
            Node cur = q.poll(); // 이번에 추가될 노드.

            if(vis[cur.dest]) continue; // 이미 MST 내에 있는지 확인.
            vis[cur.dest] = true;
            result += cur.dist;

            //이 노드를 추가함으로써 선택 가능한 선들 추가.
            for (Node next : graph.get(cur.dest)){
                if(!vis[next.dest]){
                    q.add(next);
                }
            }
        }

        return result;
    }

    static long kruskal() throws IOException{
        ArrayList<Node> graph = new ArrayList<Node>();
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Node(a, b, c));
        }

        Collections.sort(graph);

        int[] parent = new int[v+1];
        for(int i = 0; i < v+1; i++){
            parent[i] = i;
        }

        int cnt = 0;
        long result = 0;
        for (int i = 0; i < graph.size(); i++){
            Node cur = graph.get(i);
            if(union(parent, cur.src, cur.dest)){
                result += cur.dist;
                cnt++;
            }
            if (cnt == v-1)
                break;
        }
        return result;
    }

    static int find(int parent[], int i){
        if(parent[i] == i) return i;
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static boolean union(int parent[], int i, int j){
        int parentA = find(parent, i);
        int parentB = find(parent, j);
        if(parentA == parentB) return false;
        else if(parentA > parentB)
            parent[parentA] = parentB;
        else
            parent[parentB] = parentA;
        return true;
    }
}
