import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long[] dp;
	public static void main(String[] args) throws IOException {
		long n = Long.parseLong(br.readLine());
		dp = new long[29];
		dp[0] = 3;
		for (int i = 1; i < 29; i++) {
			dp[i] = dp[i-1]*2 + 3 + i;
		}
		
		bw.write(moo(28, n)?"m":"o");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static boolean moo(int level, long n) throws IOException {
		
		if (level == 0) {
			return "moo".charAt((int)n-1)=='m';
		}
		if (n < dp[level-1]) {
			return moo(level-1, n);
		}else if(n == dp[level-1]) return false;
		else if(n == dp[level-1]+1) return true;
		else if (n <= dp[level-1] + level + 3) return false;
		else if (n < dp[level-1]*2 + level + 3) {
			return moo(level-1, n - (dp[level-1] + level + 3));
		}
		return false;
	}
}
