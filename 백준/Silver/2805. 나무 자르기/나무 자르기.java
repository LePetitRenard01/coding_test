import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int wood[];
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        wood = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(wood);

        System.out.println(binarySearch(m));
    }

    static int binarySearch(int m) {
        int high = wood[wood.length -1];
        int low = 0;
        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long remains = cutWood(mid);
            if (remains < m){
                high = mid - 1;
            }
            else {
                low = mid + 1;
                result = mid;
            }
        }
        return result;
    }

    static long cutWood(int target){
        long result = 0;
        for (int w : wood)
            result += w>target ? w - target : 0;
        return result;
    }
}
