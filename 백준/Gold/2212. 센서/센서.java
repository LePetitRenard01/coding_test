import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		
		for (int i = 0; i < n ; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int[] gap = new int[n-1];
		for (int i = 1; i < n; i++) gap[i-1] = arr[i] - arr[i-1];
		Arrays.sort(gap);
		
		int res = 0;
		for (int i = 0; i < n - k; i++) {
			res += gap[i];
		}
		
		bw.write(res+"");

		bw.flush();
		bw.close();
		br.close();
		
	}
}
