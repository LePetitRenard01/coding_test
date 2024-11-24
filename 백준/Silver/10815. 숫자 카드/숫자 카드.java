import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		while(stringTokenizer.hasMoreTokens())
			set.add(Integer.valueOf(stringTokenizer.nextToken()));
		int m = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			if (set.contains(Integer.valueOf(st.nextToken())))
				bw.write(String.valueOf(1)+" ");
			else
				bw.write(String.valueOf(0)+" ");
		}
		bw.close();
		br.close();
	}
}