import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static PriorityQueue<Long> ascendingQ;
    static PriorityQueue<Long> descendingQ;
    static HashMap<Long, Integer> map;
    public static void main(String[] args) throws IOException {
        //큐 2개 굴리기?
        //오름차순 큐, 내림차순 큐
        //근데 그럼 이미 삭제된건 어떻게 아나?
        //생각해보자 a 값 2개
        //오름차순에서 빼고, 내림차순에서 뺐을 때,
        //오름차순에서 다시 빼려고 한다면?
        //내림차순에 하나 남아있으므로 안심하고 뺄거임.
        //해결책1. 참조 타입 인스턴스 하나를 큐 양쪽에 넣어두고
        //int value, int cnt; 로 관리하면 되지 않나??????????
        //cnt = 0면 pop하기
        //문제 - 검색이 애매함
        //해결책2. 삽입된 숫자 cnt 관리하는 hashmap 기용
        //걱정 - 메모리 제한 괜찮나???
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            bw.write(solve()+"\n");
        }
        bw.flush();
    }

    static String solve() throws IOException {
        ascendingQ = new PriorityQueue<>((a, b) -> Long.compare(a, b));
        descendingQ = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        map = new HashMap<>(); // 데이터, 개수

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("I")){
                insert(Long.parseLong(st.nextToken()));
            }
            else delete(Integer.parseInt(st.nextToken()));
        }
        long maximum = poll(descendingQ);
        if (maximum == Long.MIN_VALUE) {
            return "EMPTY";
        }
        else map.put(maximum, map.getOrDefault(maximum, 0) + 1);
        long minimum = poll(ascendingQ);
        return maximum + " " + minimum;
    }

    static void insert(long x) {
        ascendingQ.add(x);
        descendingQ.add(x);
        map.put(x, map.getOrDefault(x, 0) + 1);
    }
    static void delete(int x) {
        long target = Long.MIN_VALUE;
        if (x == 1) target = poll(descendingQ);
        else if (x == -1) target = poll(ascendingQ);
    }

    static long poll(PriorityQueue<Long> pq) {
        if(pq.isEmpty())
            return Long.MIN_VALUE;
        long target = pq.poll();
        if (map.containsKey(target) && map.get(target) > 0){
            map.put(target, map.get(target) - 1);
        }
        else target = poll(pq);
        return target;
    }
}
