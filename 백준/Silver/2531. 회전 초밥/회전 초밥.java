import java.io.*;
import java.util.*;

public class Main {
	static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[n+k-1];
		for (int i = 0; i < n; i++) belt[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < k-1; i++) belt[n+i] = belt[i];
		
		HashMap<Integer, Integer> sushi = new HashMap<>();
		int left = 0;
		int right = k-1;
		for(int i = left ; i<= right; i++) {
			sushi.put(belt[i], sushi.getOrDefault(belt[i], 0)+1);
		}
		
		int res = sushi.containsKey(c)?sushi.size():sushi.size()+1;
		
		while(right < belt.length-1) {
			++right;
			sushi.put(belt[right], sushi.getOrDefault(belt[right], 0)+1);
			sushi.put(belt[left], sushi.get(belt[left])-1);
			if(sushi.get(belt[left])==0) sushi.remove(belt[left]);
			
			++left;
			res = Math.max(res, sushi.containsKey(c)?sushi.size():sushi.size()+1);
		}
		
		bw.write(res+"");
		bw.flush();
	}
}
